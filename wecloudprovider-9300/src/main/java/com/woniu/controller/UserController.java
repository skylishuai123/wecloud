package com.woniu.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.woniu.entity.User;
import com.woniu.commnonservice.UserServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/find")
public class UserController {
    @Autowired
    private UserServic service;
    @RequestMapping("/all")
    @HystrixCommand(fallbackMethod="fallback2")
    public List<User> findUser(){
        return service.finduser();
    }
    public List<User> fallback2(){
        User u = new User(500,"内部错误",null,null,null,null,null,null,null);
        List<User> l = new ArrayList<>();
        l.add(u);
        return l;
    }
}
