package com.woniu.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.entity.*;
import com.woniu.shiroservice.UserService;
import com.woniu.utils.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;


@CrossOrigin
@Controller
@RequestMapping("/user")
public class ShiroController {

    @Autowired
    private UserService shiroservice;
    @Autowired
    private RedisUtil redis;


    private Map<String,Object> map= new HashMap<>();
    private Map<String,Object> sessionmap = new HashMap<>();
    private Map<String, Object> upbussinessmup = new HashMap<String, Object>();
    //map类型转换方法
    private Map<String, Object> changeMapType(Map<Object, Object> map){
        Map<String, Object> resultMap = new HashMap<>();
        Iterator<Object> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = (Object) iterator.next();
            resultMap.put((String)key, map.get(key));
        }
        return resultMap;
    }
    @RequestMapping("/showlogin")
    public String showlogin(){
        return "login";
    }
    @RequestMapping("/showregister")
    public String showregister(){
        return "register";
    }
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
    @ResponseBody
    @RequestMapping("/register")

    public String register(User user) throws JsonProcessingException {
        shiroservice.addUser(user);
        String result="注册成功";
        result=new ObjectMapper().writeValueAsString(result);
        return result;
    }
    @ResponseBody
    @RequestMapping("/login")

    public String login(User user, HttpSession session) throws JsonProcessingException {
        String result="";
        User u=shiroservice.findUser(user.getAccount());
        System.out.println(u);
        if(u==null){
            result ="用户不存在";
            result=new ObjectMapper().writeValueAsString(result);
            return result;
        }
        if(!(u.getPassword().equals(user.getPassword()))){
            result ="密码不对";
            result=new ObjectMapper().writeValueAsString(result);
            return result;
        }
        result ="成功";
        session.setAttribute("user",u.getName());
        result=new ObjectMapper().writeValueAsString(result);
        return result;
    }
    @RequestMapping("/a")
    public String showa(){

        System.out.println("用户模块");
        return "redirect:http://localhost:9660/abc/user/index";
    }
    @RequestMapping("/byname/{name}")
    @ResponseBody
    public User finduser(@PathVariable("name") String name){
        System.out.println(123456);

        return shiroservice.finduserByname(name);
    }



}
