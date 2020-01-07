package com.woniu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.commnonservice.FindUser;
import com.woniu.entity.BusinessApply;
import com.woniu.entity.Bussiness;
import com.woniu.entity.User;
import com.woniu.shopservice.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/business")
public class ApplyController {
    @Autowired
    private ApplyService applyService;


    @RequestMapping("/showapply")
    public String showapply(){
        return "sign-up3";
    }
    @RequestMapping("/shoplogin")
    public String shoplogin(){
        return "index3";
    }
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
    @ResponseBody
    @RequestMapping("/apply")
    public String apply( BusinessApply businessApply) throws JsonProcessingException {
        String result="您的申请已经提交，请等待管理员的审核";
        applyService.addApply(businessApply);
        result=new ObjectMapper().writeValueAsString(result);
        return result;
    }
    @RequestMapping("/kk")
    public String ssss(){
        return "2";
    }
    @ResponseBody
    @RequestMapping("/login")
    public String login(Bussiness bussiness, HttpSession session) throws JsonProcessingException {
       Bussiness bussiness1 = applyService.findBusiness(bussiness);
       if(bussiness1==null){
           String result="用户名不存在";
           result=new ObjectMapper().writeValueAsString(result);
           return result;
       }
       if(!bussiness1.getPassword().equals(bussiness.getPassword())){
           String result="密码不对";
           result=new ObjectMapper().writeValueAsString(result);
           return result;
       }
       else {
           String result="登陆成功";
           session.setAttribute("bussiness",bussiness1.getAccount());
           System.out.println(session.getId());
           result=new ObjectMapper().writeValueAsString(result);
           return result;
       }

    }
    @ResponseBody
    @RequestMapping("/validaccountlogin")
    public String validaccount(@Valid BusinessApply businessApply,BindingResult bindingResult) throws JsonProcessingException {
        String result="通过";
        System.out.println(result);
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError temp:fieldErrors){
                System.out.println(temp.getField());
                if(temp.getField().equals("phone")){
                    result=new ObjectMapper().writeValueAsString(temp.getDefaultMessage());
                    return result;
                }
                if(temp.getField().equals("account")){
                    result=new ObjectMapper().writeValueAsString(temp.getDefaultMessage());
                    return result;
                }
            }
        }
        result=new ObjectMapper().writeValueAsString(result);
        return result;

    }
    @ResponseBody
    @RequestMapping("/find/{account}")
    public Bussiness find(@PathVariable("account")String account){
        System.out.println(account);
        System.out.println(applyService.findB(account));
        return applyService.findB(account);
    }

}
