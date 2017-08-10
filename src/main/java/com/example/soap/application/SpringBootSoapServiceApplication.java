package com.example.soap.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Makes the application executable.
 * 
 * @author mlahariya
 * @version 1.0, Oct 2016
 */

@SpringBootApplication
@ComponentScan("com.example")
public class SpringBootSoapServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSoapServiceApplication.class, args);
    }
}
