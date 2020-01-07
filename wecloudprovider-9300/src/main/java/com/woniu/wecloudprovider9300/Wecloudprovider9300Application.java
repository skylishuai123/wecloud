package com.woniu.wecloudprovider9300;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.woniu.dao")
@EnableCircuitBreaker
@ComponentScan({"com.woniu.serviceimp","com.woniu.controller","com.woniu.factory"})
@EnableFeignClients(basePackages="com.woniu.commnonservice")
public class Wecloudprovider9300Application {

    public static void main(String[] args) {
        SpringApplication.run(Wecloudprovider9300Application.class, args);
    }

}
