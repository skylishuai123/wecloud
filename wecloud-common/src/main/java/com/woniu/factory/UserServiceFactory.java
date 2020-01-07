package com.woniu.factory;

import com.woniu.entity.User;
import com.woniu.commnonservice.UserService;
import feign.hystrix.FallbackFactory;

import java.util.ArrayList;
import java.util.List;

public class UserServiceFactory  implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public List<User> finduser() {
                User u = new User(500,"发生错误",null,null,null,null,null,null,null);
                List<User> l = new ArrayList<>();
                l.add(u);
                return l;
            }
        };
    }
}
