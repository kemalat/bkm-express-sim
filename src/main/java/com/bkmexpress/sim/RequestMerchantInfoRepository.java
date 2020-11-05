package com.bkmexpress.sim;

import com.bkmexpress.merchant.RequestMerchInfo;
import com.bkmexpress.merchant.RequestMerchInfoWSResponse;
import org.springframework.stereotype.Component;

@Component
public class RequestMerchantInfoRepository {


    public RequestMerchInfoWSResponse findMerchant(RequestMerchInfo requestMerchInfo) {
        RequestMerchInfoWSResponse requestMerchInfoWSResponse = new RequestMerchInfoWSResponse();
        requestMerchInfoWSResponse.setCIp("x");
        requestMerchInfoWSResponse.setExtra("extra");
        requestMerchInfoWSResponse.setMd("ss");
        requestMerchInfoWSResponse.setXid("32");
        return requestMerchInfoWSResponse;
    }
}
