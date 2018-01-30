package org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm.shopping;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm.*;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.StockSystemLocal;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud.ProductCRUDLocal;
import org.dieschnittstelle.jee.esa.entities.crm.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.entities.crm.CrmProductBundle;
import org.dieschnittstelle.jee.esa.entities.crm.Customer;
import org.dieschnittstelle.jee.esa.entities.crm.CustomerTransaction;
import org.dieschnittstelle.jee.esa.entities.erp.AbstractProduct;
import org.dieschnittstelle.jee.esa.entities.erp.Campaign;
import org.dieschnittstelle.jee.esa.entities.erp.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.entities.erp.ProductBundle;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.List;

/**
 * Created by Robin on 12.01.2017.
 */
@Stateful
public class ShoppingSessionFacadeStateful implements ShoppingSessionFacade {

    protected static Logger logger = Logger.getLogger(ShoppingSessionFacadeStateful.class);

    /*
     * the three beans that are used
     */

    @EJB
    private ShoppingCartLocal shoppingCart;
    @EJB
    private CustomerTrackingLocal customerTracking;
    @EJB
    private CampaignTrackingLocal campaignTracking;
    @EJB
    private ProductCRUDLocal productCRUD;
    @EJB
    private StockSystemLocal stockSystem;

    /**
     * the customer
     */
    private Customer customer;
    /**
     * The shopping session
     */
    private CustomerTransaction session;

    /**
     * the touchpoint
     */
    private AbstractTouchpoint touchpoint;

    public void setTouchpoint(AbstractTouchpoint touchpoint) {
        this.touchpoint = touchpoint;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(AbstractProduct product, int units) {
        this.shoppingCart.addProductBundle(new CrmProductBundle(product.getId(), units, product instanceof Campaign));
    }

    /*
     * verify whether campaigns are still valid
     */
    public void verifyCampaigns() {
        if (this.customer == null || this.touchpoint == null) {
            throw new RuntimeException("cannot verify campaigns! No touchpoint has been set!");
        }

        for (CrmProductBundle productBundle : this.shoppingCart.getProductBundles()) {
            if (productBundle.isCampaign()) {
                int availableCampaigns = this.campaignTracking.existsValidCampaignExecutionAtTouchpoint(
                        productBundle.getErpProductId(), this.touchpoint);
                logger.info("got available campaigns for product " + productBundle.getErpProductId() + ": "
                        + availableCampaigns);
                // we check whether we have sufficient campaign items available
                if (availableCampaigns < productBundle.getUnits()) {
                    throw new RuntimeException("verifyCampaigns() failed for productBundle " + productBundle
                            + " at touchpoint " + this.touchpoint + "! Need " + productBundle.getUnits()
                            + " instances of campaign, but only got: " + availableCampaigns);
                }
            }
        }
    }

    public void purchase() {
        logger.info("purchase()");

        if (this.customer == null || this.touchpoint == null) {
            throw new RuntimeException(
                    "cannot commit shopping session! Either customer or touchpoint has not been set: " + this.customer
                            + "/" + this.touchpoint);
        }

        // verify the campaigns
        verifyCampaigns();

        // remove the products from stock
        checkAndRemoveProductsFromStock();

        // then we add a new customer transaction for the current purchase
        List<CrmProductBundle> products = this.shoppingCart.getProductBundles();
        CustomerTransaction transaction = new CustomerTransaction(this.customer, this.touchpoint, products);
        transaction.setCompleted(true);
        session = transaction;
        customerTracking.createTransaction(transaction);

        logger.info("purchase(): done.\n");
    }

    /*
     * to be implemented as server-side method for PAT2
     */
    private void checkAndRemoveProductsFromStock() {
        logger.info("checkAndRemoveProductsFromStock");

        for (CrmProductBundle productBundle : this.shoppingCart.getProductBundles()) {
            if (productBundle.isCampaign()) {
                this.campaignTracking.purchaseCampaignAtTouchpoint(productBundle.getErpProductId(), this.touchpoint,
                        productBundle.getUnits());
                Campaign campaign = (Campaign) productCRUD.readProduct(productBundle.getErpProductId()); //1
                for(ProductBundle bundle : campaign.getBundles()){//2
                    int orderedProducts = bundle.getUnits() * productBundle.getUnits();//3
                    final int totalProducts = stockSystem.getUnitsOnStock(bundle.getProduct(), touchpoint.getErpPointOfSaleId());
                    if(orderedProducts <= totalProducts){
                        stockSystem.removeFromStock(bundle.getProduct(),touchpoint.getErpPointOfSaleId() , orderedProducts);
                    }else{
                        throw new ShoppingException(ShoppingException.ShoppingSessionExceptionReason.STOCK_EXCEEDED);
                    }
                }
                // wenn Sie eine Kampagne haben, muessen Sie hier
                // 1) zunaechst das Campaign-Objekt anhand der erpProductId von productBundle auslesen
                // 2) dann ueber die ProductBundle Objekte auf dem Campaign Objekt iterieren und
                // 3) fuer jedes ProductBundle das betreffende Produkt in der auf dem Bundle angegebenen Anzahl, multipliziert mit dem Wert von
                // productBundle.getUnits() aus dem Warenkorb,
                // - hinsichtlich Verfuegbarkeit ueberpruefen, und
                // - falls verfuegbar aus dem Warenlager entfernen
                // (Anm.: productBundle.getUnits() sagt Ihnen, wie oft ein Produkt, im vorliegenden Fall eine Kampagne, im
                // Warenkorb liegt)
            } else {
                IndividualisedProductItem prod = (IndividualisedProductItem) productCRUD.readProduct(productBundle.getErpProductId()); //1
                final int totalProducts = stockSystem.getUnitsOnStock(prod, touchpoint.getErpPointOfSaleId());
                if(productBundle.getUnits() <= totalProducts){ //2
                    stockSystem.removeFromStock(prod, touchpoint.getErpPointOfSaleId(), productBundle.getUnits());
                }else{
                    throw new ShoppingException(ShoppingException.ShoppingSessionExceptionReason.STOCK_EXCEEDED);
                }
                // andernfalls (wenn keine Kampagne vorliegt) muessen Sie
                // 1) das Produkt (dann IndividualisedProductItem) anhand der erpProductId von productBundle auslesen, und
                // 2) das Produkt in der in productBundle.getUnits() angegebenen Anzahl hinsichtlich Verfuegbarkeit ueberpruefen und
                // 3) das Produkt, falls verfuegbar, aus dem Warenlager entfernen

                // Schritt 1) koennen Sie ggf. auch mit Typ AbstractProduct vor
                // die if/else Verzweigung bezueglich isCampaign() platzieren -
                // in jedem Fall benoetigen Sie hierfuer Zugriff auf Ihre
                // ProductCRUD EJB
            }

        }
    }

    @PreDestroy
    public void saveTransaction() {
        if(session == null || !session.isCompleted()){
            customerTracking.createTransaction(new CustomerTransaction(customer,
                    touchpoint, shoppingCart.getProductBundles()));
            logger.info("Shopping transaction not finished. Created Customer" +
                    " transaction and passed it to the customerTracking bean");
        }
    }
}
