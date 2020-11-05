package com.bkmexpress.sim.client;

import com.bkmexpress.merchant.RequestMerchInfo;
import com.bkmexpress.merchant.RequestMerchInfoResponse;
import com.bkmexpress.merchant.RequestMerchInfoWSRequest;
import com.bkmexpress.payment.*;
import com.bkmexpress.sim.util.BKMSignatureImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;
import java.util.HashMap;
import java.util.Map;

public class BkmClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(BkmClient.class);

    @Autowired
    BKMSignatureImpl bkmSignature;

    @Autowired
    RestTemplate restTemplate;

    @Value("${merchant.bid}")
    private String bId;

    @Value("${merchant.bName}")
    private String bName;

    @Value("${merchant.cBin}")
    private String cBin;

    @Value("${merchant.nofInst}")
    private int nofInst;

    @Value("${callback.successUrl}")
    private String successUrl;

    @Value("${callback.posMsg}")
    private String posMsg;

    public RequestMerchInfoResponse getRequestMerchantInfo(String token, String ts) throws Exception {
        RequestMerchInfo requestMerchInfo = new RequestMerchInfo();
        RequestMerchInfoWSRequest requestMerchInfoWSRequest = new RequestMerchInfoWSRequest();
        requestMerchInfoWSRequest.setBid(bId);
        requestMerchInfoWSRequest.setBName(bName);
        requestMerchInfoWSRequest.setCBin(cBin);
        requestMerchInfoWSRequest.setNofInst(nofInst);
        requestMerchInfoWSRequest.setTs(ts);
        requestMerchInfoWSRequest.setT(token);
        logger.info("Signature  " + generateSignature(requestMerchInfoWSRequest));
        requestMerchInfoWSRequest.setS(generateSignature(requestMerchInfoWSRequest));
        requestMerchInfo.setRequestMerchInfoWSRequest(requestMerchInfoWSRequest);

        logger.info("Requesting information for " + requestMerchInfo);

        JAXBElement<RequestMerchInfoResponse> response = (JAXBElement<RequestMerchInfoResponse>)getWebServiceTemplate().marshalSendAndReceive(requestMerchInfo);
        return response.getValue();
    }

    public InitializePaymentResponse initializePayment() throws Exception {
        InitializePayment initializePayment = new InitializePayment();
        InitializePaymentWSRequest initializePaymentWSRequest = new InitializePaymentWSRequest();
        initializePaymentWSRequest.setCAmount("1.00");
        initializePaymentWSRequest.setCUrl("hede.com");
        initializePaymentWSRequest.setMId("mid");
        initializePaymentWSRequest.setSUrl("hodo.com");
        initializePaymentWSRequest.setSAmount("1000");
        initializePaymentWSRequest.setMId("9393993");
        initializePaymentWSRequest.setTs("39993939399393993");
        Bank bank = new Bank();
        bank.setId(String.format("%04d", 1));
        bank.setExpBank("");
        Bank.Bins bins = new Bank.Bins();
        Bin bin = new Bin();
        Bin.Insts insts= new Bin.Insts();
        Installment installment = new Installment();
        installment.setAmountInst("100");
        installment.setCAmount("200");
        installment.setCPaid1StInst(true);
        installment.setNofInst(1);
        installment.setExpInst("2");
        insts.getInst().add(installment);
        bin.setInsts(insts);
        bin.setValue("xx");
        bins.getBin().add(bin);
        bank.setBins(bins);
        InitializePaymentWSRequest.InstOpts instOpts = new InitializePaymentWSRequest.InstOpts();
        instOpts.getBank().add(bank);
        initializePaymentWSRequest.setInstOpts(instOpts);
        logger.info("Signature  " + generateSignature(initializePaymentWSRequest));
        initializePaymentWSRequest.setS(generateSignature(initializePaymentWSRequest));
        initializePayment.setInitializePaymentWSRequest(initializePaymentWSRequest);

        logger.info("Requesting information for " + initializePayment);

        JAXBElement<InitializePaymentResponse> response = (JAXBElement<InitializePaymentResponse>)getWebServiceTemplate().marshalSendAndReceive(initializePayment);
        return response.getValue();
    }

    private String generateSignature(InitializePaymentWSRequest request) throws Exception {
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
        String signature = stringBuilder.toString();
        try {
            return bkmSignature.sign(signature);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }


    public String generateSignature(RequestMerchInfoWSRequest requestMerchInfoWSRequest) throws Exception {
        String signature = requestMerchInfoWSRequest.getT() + requestMerchInfoWSRequest.getBid() +
                requestMerchInfoWSRequest.getBName() + requestMerchInfoWSRequest.getCBin() +
                requestMerchInfoWSRequest.getNofInst() + requestMerchInfoWSRequest.getTs();
        try {
            return bkmSignature.sign(signature);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void callSuccessCallback(String token, String ts) throws Exception {
        BKMCallbackSuccessRequest bkmCallbackSuccessRequest = new BKMCallbackSuccessRequest();
        bkmCallbackSuccessRequest.setT(token);
        bkmCallbackSuccessRequest.setTs(ts);
        bkmCallbackSuccessRequest.setXid(token);
        bkmCallbackSuccessRequest.setMd("");
        bkmCallbackSuccessRequest.setPosMessage(posMsg);
        bkmCallbackSuccessRequest.setS(generateSignature(bkmCallbackSuccessRequest));
        HttpEntity<BKMCallbackSuccessRequest> requestHttpEntity = new HttpEntity<>(bkmCallbackSuccessRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("t", bkmCallbackSuccessRequest.getT());
        params.add("xid", bkmCallbackSuccessRequest.getXid());
        params.add("md", bkmCallbackSuccessRequest.getMd());
        params.add("ts", bkmCallbackSuccessRequest.getTs());
        params.add("s", bkmCallbackSuccessRequest.getS());
        params.add("posMessage", bkmCallbackSuccessRequest.getPosMessage());
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> result = restTemplate.exchange(successUrl, HttpMethod.POST, requestEntity, String.class);
//
//
//        HttpEntity<String> response = restTemplate.exchange("http://localhost:8443/payment/iyzipos/bkm/callback/success",
//                HttpMethod.POST, requestHttpEntity, String.class, params);

    }

    public String generateSignature(BKMCallbackSuccessRequest bkmCallbackSuccessRequest) throws Exception {
        String signature = bkmCallbackSuccessRequest.getT() + bkmCallbackSuccessRequest.getPosMessage() +
                bkmCallbackSuccessRequest.getXid() + bkmCallbackSuccessRequest.getMd() +
                bkmCallbackSuccessRequest.getTs();
        logger.info("BKMSuccessCallbackVo signature generated.");
        try {
            return bkmSignature.sign(signature);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}