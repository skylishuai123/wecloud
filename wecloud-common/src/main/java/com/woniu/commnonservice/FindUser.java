package com.woniu.commnonservice;

import com.woniu.entity.User;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

@Service
@FeignClient(name = "woniu58-shiro")
public interface FindUser {
    @GetMapping("/user/byname/{name}")
    User findbyname(@PathVariable("name")String name);
}
