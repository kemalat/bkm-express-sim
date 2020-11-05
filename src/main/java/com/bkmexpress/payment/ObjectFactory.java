
package com.bkmexpress.payment;

import com.bkmexpress.merchant.MerchantWSBaseRequest;
import com.bkmexpress.merchant.MerchantWSBaseResponse;
import com.bkmexpress.merchant.Result;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bkmexpress.payment package. 
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

    private final static QName _InitializePayment_QNAME = new QName("http://www.bkmexpress.com.tr", "initializePayment");
    private final static QName _InitializePaymentResponse_QNAME = new QName("http://www.bkmexpress.com.tr", "initializePaymentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bkmexpress.payment
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Bin }
     * 
     */
    public Bin createBin() {
        return new Bin();
    }

    /**
     * Create an instance of {@link Bank }
     * 
     */
    public Bank createBank() {
        return new Bank();
    }

    /**
     * Create an instance of {@link InitializePaymentWSRequest }
     * 
     */
    public InitializePaymentWSRequest createInitializePaymentWSRequest() {
        return new InitializePaymentWSRequest();
    }

    /**
     * Create an instance of {@link InitializePayment }
     * 
     */
    public InitializePayment createInitializePayment() {
        return new InitializePayment();
    }

    /**
     * Create an instance of {@link InitializePaymentResponse }
     * 
     */
    public InitializePaymentResponse createInitializePaymentResponse() {
        return new InitializePaymentResponse();
    }

    /**
     * Create an instance of {@link MerchantWSBaseRequest }
     * 
     */
    public MerchantWSBaseRequest createMerchantWSBaseRequest() {
        return new MerchantWSBaseRequest();
    }

    /**
     * Create an instance of {@link Installment }
     * 
     */
    public Installment createInstallment() {
        return new Installment();
    }

    /**
     * Create an instance of {@link InitializePaymentWSResponse }
     * 
     */
    public InitializePaymentWSResponse createInitializePaymentWSResponse() {
        return new InitializePaymentWSResponse();
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
     * Create an instance of {@link Bin.Insts }
     * 
     */
    public Bin.Insts createBinInsts() {
        return new Bin.Insts();
    }

    /**
     * Create an instance of {@link Bank.Bins }
     * 
     */
    public Bank.Bins createBankBins() {
        return new Bank.Bins();
    }

    /**
     * Create an instance of {@link InitializePaymentWSRequest.InstOpts }
     * 
     */
    public InitializePaymentWSRequest.InstOpts createInitializePaymentWSRequestInstOpts() {
        return new InitializePaymentWSRequest.InstOpts();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitializePayment }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InitializePayment }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.bkmexpress.com.tr", name = "initializePayment")
    public JAXBElement<InitializePayment> createInitializePayment(InitializePayment value) {
        return new JAXBElement<InitializePayment>(_InitializePayment_QNAME, InitializePayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitializePaymentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InitializePaymentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.bkmexpress.com.tr", name = "initializePaymentResponse")
    public JAXBElement<InitializePaymentResponse> createInitializePaymentResponse(InitializePaymentResponse value) {
        return new JAXBElement<InitializePaymentResponse>(_InitializePaymentResponse_QNAME, InitializePaymentResponse.class, null, value);
    }

}
