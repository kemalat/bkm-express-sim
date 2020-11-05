
package com.bkmexpress.merchant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestMerchInfoWSResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestMerchInfoWSResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.bkmexpress.com.tr}merchantWSBaseResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="t" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="posUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="posUid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="posPwd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="s3Dauth" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="mpiUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mpiUid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mpiPwd" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="md" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="xid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="s3DFDec" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="cIp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="extra" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "requestMerchInfoWSResponse", propOrder = {
    "t",
    "posUrl",
    "posUid",
    "posPwd",
    "s3Dauth",
    "mpiUrl",
    "mpiUid",
    "mpiPwd",
    "md",
    "xid",
    "s3DFDec",
    "cIp",
    "extra",
    "ts",
    "s"
})
public class RequestMerchInfoWSResponse
    extends MerchantWSBaseResponse
{

    @XmlElement(required = true)
    protected String t;
    @XmlElement(required = true)
    protected String posUrl;
    @XmlElement(required = true)
    protected String posUid;
    @XmlElement(required = true)
    protected String posPwd;
    protected boolean s3Dauth;
    @XmlElement(required = true, nillable = true)
    protected String mpiUrl;
    @XmlElement(required = true, nillable = true)
    protected String mpiUid;
    @XmlElement(required = true, nillable = true)
    protected String mpiPwd;
    @XmlElement(required = true, nillable = true)
    protected String md;
    @XmlElement(required = true, nillable = true)
    protected String xid;
    protected boolean s3DFDec;
    @XmlElement(required = true, nillable = true)
    protected String cIp;
    @XmlElement(required = true, nillable = true)
    protected String extra;
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
     * Gets the value of the posUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosUrl() {
        return posUrl;
    }

    /**
     * Sets the value of the posUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosUrl(String value) {
        this.posUrl = value;
    }

    /**
     * Gets the value of the posUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosUid() {
        return posUid;
    }

    /**
     * Sets the value of the posUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosUid(String value) {
        this.posUid = value;
    }

    /**
     * Gets the value of the posPwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosPwd() {
        return posPwd;
    }

    /**
     * Sets the value of the posPwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosPwd(String value) {
        this.posPwd = value;
    }

    /**
     * Gets the value of the s3Dauth property.
     * 
     */
    public boolean isS3Dauth() {
        return s3Dauth;
    }

    /**
     * Sets the value of the s3Dauth property.
     * 
     */
    public void setS3Dauth(boolean value) {
        this.s3Dauth = value;
    }

    /**
     * Gets the value of the mpiUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMpiUrl() {
        return mpiUrl;
    }

    /**
     * Sets the value of the mpiUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMpiUrl(String value) {
        this.mpiUrl = value;
    }

    /**
     * Gets the value of the mpiUid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMpiUid() {
        return mpiUid;
    }

    /**
     * Sets the value of the mpiUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMpiUid(String value) {
        this.mpiUid = value;
    }

    /**
     * Gets the value of the mpiPwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMpiPwd() {
        return mpiPwd;
    }

    /**
     * Sets the value of the mpiPwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMpiPwd(String value) {
        this.mpiPwd = value;
    }

    /**
     * Gets the value of the md property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMd() {
        return md;
    }

    /**
     * Sets the value of the md property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMd(String value) {
        this.md = value;
    }

    /**
     * Gets the value of the xid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXid() {
        return xid;
    }

    /**
     * Sets the value of the xid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXid(String value) {
        this.xid = value;
    }

    /**
     * Gets the value of the s3DFDec property.
     * 
     */
    public boolean isS3DFDec() {
        return s3DFDec;
    }

    /**
     * Sets the value of the s3DFDec property.
     * 
     */
    public void setS3DFDec(boolean value) {
        this.s3DFDec = value;
    }

    /**
     * Gets the value of the cIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIp() {
        return cIp;
    }

    /**
     * Sets the value of the cIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIp(String value) {
        this.cIp = value;
    }

    /**
     * Gets the value of the extra property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtra() {
        return extra;
    }

    /**
     * Sets the value of the extra property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtra(String value) {
        this.extra = value;
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
