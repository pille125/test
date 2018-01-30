
package org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddToStock_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "addToStock");
    private final static QName _AddToStockResponse_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "addToStockResponse");
    private final static QName _GetAllProductsOnStock_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "getAllProductsOnStock");
    private final static QName _GetAllProductsOnStockResponse_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "getAllProductsOnStockResponse");
    private final static QName _GetPointsOfSale_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "getPointsOfSale");
    private final static QName _GetPointsOfSaleResponse_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "getPointsOfSaleResponse");
    private final static QName _GetProductsOnStock_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "getProductsOnStock");
    private final static QName _GetProductsOnStockResponse_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "getProductsOnStockResponse");
    private final static QName _GetTotalUnitsOnStock_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "getTotalUnitsOnStock");
    private final static QName _GetTotalUnitsOnStockResponse_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "getTotalUnitsOnStockResponse");
    private final static QName _GetUnitsOnStock_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "getUnitsOnStock");
    private final static QName _GetUnitsOnStockResponse_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "getUnitsOnStockResponse");
    private final static QName _RemoveFromStock_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "removeFromStock");
    private final static QName _RemoveFromStockResponse_QNAME = new QName("http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", "removeFromStockResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddToStock }
     * 
     */
    public AddToStock createAddToStock() {
        return new AddToStock();
    }

    /**
     * Create an instance of {@link AddToStockResponse }
     * 
     */
    public AddToStockResponse createAddToStockResponse() {
        return new AddToStockResponse();
    }

    /**
     * Create an instance of {@link GetAllProductsOnStock }
     * 
     */
    public GetAllProductsOnStock createGetAllProductsOnStock() {
        return new GetAllProductsOnStock();
    }

    /**
     * Create an instance of {@link GetAllProductsOnStockResponse }
     * 
     */
    public GetAllProductsOnStockResponse createGetAllProductsOnStockResponse() {
        return new GetAllProductsOnStockResponse();
    }

    /**
     * Create an instance of {@link GetPointsOfSale }
     * 
     */
    public GetPointsOfSale createGetPointsOfSale() {
        return new GetPointsOfSale();
    }

    /**
     * Create an instance of {@link GetPointsOfSaleResponse }
     * 
     */
    public GetPointsOfSaleResponse createGetPointsOfSaleResponse() {
        return new GetPointsOfSaleResponse();
    }

    /**
     * Create an instance of {@link GetProductsOnStock }
     * 
     */
    public GetProductsOnStock createGetProductsOnStock() {
        return new GetProductsOnStock();
    }

    /**
     * Create an instance of {@link GetProductsOnStockResponse }
     * 
     */
    public GetProductsOnStockResponse createGetProductsOnStockResponse() {
        return new GetProductsOnStockResponse();
    }

    /**
     * Create an instance of {@link GetTotalUnitsOnStock }
     * 
     */
    public GetTotalUnitsOnStock createGetTotalUnitsOnStock() {
        return new GetTotalUnitsOnStock();
    }

    /**
     * Create an instance of {@link GetTotalUnitsOnStockResponse }
     * 
     */
    public GetTotalUnitsOnStockResponse createGetTotalUnitsOnStockResponse() {
        return new GetTotalUnitsOnStockResponse();
    }

    /**
     * Create an instance of {@link GetUnitsOnStock }
     * 
     */
    public GetUnitsOnStock createGetUnitsOnStock() {
        return new GetUnitsOnStock();
    }

    /**
     * Create an instance of {@link GetUnitsOnStockResponse }
     * 
     */
    public GetUnitsOnStockResponse createGetUnitsOnStockResponse() {
        return new GetUnitsOnStockResponse();
    }

    /**
     * Create an instance of {@link RemoveFromStock }
     * 
     */
    public RemoveFromStock createRemoveFromStock() {
        return new RemoveFromStock();
    }

    /**
     * Create an instance of {@link RemoveFromStockResponse }
     * 
     */
    public RemoveFromStockResponse createRemoveFromStockResponse() {
        return new RemoveFromStockResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddToStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "addToStock")
    public JAXBElement<AddToStock> createAddToStock(AddToStock value) {
        return new JAXBElement<AddToStock>(_AddToStock_QNAME, AddToStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddToStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "addToStockResponse")
    public JAXBElement<AddToStockResponse> createAddToStockResponse(AddToStockResponse value) {
        return new JAXBElement<AddToStockResponse>(_AddToStockResponse_QNAME, AddToStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProductsOnStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "getAllProductsOnStock")
    public JAXBElement<GetAllProductsOnStock> createGetAllProductsOnStock(GetAllProductsOnStock value) {
        return new JAXBElement<GetAllProductsOnStock>(_GetAllProductsOnStock_QNAME, GetAllProductsOnStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProductsOnStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "getAllProductsOnStockResponse")
    public JAXBElement<GetAllProductsOnStockResponse> createGetAllProductsOnStockResponse(GetAllProductsOnStockResponse value) {
        return new JAXBElement<GetAllProductsOnStockResponse>(_GetAllProductsOnStockResponse_QNAME, GetAllProductsOnStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPointsOfSale }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "getPointsOfSale")
    public JAXBElement<GetPointsOfSale> createGetPointsOfSale(GetPointsOfSale value) {
        return new JAXBElement<GetPointsOfSale>(_GetPointsOfSale_QNAME, GetPointsOfSale.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPointsOfSaleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "getPointsOfSaleResponse")
    public JAXBElement<GetPointsOfSaleResponse> createGetPointsOfSaleResponse(GetPointsOfSaleResponse value) {
        return new JAXBElement<GetPointsOfSaleResponse>(_GetPointsOfSaleResponse_QNAME, GetPointsOfSaleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsOnStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "getProductsOnStock")
    public JAXBElement<GetProductsOnStock> createGetProductsOnStock(GetProductsOnStock value) {
        return new JAXBElement<GetProductsOnStock>(_GetProductsOnStock_QNAME, GetProductsOnStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsOnStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "getProductsOnStockResponse")
    public JAXBElement<GetProductsOnStockResponse> createGetProductsOnStockResponse(GetProductsOnStockResponse value) {
        return new JAXBElement<GetProductsOnStockResponse>(_GetProductsOnStockResponse_QNAME, GetProductsOnStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTotalUnitsOnStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "getTotalUnitsOnStock")
    public JAXBElement<GetTotalUnitsOnStock> createGetTotalUnitsOnStock(GetTotalUnitsOnStock value) {
        return new JAXBElement<GetTotalUnitsOnStock>(_GetTotalUnitsOnStock_QNAME, GetTotalUnitsOnStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTotalUnitsOnStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "getTotalUnitsOnStockResponse")
    public JAXBElement<GetTotalUnitsOnStockResponse> createGetTotalUnitsOnStockResponse(GetTotalUnitsOnStockResponse value) {
        return new JAXBElement<GetTotalUnitsOnStockResponse>(_GetTotalUnitsOnStockResponse_QNAME, GetTotalUnitsOnStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUnitsOnStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "getUnitsOnStock")
    public JAXBElement<GetUnitsOnStock> createGetUnitsOnStock(GetUnitsOnStock value) {
        return new JAXBElement<GetUnitsOnStock>(_GetUnitsOnStock_QNAME, GetUnitsOnStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUnitsOnStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "getUnitsOnStockResponse")
    public JAXBElement<GetUnitsOnStockResponse> createGetUnitsOnStockResponse(GetUnitsOnStockResponse value) {
        return new JAXBElement<GetUnitsOnStockResponse>(_GetUnitsOnStockResponse_QNAME, GetUnitsOnStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveFromStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "removeFromStock")
    public JAXBElement<RemoveFromStock> createRemoveFromStock(RemoveFromStock value) {
        return new JAXBElement<RemoveFromStock>(_RemoveFromStock_QNAME, RemoveFromStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveFromStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://erp.ejbmodule.ejb.esa.jee.dieschnittstelle.org/", name = "removeFromStockResponse")
    public JAXBElement<RemoveFromStockResponse> createRemoveFromStockResponse(RemoveFromStockResponse value) {
        return new JAXBElement<RemoveFromStockResponse>(_RemoveFromStockResponse_QNAME, RemoveFromStockResponse.class, null, value);
    }

}
