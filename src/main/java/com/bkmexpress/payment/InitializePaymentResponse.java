
package com.bkmexpress.payment;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for initializePaymentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="initializePaymentResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="initializePaymentWSResponse" type="{http://www.bkmexpress.com.tr}initializePaymentWSResponse" minOccurs="0" form="qualified"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "initializePaymentResponse", propOrder = {
    "initializePaymentWSResponse"
})
public class InitializePaymentResponse {

    @XmlElement(namespace = "http://www.bkmexpress.com.tr")
    protected InitializePaymentWSResponse initializePaymentWSResponse;

    /**
     * Gets the value of the initializePaymentWSResponse property.
     * 
     * @return
     *     possible object is
     *     {@link InitializePaymentWSResponse }
     *     
     */
    public InitializePaymentWSResponse getInitializePaymentWSResponse() {
        return initializePaymentWSResponse;
    }

    /**
     * Sets the value of the initializePaymentWSResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitializePaymentWSResponse }
     *     
     */
    public void setInitializePaymentWSResponse(InitializePaymentWSResponse value) {
        this.initializePaymentWSResponse = value;
    }

}
