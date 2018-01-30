package org.dieschnittstelle.jee.esa.ejb.client.ejbclients;

import java.util.List;

import org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm.ShoppingException;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.crm.TouchpointAccessRemote;
import org.dieschnittstelle.jee.esa.entities.crm.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.ejb.client.Constants;

public class TouchpointAccessClient implements TouchpointAccessRemote {
	
	private TouchpointAccessRemote ejbProxy;
	
	public TouchpointAccessClient() throws Exception {
		this.ejbProxy = EJBProxyFactory.getInstance().getProxy(TouchpointAccessRemote.class,Constants.TOUCHPOINT_ACCESS_BEAN_URI);
	}
	
	
	public List<AbstractTouchpoint> readAllTouchpoints() {
		return ejbProxy.readAllTouchpoints();
	}

	@Override
	public AbstractTouchpoint createTouchpointAndPointOfSale(AbstractTouchpoint touchpoint) throws ShoppingException {
		AbstractTouchpoint created = ejbProxy.createTouchpointAndPointOfSale(touchpoint);
		touchpoint.setId(created.getId());
		touchpoint.setErpPointOfSaleId(created.getErpPointOfSaleId());
		
		return created;
	}
		
}
