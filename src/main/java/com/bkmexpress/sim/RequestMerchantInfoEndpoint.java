package com.bkmexpress.sim;

import com.bkmexpress.merchant.*;
import com.bkmexpress.payment.InitializePayment;
import com.bkmexpress.payment.InitializePaymentResponse;
import com.bkmexpress.payment.InitializePaymentWSRequest;
import com.bkmexpress.payment.InitializePaymentWSResponse;
import com.bkmexpress.sim.client.BkmClient;
import com.bkmexpress.sim.util.BKMSignatureImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.naming.AuthenticationException;
import javax.xml.bind.JAXBElement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Endpoint
public class RequestMerchantInfoEndpoint {

    private static final String NAMESPACE_URI = "http://www.bkmexpress.com.tr";
    private static final Logger logger = LoggerFactory.getLogger(RequestMerchantInfoEndpoint.class);

    @Value("${init.payment.url}")
    private String url;

    @Value("${init.payment.delay}")
    private long delay;

    @Value("${init.payment.resultCode}")
    private int resultCode;

    private RequestMerchantInfoRepository requestMerchantInfoRepository;

    @Autowired
    BkmClient bkmClient;

    @Autowired
    BKMSignatureImpl bkmSignature;

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    public RequestMerchantInfoEndpoint(RequestMerchantInfoRepository requestMerchantInfoRepository) {
        this.requestMerchantInfoRepository = requestMerchantInfoRepository;
    }

    String pattern = "yyyyMMdd-HH:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "requestMerchInfo")
    @ResponsePayload
    public JAXBElement<RequestMerchInfoResponse> requestMerchInfo(@RequestPayload JAXBElement<RequestMerchInfo> requestMerchInfo) {
        RequestMerchInfoResponse requestMerchInfoResponse = new RequestMerchInfoResponse();
        try {
            authenticate(requestMerchInfo.getValue().getRequestMerchInfoWSRequest().getS(),
                    generateRequestMerchInfoWSRequestSignature(requestMerchInfo.getValue().getRequestMerchInfoWSRequest()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        requestMerchInfoResponse.setRequestMerchInfoWSResponse(requestMerchantInfoRepository.findMerchant(requestMerchInfo.getValue()));
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<RequestMerchInfoResponse> response = objectFactory.createRequestMerchInfoResponse(requestMerchInfoResponse);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "initializePayment")
    @ResponsePayload
    public JAXBElement<InitializePaymentResponse> initPayment(@RequestPayload JAXBElement<InitializePayment> initializePayment) {
        InitializePaymentResponse initializePaymentResponse = new InitializePaymentResponse();
        try {
            authenticate(initializePayment.getValue().getInitializePaymentWSRequest().getS(),
                    generateInitializePaymentWSRequestSignature(initializePayment.getValue().getInitializePaymentWSRequest()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        String token = UUID.randomUUID().toString();
        InitializePaymentWSResponse initializePaymentWSResponse = new InitializePaymentWSResponse();
        initializePaymentWSResponse.setT(token);
        initializePaymentWSResponse.setTs(simpleDateFormat.format(new Date()));
        initializePaymentWSResponse.setUrl(url);
        com.bkmexpress.merchant.Result result = new com.bkmexpress.merchant.Result();
        result.setResultCode(resultCode);
        initializePaymentWSResponse.setResult(result);
        initializePaymentResponse.setInitializePaymentWSResponse(initializePaymentWSResponse);
        com.bkmexpress.payment.ObjectFactory objectFactory = new com.bkmexpress.payment.ObjectFactory();
        JAXBElement<InitializePaymentResponse> response = objectFactory.createInitializePaymentResponse(initializePaymentResponse);

        taskScheduler.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info("running...");
                    bkmClient.getRequestMerchantInfo(token,initializePaymentWSResponse.getTs());
                    bkmClient.callSuccessCallback(token,initializePaymentWSResponse.getTs());
                } catch (Exception e) {
                    logger.warn("ee", e);
                }
            }
        }, new Date(System.currentTimeMillis() + delay));
        return response;
    }

    public void authenticate(String signature, String message) throws Exception {
        try {
            boolean verificationResult = bkmSignature.verify(signature, message);
            logger.info("verificationResult = " + verificationResult);
            if (!verificationResult) {
                throw new AuthenticationException("Signature verification failed for payment with token: ");
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e.getMessage());
        }
    }


    public String generateInitializePaymentWSRequestSignature(InitializePaymentWSRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(request.getMId()).append(request.getSUrl()).append(request.getCUrl()).append(request.getSAmount()).append(request.getCAmount());
        request.getInstOpts().getBank().forEach(b -> {
            stringBuilder.append(b.getId()).append(b.getName())
                    .append(b.getExpBank());
            b.getBins().getBin().forEach(bin -> {
                stringBuilder.append(bin.getValue());
                bin.getInsts().getInst().forEach(i -> stringBuilder.append(i.getNofInst()).append(i.getAmountInst())
                        .append(i.getCAmount())
                        .append(i.getTAmount())
                        .append(i.isCPaid1StInst())
                        .append(i.getExpInst()));
            });
        });
        stringBuilder.append(request.getTs());
        logger.info("InitializePaymentWSRequest signature generated.");
        return stringBuilder.toString();
    }

    public String generateRequestMerchInfoWSRequestSignature(RequestMerchInfoWSRequest requestMerchInfoWSRequest) {
        String signature = requestMerchInfoWSRequest.getT() + requestMerchInfoWSRequest.getBid() +
                requestMerchInfoWSRequest.getBName() + requestMerchInfoWSRequest.getCBin()+
                requestMerchInfoWSRequest.getNofInst() + requestMerchInfoWSRequest.getTs();
        logger.info("RequestMerchInfoWSRequest signature generated.");
        return signature;
    }
}
