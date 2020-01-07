package com.woniu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.woniu.entity.*;
import com.woniu.service.AdminService;
import com.woniu.service.ApplyService;

import com.woniu.service.BussinessService;
import com.woniu.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private RedisUtil redis;
    @Autowired
    private BussinessService bussinessService;
    @Autowired
    private ApplyService applyService;
    private Map<String,Object> rolemap= new HashMap<>();
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
    public String adminlogin(){
        return "index3";
    }
    @ResponseBody
    @RequestMapping("/login")
  public String login(Admin admin,HttpSession session) throws JsonProcessingException {
        Admin admin1 = adminService.findUser(admin);
        if(admin1==null){
            String result="用户名不存在";
            result=new ObjectMapper().writeValueAsString(result);
            return result;
        }
        if(!admin1.getPassword().equals(admin.getPassword())){
            String result="密码不对";
            result=new ObjectMapper().writeValueAsString(result);
            return result;
        }
        else {
            String result="登陆成功";
            session.setAttribute("admin",admin1.getAccount());
            System.out.println(session.getId());
            result=new ObjectMapper().writeValueAsString(result);
            return result;
        }


    }
    @RequestMapping("/listhtml")
    public String listhtml(){
        return "admin-list";
    }
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/kk")
    public String kk(){
        return "2";
    }
    @RequestMapping("/role")
    public String role(){
        return "admin-role";
    }
    @ResponseBody
    @RequestMapping("/showbussiness")
    public List<Bussiness> showbussiness(){
        return bussinessService.findallbussiness();
    }
    @ResponseBody
    @RequestMapping("/up")
    public Bussiness up(String id){
        System.out.println(id);
        System.out.println(bussinessService.findupbussiness(id));
        sessionmap.put(bussinessService.findupbussiness(id).getName(),bussinessService.findupbussiness(id));
        redis.del("updatebussiness");
        redis.hmset("updatebussiness",sessionmap);
        return bussinessService.findupbussiness(id);
    }
    @RequestMapping("/meberadd")
    public String meberadd(){
        return "member-add";
    }

    @ResponseBody
    @RequestMapping("/who")
    public String findwho(HttpSession session) throws JsonProcessingException {
        String result="";
       result=session.getAttribute("admin").toString();
        result=new ObjectMapper().writeValueAsString(result);
        return result;

    }

    @ResponseBody
    @RequestMapping("/realup")
    public Bussiness realupdate(){
        Bussiness b =null;
        String str ="";
        upbussinessmup =  changeMapType(redis.hmget("updatebussiness"));
        Set<String> s = upbussinessmup.keySet();
        for(Iterator<String> i=s.iterator();i.hasNext();){
            str =i.next();
            b = (Bussiness) upbussinessmup.get(str);
            System.out.println(123);
            System.out.println(b);
        }
        upbussinessmup.remove(str);
        redis.del("updatebussiness");
        redis.hmset("updatebussiness",upbussinessmup);

        return b;
    }
    @ResponseBody
    @RequestMapping("/updatebuss")
    public String xiugai(Bussiness bussiness) throws JsonProcessingException {
        String result="修改成功";

        bussinessService.xiugai(bussiness);
        result=new ObjectMapper().writeValueAsString(result);
        return result;
    }
    @ResponseBody
    @RequestMapping("/del")
    public String del(String id) throws JsonProcessingException {
        String result="删除成功";
        bussinessService.del(id);
        result=new ObjectMapper().writeValueAsString(result);
        return result;
    }
    @RequestMapping("/showadd")
    public String showadd(){
        return "add";
    }
    @ResponseBody
    @RequestMapping("/buadd")
    public String buadd(Bussiness bussiness) throws JsonProcessingException {
        String result="添加成功";
        bussinessService.buadd(bussiness);
        result=new ObjectMapper().writeValueAsString(result);
        return result;
    }
    @ResponseBody
    @RequestMapping("/fenye")
    public BussinessDTO fenye(int yema){
        int totcount=bussinessService.findcount();
        int ye =(yema-1)*3;
        BussinessDTO dto = new BussinessDTO(bussinessService.findbussiness(ye),totcount,yema);
        System.out.println(dto);
        return dto;

    }
    @ResponseBody
    @RequestMapping("/applyfenye")
    public ApplyDTO applyfenye(int yema){
        int totcount = applyService.findcount();
        int ye =(yema-1)*3;
        ApplyDTO dto = new ApplyDTO(applyService.findbussiness(ye),totcount,yema);
        System.out.println(dto);
        return dto;

    }
    @ResponseBody
    @RequestMapping("/shouquan")
    public String shouquan(String id) throws JsonProcessingException {
        String result="审核成功!";
        applyService.del(id);
        result=new ObjectMapper().writeValueAsString(result);
        return result;
    }

    @RequestMapping("/z")
    public String z(){
        return "z";
    }

    @ResponseBody
    @RequestMapping("/findrole")
    public BusinessRoleDto findrole(int yema, String role){
        int ye =(yema-1)*3;
        List<Bussiness> l = bussinessService.findByRole(role,ye);
        int totcount = bussinessService.findtotcount(role);
        int totpage= (totcount%3==0)?(totcount/3): (int) (Math.ceil(totcount/3));
        BusinessRoleDto businessRoleDto = new  BusinessRoleDto(l,totpage,yema,totcount);

        return businessRoleDto;
    }
}
