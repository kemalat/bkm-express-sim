package com.bkmexpress.sim;


import com.bkmexpress.merchant.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationIntegrationTest {

    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    @LocalServerPort private int port = 0;

    @Before
    public void init() throws Exception {
        marshaller.setPackagesToScan(ClassUtils.getPackageName(RequestMerchInfo.class));
        marshaller.afterPropertiesSet();
    }

    @Test
    public void whenSendRequest_thenResponseIsNotNull() {
        WebServiceTemplate ws = new WebServiceTemplate(marshaller);
        RequestMerchInfo request = new RequestMerchInfo();
        RequestMerchInfoWSRequest requestMerchInfoWSRequest = new RequestMerchInfoWSRequest();
        requestMerchInfoWSRequest.setBid("0062");
        requestMerchInfoWSRequest.setBName("T.GARANTİ BANKASI A.Ş.");
        requestMerchInfoWSRequest.setCBin("544078");
        requestMerchInfoWSRequest.setNofInst(1);
        requestMerchInfoWSRequest.setTs("20201028-10:52:31");
        requestMerchInfoWSRequest.setT("b6b9b009-5045-48b3-8563-e88f52719e13");
        request.setRequestMerchInfoWSRequest(requestMerchInfoWSRequest);
        assertThat(ws.marshalSendAndReceive("http://localhost:" + port + "/BKMExpressWS", request)).isNotNull();
    }
}
