
package org.dieschnittstelle.jee.esa.jws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.dieschnittstelle.jee.esa.entities.IndividualisedProductItem;


/**
 * <p>Java-Klasse für readProductResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="readProductResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://dieschnittstelle.org/jee/esa/entities.erp}individualisedProductItem" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readProductResponse", propOrder = {
    "_return"
})
public class ReadProductResponse {

    @XmlElement(name = "return")
    protected IndividualisedProductItem _return;

    /**
     * Ruft den Wert der return-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IndividualisedProductItem }
     *     
     */
    public IndividualisedProductItem getReturn() {
        return _return;
    }

    /**
     * Legt den Wert der return-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IndividualisedProductItem }
     *     
     */
    public void setReturn(IndividualisedProductItem value) {
        this._return = value;
    }

}
