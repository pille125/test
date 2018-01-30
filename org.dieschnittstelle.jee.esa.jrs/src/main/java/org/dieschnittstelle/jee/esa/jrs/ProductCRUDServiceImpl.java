package org.dieschnittstelle.jee.esa.jrs;

import java.util.List;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.entities.GenericCRUDExecutor;
import org.dieschnittstelle.jee.esa.entities.erp.AbstractProduct;
import org.dieschnittstelle.jee.esa.entities.erp.IndividualisedProductItem;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/*
UE JRS2: implementieren Sie hier die im Interface deklarierten Methoden
 */

public class ProductCRUDServiceImpl implements IProductCRUDService {

	private static Logger logger = Logger.getLogger(ProductCRUDServiceImpl.class);

	private GenericCRUDExecutor<AbstractProduct> productCRUD;


	public ProductCRUDServiceImpl(@Context ServletContext servletContext) {
		this.productCRUD = (GenericCRUDExecutor<AbstractProduct>)servletContext.getAttribute("productCRUD");
		logger.debug("read out the productCRUD from the servlet context: " + this.productCRUD);
	}

	@Override
	public AbstractProduct createProduct(
			AbstractProduct prod) {
		return this.productCRUD.createObject(prod);
	}

	@Override
	public List<AbstractProduct> readAllProducts() {
		return (List) this.productCRUD.readAllObjects();
	}

	@Override
	public AbstractProduct updateProduct(long id, AbstractProduct update) {
			this.productCRUD.updateObject(update);
			return this.productCRUD.readObject(id);
	}

	@Override
	public boolean deleteProduct(long id) {
		return this.productCRUD.deleteObject(id);
	}

	@Override
	public AbstractProduct readProduct(long id) {
		return this.productCRUD.readObject(id);
	}
	
}
