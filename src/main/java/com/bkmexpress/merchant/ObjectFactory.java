
package com.bkmexpress.merchant;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bkmexpress.sim.gen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RequestMerchInfo_QNAME = new QName("http://www.bkmexpress.com.tr", "requestMerchInfo");
    private final static QName _RequestMerchInfoResponse_QNAME = new QName("http://www.bkmexpress.com.tr", "requestMerchInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bkmexpress.sim.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestMerchInfo }
     * 
     */
    public RequestMerchInfo createRequestMerchInfo() {
        return new RequestMerchInfo();
    }

    /**
     * Create an instance of {@link RequestMerchInfoResponse }
     * 
     */
    public RequestMerchInfoResponse createRequestMerchInfoResponse() {
        return new RequestMerchInfoResponse();
    }

    /**
     * Create an instance of {@link RequestMerchInfoWSRequest }
     * 
     */
    public RequestMerchInfoWSRequest createRequestMerchInfoWSRequest() {
        return new RequestMerchInfoWSRequest();
    }

    /**
     * Create an instance of {@link MerchantWSBaseRequest }
     * 
     */
    public MerchantWSBaseRequest createMerchantWSBaseRequest() {
        return new MerchantWSBaseRequest();
    }

    /**
     * Create an instance of {@link RequestMerchInfoWSResponse }
     * 
     */
    public RequestMerchInfoWSResponse createRequestMerchInfoWSResponse() {
        return new RequestMerchInfoWSResponse();
    }

    /**
     * Create an instance of {@link MerchantWSBaseResponse }
     * 
     */
    public MerchantWSBaseResponse createMerchantWSBaseResponse() {
        return new MerchantWSBaseResponse();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestMerchInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestMerchInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.bkmexpress.com.tr", name = "requestMerchInfo")
    public JAXBElement<RequestMerchInfo> createRequestMerchInfo(RequestMerchInfo value) {
        return new JAXBElement<RequestMerchInfo>(_RequestMerchInfo_QNAME, RequestMerchInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestMerchInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestMerchInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.bkmexpress.com.tr", name = "requestMerchInfoResponse")
    public JAXBElement<RequestMerchInfoResponse> createRequestMerchInfoResponse(RequestMerchInfoResponse value) {
        return new JAXBElement<RequestMerchInfoResponse>(_RequestMerchInfoResponse_QNAME, RequestMerchInfoResponse.class, null, value);
    }

}
