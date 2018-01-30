package org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.crud;

import org.dieschnittstelle.jee.esa.entities.erp.AbstractProduct;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Robin on 15.12.2016.
 */
@Stateless
public class ProductCRUDStateless implements ProductCRUDRemote, ProductCRUDLocal {

    @PersistenceContext(unitName = "crm_erp_PU")
    private EntityManager em;

    @Override
    public AbstractProduct createProduct(AbstractProduct prod) {
        em.persist(prod);
        return prod;
    }

    @Override
    public List<AbstractProduct> readAllProducts() {
        List<AbstractProduct> resultList = em.
                createQuery("Select a from AbstractProduct a", AbstractProduct.class)
                .getResultList();
        return resultList;
    }

    @Override
    public AbstractProduct updateProduct(AbstractProduct update) {
        AbstractProduct result = em.merge(update);
        return result;
    }

    @Override
    public AbstractProduct readProduct(long productID) {
        AbstractProduct result = em.find(AbstractProduct.class, productID);
        return result;
    }

    @Override
    public boolean deleteProduct(long productID) {
        AbstractProduct result = em.find(AbstractProduct.class, productID);
        if(result != null){
            em.remove(result);
            return true;
        }
        return false;
    }
}
