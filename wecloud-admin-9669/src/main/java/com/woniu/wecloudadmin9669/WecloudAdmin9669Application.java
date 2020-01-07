package com.woniu.wecloudadmin9669;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.woniu.dao")
@EnableRedisHttpSession
@ComponentScan({"com.woniu.service","com.woniu.controller","com.woniu.factory","com.woniu.serviceadminImp","com.woniu.configuration","com.woniu.utils"})
@EnableFeignClients(basePackages="com.woniu.commnonservice")
public class WecloudAdmin9669Application {

    public static void main(String[] args) {
        SpringApplication.run(WecloudAdmin9669Application.class, args);
    }

}
