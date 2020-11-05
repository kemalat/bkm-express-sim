package com.bkmexpress.sim.client;

import com.bkmexpress.sim.util.BKMSignatureImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.Arrays;
import java.util.List;

@Configuration
public class RequestMerchantInfoClientConfig {

    @Value("${client.defaultUri}")
    private String defaultUri;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths("com.bkmexpress.merchant","com.bkmexpress.payment");
        return marshaller;
    }

    @Bean
    public BkmClient requestMerchantInfoClient(Jaxb2Marshaller marshaller) {
        BkmClient requestMerchantInfoClient = new BkmClient();
        requestMerchantInfoClient.setDefaultUri(defaultUri);
        requestMerchantInfoClient.setMarshaller(marshaller);
        requestMerchantInfoClient.setUnmarshaller(marshaller);
        return requestMerchantInfoClient;
    }

    @Bean
    public BKMSignatureImpl bKMSignatureImpl() {
        BKMSignatureImpl bkmSignature = new BKMSignatureImpl();
        return bkmSignature;
    }
}