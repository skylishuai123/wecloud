package com.woniu.wecloudzuul9660;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication(scanBasePackages = "com.woniu")
@EnableZuulProxy
@EnableEurekaClient
@EnableRedisHttpSession
public class Wecloudzuul9660Application {

    public static void main(String[] args) {
        SpringApplication.run(Wecloudzuul9660Application.class, args);
    }

}
