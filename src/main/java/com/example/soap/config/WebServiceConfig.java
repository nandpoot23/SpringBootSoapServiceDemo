package com.example.soap.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

/**
 * Configure web service beans Creating a new class with Spring WS related beans
 * configuration. Spring WS uses a different servlet type for handling SOAP
 * messages:MessageDispatcherServlet It is important to inject and set
 * ApplicationContext to MessageDispatcherServlet. Without doing this, Spring WS
 * will not detect Spring beans DefaultWsdl11Definition exposes a standard WSDL
 * 1.1 using XsdSchema.
 * 
 * @author mlahariya
 * @version 1.0, Oct 2016
 */

@SuppressWarnings("deprecation")
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/MathsCalculator/*");
    }

    @Bean(name = "1.0")
    public SimpleWsdl11Definition definition1000() {
        SimpleWsdl11Definition wsdl = new SimpleWsdl11Definition();
        wsdl.setWsdl(arithServiceWsdl());
        return wsdl;
    }

    @Bean
    public Resource arithServiceWsdl() {
        return new ClassPathResource("wsdl/1.0/ArithmaticService.wsdl");
    }

}
