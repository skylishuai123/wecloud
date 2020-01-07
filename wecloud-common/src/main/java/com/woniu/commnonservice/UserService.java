package com.woniu.commnonservice;

import com.woniu.entity.User;
import com.woniu.factory.UserServiceFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@FeignClient(name = "WONIU58-OTHER",fallbackFactory= UserServiceFactory.class)
public interface UserService {
    @RequestMapping("/find/user")
    List<User> finduser();
}
