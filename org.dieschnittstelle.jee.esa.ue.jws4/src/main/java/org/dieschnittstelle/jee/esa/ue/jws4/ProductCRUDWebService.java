package org.dieschnittstelle.jee.esa.ue.jws4;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.dieschnittstelle.jee.esa.entities.GenericCRUDExecutor;
import org.dieschnittstelle.jee.esa.entities.erp.AbstractProduct;
import org.dieschnittstelle.jee.esa.entities.erp.IndividualisedProductItem;

/*
 * UE JWS4: machen Sie die Funktionalitaet dieser Klasse als Web Service verfuegbar und verwenden Sie fuer 
 * die Umetzung der beiden Methoden die Instanz von GenericCRUDExecutor<AbstractProduct>, 
 * die Sie aus dem ServletContext auslesen koennen
 */

@WebService(targetNamespace = "http://dieschnittstelle.org/jee/esa/jws", serviceName = "ProductCRUDSOAPService")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ProductCRUDWebService {

	@Resource
	private WebServiceContext wscontext;

	public List<AbstractProduct> readAllProducts() {
		return getProductCRUDExecuter().readAllObjects();
	}

	public AbstractProduct createProduct(AbstractProduct product) {
		return getProductCRUDExecuter().createObject(product);
	}

	public AbstractProduct updateProduct(AbstractProduct update) {
		return getProductCRUDExecuter().updateObject(update);
	}

	public boolean deleteProduct(long id) {
		return getProductCRUDExecuter().deleteObject(id);
	}

	public IndividualisedProductItem readProduct(long id) {
		ServletContext servletContext = (ServletContext) wscontext.getMessageContext()
				.get(MessageContext.SERVLET_CONTEXT);
		GenericCRUDExecutor<IndividualisedProductItem> indiProductCRUD = (GenericCRUDExecutor<IndividualisedProductItem>) servletContext
				.getAttribute("productCRUD");
		return indiProductCRUD.readObject(id);
	}

	/**
	 * Helper method to get the product crud executer from the servlet context.
	 * @return The product CRUD executer
	 */
	@WebMethod(exclude = true)
	private GenericCRUDExecutor<AbstractProduct> getProductCRUDExecuter(){
		ServletContext servletContext = (ServletContext) wscontext.getMessageContext()
				.get(MessageContext.SERVLET_CONTEXT);
		GenericCRUDExecutor<AbstractProduct> productCRUD = (GenericCRUDExecutor<AbstractProduct>) servletContext
				.getAttribute("productCRUD");
		return productCRUD;
	}
}
