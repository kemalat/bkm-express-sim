package com.bkmexpress.sim.client;

import com.bkmexpress.merchant.RequestMerchInfoResponse;
import com.bkmexpress.payment.InitializePaymentResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Ensure that the server - com.baeldung.springsoap.Application - is running before executing this test
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RequestMerchantInfoClientConfig.class, loader = AnnotationConfigContextLoader.class)
public class BkmClientTest {

    @Autowired
    BkmClient client;

    @Test
    public void requestMerchInfoWSResponse_returned_successfully() {
        RequestMerchInfoResponse response = null;
        try {
            String token = UUID.randomUUID().toString();
            String ts = "20201103-16:13:33";
            response = client.getRequestMerchantInfo(token, ts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("extra", response.getRequestMerchInfoWSResponse().getExtra());
    }

    @Test
    public void initializepayment_returned_successfully() {
        InitializePaymentResponse response = null;
        try {
            response = client.initializePayment();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("aaaaaaa", response.getInitializePaymentWSResponse().getT());
    }


}
