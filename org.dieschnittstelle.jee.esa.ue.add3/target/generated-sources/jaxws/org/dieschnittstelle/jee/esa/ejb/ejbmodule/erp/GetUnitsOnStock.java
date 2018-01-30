
package org.dieschnittstelle.jee.esa.ejb.ejbmodule.erp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.dieschnittstelle.jee.esa.entities.IndividualisedProductItem;


/**
 * <p>Java-Klasse für getUnitsOnStock complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="getUnitsOnStock"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arg0" type="{http://dieschnittstelle.org/jee/esa/entities.erp}individualisedProductItem" minOccurs="0"/&gt;
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUnitsOnStock", propOrder = {
    "arg0",
    "arg1"
})
public class GetUnitsOnStock {

    protected IndividualisedProductItem arg0;
    protected long arg1;

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

    /**
     * Ruft den Wert der arg1-Eigenschaft ab.
     * 
     */
    public long getArg1() {
        return arg1;
    }

    /**
     * Legt den Wert der arg1-Eigenschaft fest.
     * 
     */
    public void setArg1(long value) {
        this.arg1 = value;
    }

}
