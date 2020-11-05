
package com.bkmexpress.payment;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for initializePayment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="initializePayment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="initializePaymentWSRequest" type="{http://www.bkmexpress.com.tr}initializePaymentWSRequest" minOccurs="0" form="qualified"/&gt;
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
@XmlType(name = "initializePayment", propOrder = {
    "initializePaymentWSRequest"
})
public class InitializePayment {

    @XmlElement(namespace = "http://www.bkmexpress.com.tr")
    protected InitializePaymentWSRequest initializePaymentWSRequest;

    /**
     * Gets the value of the initializePaymentWSRequest property.
     * 
     * @return
     *     possible object is
     *     {@link InitializePaymentWSRequest }
     *     
     */
    public InitializePaymentWSRequest getInitializePaymentWSRequest() {
        return initializePaymentWSRequest;
    }

    /**
     * Sets the value of the initializePaymentWSRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitializePaymentWSRequest }
     *     
     */
    public void setInitializePaymentWSRequest(InitializePaymentWSRequest value) {
        this.initializePaymentWSRequest = value;
    }

}
