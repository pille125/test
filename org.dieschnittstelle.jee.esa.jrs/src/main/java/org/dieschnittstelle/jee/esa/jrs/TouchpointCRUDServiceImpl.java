package org.dieschnittstelle.jee.esa.jrs;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.entities.crm.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.entities.GenericCRUDExecutor;

public class TouchpointCRUDServiceImpl implements ITouchpointCRUDService {
	
	protected static Logger logger = Logger.getLogger(TouchpointCRUDServiceImpl.class);

	/**
	 * this accessor will be provided by the ServletContext, to which it is written by the TouchpointServletContextListener
	 */
	private GenericCRUDExecutor<AbstractTouchpoint> touchpointCRUD;

	/**
	 * here we will be passed the context parameters by the resteasy framework
	 * note that the request context is only declared for illustration purposes, but will not be further used here
	 * @param servletContext
	 */
	public TouchpointCRUDServiceImpl(@Context ServletContext servletContext, @Context HttpServletRequest request) {
		logger.info("<constructor>: " + servletContext + "/" + request);
		// read out the dataAccessor
		this.touchpointCRUD = (GenericCRUDExecutor<AbstractTouchpoint>)servletContext.getAttribute("touchpointCRUD");
		
		logger.debug("read out the touchpointCRUD from the servlet context: " + this.touchpointCRUD);		
	}
	

	@Override
	public List<AbstractTouchpoint> readAllTouchpoints() {
		return (List)this.touchpointCRUD.readAllObjects();
	}

	@Override
	public AbstractTouchpoint createTouchpoint(AbstractTouchpoint touchpoint) {
		return (AbstractTouchpoint)this.touchpointCRUD.createObject(touchpoint);
	}

	@Override
	public boolean deleteTouchpoint(long id) {
		return this.touchpointCRUD.deleteObject(id);	
	}

	@Override
	public AbstractTouchpoint readTouchpoint(long id) {
		return (AbstractTouchpoint) this.touchpointCRUD.readObject(id);
	}

	/*
	 * UE JRS1: implement the method for updating touchpoints
	 */
	@Override
	public AbstractTouchpoint updateTouchpoint(long id, AbstractTouchpoint touchpoint) {
		this.touchpointCRUD.updateObject(touchpoint);
		return (AbstractTouchpoint) this.touchpointCRUD.readObject(id);
	}

}
