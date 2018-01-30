package org.dieschnittstelle.jee.esa.ejb.client.shopping;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm.shopping.ShoppingSessionFacade;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm.shopping.ShoppingSessionFacadeStateful;
import org.dieschnittstelle.jee.esa.entities.crm.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.entities.crm.Customer;
import org.dieschnittstelle.jee.esa.entities.erp.AbstractProduct;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShoppingSessionFacadeClient implements ShoppingBusinessDelegate {

	protected static Logger logger = Logger
			.getLogger(ShoppingSessionFacadeClient.class);

	/*
	 * use the ShoppingSessionFacadeRemote interface
	 */
	private ShoppingSessionFacade proxy;

	@Override
	public void initialise() {
		/* create a jndi context */
		try {
			Context context = new InitialContext();
			proxy = (ShoppingSessionFacade) context.lookup("ejb:org.dieschnittstelle.jee.esa.ejb/org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm/ShoppingSessionFacadeStateful!org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm.shopping.ShoppingSessionFacade?stateful");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		/* lookup the bean */
	}

	@Override
	public void setTouchpoint(AbstractTouchpoint touchpoint) {
		proxy.setTouchpoint(touchpoint);
	}

	@Override
	public void setCustomer(Customer customer) {
		proxy.setCustomer(customer);
	}

	@Override
	public void addProduct(AbstractProduct product, int units) {
		proxy.addProduct(product, units);
	}

	@Override
	public void purchase() {
		proxy.purchase();
	}

}
