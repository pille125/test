package org.dieschnittstelle.jee.esa.ejb.client.ejbclients;

import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm.crud.CustomerTransactionCRUDRemote;
import org.dieschnittstelle.jee.esa.entities.crm.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.entities.crm.Customer;
import org.dieschnittstelle.jee.esa.entities.crm.CustomerTransaction;
import org.dieschnittstelle.jee.esa.ejb.client.Constants;

public class CustomerTransactionCRUDClient implements CustomerTransactionCRUDRemote {

	private CustomerTransactionCRUDRemote proxy;
	
	public CustomerTransactionCRUDClient() throws Exception {
		Context context = new InitialContext();		
		this.proxy = (CustomerTransactionCRUDRemote)context.lookup(Constants.TRANSACTIONS_CRUD_BEAN);
	}
	
	@Override
	public Collection<CustomerTransaction> readAllTransactionsForTouchpoint(
			AbstractTouchpoint touchpoint) {
		return proxy.readAllTransactionsForTouchpoint(touchpoint);
	}

	@Override
	public Collection<CustomerTransaction> readAllTransactionsForCustomer(
			Customer customer) {
		return proxy.readAllTransactionsForCustomer(customer);
	}

	@Override
	public Collection<CustomerTransaction> readAllTransactionsForTouchpointAndCustomer(
			AbstractTouchpoint touchpoint, Customer customer) {
		return proxy.readAllTransactionsForTouchpointAndCustomer(touchpoint, customer);
	}

}
