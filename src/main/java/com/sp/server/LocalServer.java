package com.sp.server;

import com.sp.config.ApplicationConfig;
import com.sp.webservice.MerchantProductWs;
import com.sp.webservice.MerchantWs;
import com.sp.webservice.ProductWs;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.ws.Endpoint;

public class LocalServer {

    private static String URL = "http://localhost:8686/ws/";

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        MerchantProductWs merchantProductWs = context.getBean(MerchantProductWs.class);
        Endpoint.publish(URL + "merchantProducts", merchantProductWs);

        ProductWs productWs = context.getBean(ProductWs.class);
        Endpoint.publish(URL + "products", productWs);

        MerchantWs merchantWs = context.getBean(MerchantWs.class);
        Endpoint.publish(URL + "merchants", merchantWs);
    }
}
