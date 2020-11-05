
package com.bkmexpress.payment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for initializePaymentWSRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="initializePaymentWSRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.bkmexpress.com.tr}merchantWSBaseRequest"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sAmount" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cAmount" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="instOpts"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="bank" type="{http://www.bkmexpress.com.tr}bank" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
@XmlType(name = "initializePaymentWSRequest", propOrder = {
    "mId",
    "sUrl",
    "cUrl",
    "sAmount",
    "cAmount",
    "instOpts",
    "ts",
    "s"
})
public class InitializePaymentWSRequest {

    @XmlElement(required = true)
    protected String mId;
    @XmlElement(required = true)
    protected String sUrl;
    @XmlElement(required = true)
    protected String cUrl;
    @XmlElement(required = true)
    protected String sAmount;
    @XmlElement(required = true)
    protected String cAmount;
    @XmlElement(required = true)
    protected InitializePaymentWSRequest.InstOpts instOpts;
    @XmlElement(required = true)
    protected String ts;
    @XmlElement(required = true)
    protected String s;

    /**
     * Gets the value of the mId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMId() {
        return mId;
    }

    /**
     * Sets the value of the mId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMId(String value) {
        this.mId = value;
    }

    /**
     * Gets the value of the sUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUrl() {
        return sUrl;
    }

    /**
     * Sets the value of the sUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUrl(String value) {
        this.sUrl = value;
    }

    /**
     * Gets the value of the cUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUrl() {
        return cUrl;
    }

    /**
     * Sets the value of the cUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUrl(String value) {
        this.cUrl = value;
    }

    /**
     * Gets the value of the sAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSAmount() {
        return sAmount;
    }

    /**
     * Sets the value of the sAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSAmount(String value) {
        this.sAmount = value;
    }

    /**
     * Gets the value of the cAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAmount() {
        return cAmount;
    }

    /**
     * Sets the value of the cAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAmount(String value) {
        this.cAmount = value;
    }

    /**
     * Gets the value of the instOpts property.
     * 
     * @return
     *     possible object is
     *     {@link InitializePaymentWSRequest.InstOpts }
     *     
     */
    public InitializePaymentWSRequest.InstOpts getInstOpts() {
        return instOpts;
    }

    /**
     * Sets the value of the instOpts property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitializePaymentWSRequest.InstOpts }
     *     
     */
    public void setInstOpts(InitializePaymentWSRequest.InstOpts value) {
        this.instOpts = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="bank" type="{http://www.bkmexpress.com.tr}bank" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bank"
    })
    public static class InstOpts {

        @XmlElement(required = true)
        protected List<Bank> bank;

        /**
         * Gets the value of the bank property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bank property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBank().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Bank }
         * 
         * 
         */
        public List<Bank> getBank() {
            if (bank == null) {
                bank = new ArrayList<Bank>();
            }
            return this.bank;
        }

    }

}
