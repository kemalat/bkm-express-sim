
package com.bkmexpress.merchant;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for requestMerchInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestMerchInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="requestMerchInfoWSRequest" type="{http://www.bkmexpress.com.tr}requestMerchInfoWSRequest" minOccurs="0" form="qualified"/&gt;
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
@XmlType(name = "requestMerchInfo", propOrder = {
    "requestMerchInfoWSRequest"
})
public class RequestMerchInfo {

    @XmlElement(namespace = "http://www.bkmexpress.com.tr")
    protected RequestMerchInfoWSRequest requestMerchInfoWSRequest;

    /**
     * Gets the value of the requestMerchInfoWSRequest property.
     * 
     * @return
     *     possible object is
     *     {@link RequestMerchInfoWSRequest }
     *     
     */
    public RequestMerchInfoWSRequest getRequestMerchInfoWSRequest() {
        return requestMerchInfoWSRequest;
    }

    /**
     * Sets the value of the requestMerchInfoWSRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestMerchInfoWSRequest }
     *     
     */
    public void setRequestMerchInfoWSRequest(RequestMerchInfoWSRequest value) {
        this.requestMerchInfoWSRequest = value;
    }

}
