
package com.bkmexpress.merchant;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for requestMerchInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestMerchInfoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="requestMerchInfoWSResponse" type="{http://www.bkmexpress.com.tr}requestMerchInfoWSResponse" minOccurs="0" form="qualified"/&gt;
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
@XmlType(name = "requestMerchInfoResponse", propOrder = {
    "requestMerchInfoWSResponse"
})
public class RequestMerchInfoResponse {

    @XmlElement(namespace = "http://www.bkmexpress.com.tr")
    protected RequestMerchInfoWSResponse requestMerchInfoWSResponse;

    /**
     * Gets the value of the requestMerchInfoWSResponse property.
     * 
     * @return
     *     possible object is
     *     {@link RequestMerchInfoWSResponse }
     *     
     */
    public RequestMerchInfoWSResponse getRequestMerchInfoWSResponse() {
        return requestMerchInfoWSResponse;
    }

    /**
     * Sets the value of the requestMerchInfoWSResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestMerchInfoWSResponse }
     *     
     */
    public void setRequestMerchInfoWSResponse(RequestMerchInfoWSResponse value) {
        this.requestMerchInfoWSResponse = value;
    }

}
