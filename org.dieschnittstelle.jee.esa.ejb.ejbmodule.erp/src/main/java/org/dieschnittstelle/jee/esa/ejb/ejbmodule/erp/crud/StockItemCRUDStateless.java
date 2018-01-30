package org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud;

import org.dieschnittstelle.jee.esa.entities.erp.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.entities.erp.PointOfSale;
import org.dieschnittstelle.jee.esa.entities.erp.ProductAtPosPK;
import org.dieschnittstelle.jee.esa.entities.erp.StockItem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Robin on 02.01.2017.
 * Stateless EJB
 */
@Stateless
public class StockItemCRUDStateless implements StockItemCRUDLocal {

    @PersistenceContext(unitName = "crm_erp_PU")
    private EntityManager em;

    @Override
    public StockItem createStockItem(StockItem item) {
        //workaround preventtion of objectpersistentexp. like descriped in parent interface
        item = em.merge(item);
        em.persist(item);
        return item;
    }

    @Override
    public StockItem readStockItem(IndividualisedProductItem prod, PointOfSale pos) {
        ProductAtPosPK key = new ProductAtPosPK(prod, pos);
        StockItem item = em.find(StockItem.class, key);
        return item;
    }

    @Override
    public StockItem updateStockItem(StockItem item) {
        return em.merge(item);
    }

    @Override
    public List<StockItem> readAllStockItems() {
        List<StockItem> resultList = em.createQuery("From StockItem").getResultList();
        return resultList;
    }

    @Override
    public List<StockItem> readStockItemsForProduct(IndividualisedProductItem prod) {
        List<StockItem> resultList = em.createQuery("SELECT s FROM StockItem s WHERE s.product = "
                        + prod.getId()).getResultList();
        return resultList;
    }

    @Override
    public List<StockItem> readStockItemsForPointOfSale(PointOfSale pos) {
        List<StockItem> resultList = em.createQuery("Select s from StockItem s where s.pos = "
                + pos.getId())
                .getResultList();
        return resultList;
    }
}
