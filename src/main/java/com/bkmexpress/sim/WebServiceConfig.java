package com.bkmexpress.sim;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.validation.XmlValidator;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;


@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/BKMExpressWS/*");
    }

    @Bean(name = "RequestMerchInfoService")
    public DefaultWsdl11Definition merchantWsdl11Definition(XsdSchema requestMerchInfoServiceSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("RequestMerchInfoService");
        wsdl11Definition.setLocationUri("/BKMExpressWS");
        wsdl11Definition.setTargetNamespace("http://www.bkmexpress.com.tr");
        wsdl11Definition.setSchema(requestMerchInfoServiceSchema);
        return wsdl11Definition;
    }

    @Bean(name = "BkmExpressPaymentService")
    public DefaultWsdl11Definition paymentWsdl11Definition(XsdSchema bkmExpressPaymentServiceSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BkmExpressPaymentService");
        wsdl11Definition.setLocationUri("/BKMExpressWS");
        wsdl11Definition.setTargetNamespace("http://www.bkmexpress.com.tr");
        wsdl11Definition.setSchema(bkmExpressPaymentServiceSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema requestMerchInfoServiceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("RequestMerchInfoService.xsd"));
    }
    @Bean
    public XsdSchema bkmExpressPaymentServiceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("BkmExpressPaymentService.xsd"));
    }

}
