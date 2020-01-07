package com.woniu.wecloudbusiness9668;

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
@ComponentScan({"com.woniu.shopserviceimp","com.woniu.controller","com.woniu.factory"})
@EnableFeignClients(basePackages="com.woniu.commnonservice")
public class Wecloudbusiness9668Application {

    public static void main(String[] args) {
        SpringApplication.run(Wecloudbusiness9668Application.class, args);
    }

}
