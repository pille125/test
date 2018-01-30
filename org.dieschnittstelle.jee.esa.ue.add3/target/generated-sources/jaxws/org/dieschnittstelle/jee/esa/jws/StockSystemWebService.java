package org.dieschnittstelle.jee.esa.jws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp.StockSystemRemote;

/**
 * This class was generated by Apache CXF 3.1.5
 * 2017-02-06T16:12:48.931+01:00
 * Generated source version: 3.1.5
 * 
 */
@WebServiceClient(name = "StockSystemWebService", 
                  wsdlLocation = "http://localhost:8080/org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp/StockSystemWebService/StockSystemSingleton?wsdl",
                  targetNamespace = "http://dieschnittstelle.org/jee/esa/jws") 
public class StockSystemWebService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://dieschnittstelle.org/jee/esa/jws", "StockSystemWebService");
    public final static QName StockSystemSingletonPort = new QName("http://dieschnittstelle.org/jee/esa/jws", "StockSystemSingletonPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp/StockSystemWebService/StockSystemSingleton?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(StockSystemWebService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp/StockSystemWebService/StockSystemSingleton?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public StockSystemWebService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public StockSystemWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StockSystemWebService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public StockSystemWebService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public StockSystemWebService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public StockSystemWebService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns StockSystemRemote
     */
    @WebEndpoint(name = "StockSystemSingletonPort")
    public StockSystemRemote getStockSystemSingletonPort() {
        return super.getPort(StockSystemSingletonPort, StockSystemRemote.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StockSystemRemote
     */
    @WebEndpoint(name = "StockSystemSingletonPort")
    public StockSystemRemote getStockSystemSingletonPort(WebServiceFeature... features) {
        return super.getPort(StockSystemSingletonPort, StockSystemRemote.class, features);
    }

}