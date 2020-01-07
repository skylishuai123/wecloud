package com.woniu.controller;

import com.woniu.entity.Bussiness;
import com.woniu.shopservice.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/a")
public class B {
    @Autowired
    private ApplyService applyService;

   @RequestMapping("/b")
    public Bussiness b(String account){
       return applyService.findB(account);
    }
}
