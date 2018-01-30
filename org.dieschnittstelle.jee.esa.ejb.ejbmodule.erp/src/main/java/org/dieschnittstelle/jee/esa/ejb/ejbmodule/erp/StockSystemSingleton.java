package org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp;

import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud.PointOfSaleCRUDLocal;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud.PointOfSaleCRUDStateless;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud.StockItemCRUDLocal;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud.StockItemCRUDStateless;
import org.dieschnittstelle.jee.esa.entities.erp.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.entities.erp.PointOfSale;
import org.dieschnittstelle.jee.esa.entities.erp.StockItem;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Robin on 08.12.2016.
 */
@WebService(targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", serviceName = "StockSystemWebService" , endpointInterface = "org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.StockSystemRemote")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
@Singleton
public class StockSystemSingleton implements StockSystemLocal, StockSystemRemote {

    @EJB
    private PointOfSaleCRUDLocal posEJB;
    @EJB
    private StockItemCRUDLocal stockItemEJB;

    @Override
    public void addToStock(IndividualisedProductItem product, long pointOfSaleId, int units) {
        PointOfSale pos = posEJB.readPointOfSale(pointOfSaleId);
        //check if stockitem already exists and update it if so
        StockItem item = stockItemEJB.readStockItem(product, pos);
        if(item != null){
            item.setUnits(item.getUnits() + units);
            stockItemEJB.updateStockItem(item);
            return;
        }
        // if not exist create a new one
        item = new StockItem(product, pos, units);
        stockItemEJB.createStockItem(item);
    }

    @Override
    public void removeFromStock(IndividualisedProductItem product, long pointOfSaleId, int units) {
        addToStock(product, pointOfSaleId, -units);
    }

    @Override
    public List<IndividualisedProductItem> getProductsOnStock(long pointOfSaleId) {
        List<IndividualisedProductItem> resultList = stockItemEJB.readStockItemsForPointOfSale(posEJB.readPointOfSale(pointOfSaleId))
                .stream()
                .map(StockItem::getProduct)
                .collect(Collectors.toList());
        return resultList;
    }

    @Override
    public List<IndividualisedProductItem> getAllProductsOnStock() {
        //use a set because then you got no doubles
        // "Der Zugriff auf readAllStockItems() ist dabei nicht zulässig" s. aufgabe jpa4 anforderung 3
        Set<IndividualisedProductItem> resultSet = new HashSet<>();
        posEJB.readAllPointsOfSale()
                .forEach(p -> {
                    resultSet.addAll(getProductsOnStock(p.getId()));
                });
        return new ArrayList<>(resultSet);
    }

    @Override
    public int getUnitsOnStock(IndividualisedProductItem product, long pointOfSaleId) {
        StockItem item = stockItemEJB.readStockItem(product, posEJB.readPointOfSale(pointOfSaleId));
        if(item == null) return 0;
        return item.getUnits();
    }

    @Override
    public int getTotalUnitsOnStock(IndividualisedProductItem product) {
        int result = 0;
        for(PointOfSale p : posEJB.readAllPointsOfSale()){
            result += getUnitsOnStock(product, p.getId());
        }
        return result;
    }

    @Override
    public List<Long> getPointsOfSale(IndividualisedProductItem product) {
        List<Long> resultList = new ArrayList<>();
        stockItemEJB.readStockItemsForProduct(product).forEach(stockItem -> {
                resultList.add(stockItem.getPos().getId());
        });
        return resultList;
    }

    @Override
    public List<StockItem> getCompleteStock() {
        return null;
    }
}
