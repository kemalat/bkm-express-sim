
package com.bkmexpress.payment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for installment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="installment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nofInst" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="amountInst" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cAmount" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tAmount" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cPaid1stInst" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="expInst" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "installment", propOrder = {
    "nofInst",
    "amountInst",
    "cAmount",
    "tAmount",
    "cPaid1StInst",
    "expInst"
})
public class Installment {

    protected int nofInst;
    @XmlElement(required = true)
    protected String amountInst;
    @XmlElement(required = true)
    protected String cAmount;
    @XmlElement(required = true)
    protected String tAmount;
    @XmlElement(name = "cPaid1stInst")
    protected boolean cPaid1StInst;
    @XmlElement(required = true)
    protected String expInst;

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
     * Gets the value of the amountInst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountInst() {
        return amountInst;
    }

    /**
     * Sets the value of the amountInst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountInst(String value) {
        this.amountInst = value;
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
     * Gets the value of the tAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTAmount() {
        return tAmount;
    }

    /**
     * Sets the value of the tAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTAmount(String value) {
        this.tAmount = value;
    }

    /**
     * Gets the value of the cPaid1StInst property.
     * 
     */
    public boolean isCPaid1StInst() {
        return cPaid1StInst;
    }

    /**
     * Sets the value of the cPaid1StInst property.
     * 
     */
    public void setCPaid1StInst(boolean value) {
        this.cPaid1StInst = value;
    }

    /**
     * Gets the value of the expInst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpInst() {
        return expInst;
    }

    /**
     * Sets the value of the expInst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpInst(String value) {
        this.expInst = value;
    }

}
