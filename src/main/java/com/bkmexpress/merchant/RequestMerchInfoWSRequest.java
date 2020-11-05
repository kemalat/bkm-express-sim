
package com.bkmexpress.merchant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestMerchInfoWSRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestMerchInfoWSRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.bkmexpress.com.tr}merchantWSBaseRequest"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="t" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cBin" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="nofInst" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
@XmlType(name = "requestMerchInfoWSRequest", propOrder = {
    "t",
    "bid",
    "bName",
    "cBin",
    "nofInst",
    "ts",
    "s"
})
public class RequestMerchInfoWSRequest
    extends MerchantWSBaseRequest
{

    @XmlElement(required = true)
    protected String t;
    @XmlElement(required = true)
    protected String bid;
    @XmlElement(required = true)
    protected String bName;
    @XmlElement(required = true)
    protected String cBin;
    protected int nofInst;
    @XmlElement(required = true)
    protected String ts;
    @XmlElement(required = true)
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
     * Gets the value of the bid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBid() {
        return bid;
    }

    /**
     * Sets the value of the bid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBid(String value) {
        this.bid = value;
    }

    /**
     * Gets the value of the bName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBName() {
        return bName;
    }

    /**
     * Sets the value of the bName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBName(String value) {
        this.bName = value;
    }

    /**
     * Gets the value of the cBin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCBin() {
        return cBin;
    }

    /**
     * Sets the value of the cBin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCBin(String value) {
        this.cBin = value;
    }

    /**
     * Gets the value of the nofInst property.
     * 
     */
    public int getNofInst() {
        return nofInst;
    }

    /**
     * Sets the value of the nofInst property.
     * 
     */
    public void setNofInst(int value) {
        this.nofInst = value;
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
