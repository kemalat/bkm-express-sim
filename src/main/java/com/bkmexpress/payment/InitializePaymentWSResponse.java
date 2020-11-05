
package com.bkmexpress.payment;

import com.bkmexpress.merchant.MerchantWSBaseResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for initializePaymentWSResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="initializePaymentWSResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.bkmexpress.com.tr}merchantWSBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="t" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ts" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="s" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "initializePaymentWSResponse", propOrder = {
    "t",
    "url",
    "ts",
    "s"
})
public class InitializePaymentWSResponse
    extends MerchantWSBaseResponse
{

    @XmlElement(required = true, nillable = true)
    protected String t;
    @XmlElement(required = true, nillable = true)
    protected String url;
    @XmlElement(required = true, nillable = true)
    protected String ts;
    @XmlElement(required = true, nillable = true)
    protected String s;

    /**
     * Gets the value of the t property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getT() {
        return t;
    }

    /**
     * Sets the value of the t property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setT(String value) {
        this.t = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the ts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTs() {
        return ts;
    }

    /**
     * Sets the value of the ts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTs(String value) {
        this.ts = value;
    }

    /**
     * Gets the value of the s property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getS() {
        return s;
    }

    /**
     * Sets the value of the s property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setS(String value) {
        this.s = value;
    }

}
