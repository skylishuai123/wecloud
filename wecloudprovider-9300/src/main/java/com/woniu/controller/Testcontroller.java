package com.woniu.controller;

import com.woniu.commnonservice.FindUser;
import com.woniu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class Testcontroller {
    @Autowired
    private FindUser findUser;
    @RequestMapping("/a")
    public String a(){
        return "1";
    }
    @RequestMapping("/b")
    @ResponseBody
    public User b(){
        return findUser.findbyname("jj");
    }
}
