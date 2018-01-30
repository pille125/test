
package org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.dieschnittstelle.jee.esa.entities.IndividualisedProductItem;


/**
 * <p>Java-Klasse für getPointsOfSale complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="getPointsOfSale"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arg0" type="{http://dieschnittstelle.org/jee/esa/entities.erp}individualisedProductItem" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPointsOfSale", propOrder = {
    "arg0"
})
public class GetPointsOfSale {

    protected IndividualisedProductItem arg0;

    /**
     * Ruft den Wert der arg0-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndividualisedProductItem }
     *     
     */
    public IndividualisedProductItem getArg0() {
        return arg0;
    }

    /**
     * Legt den Wert der arg0-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndividualisedProductItem }
     *     
     */
    public void setArg0(IndividualisedProductItem value) {
        this.arg0 = value;
    }

}
