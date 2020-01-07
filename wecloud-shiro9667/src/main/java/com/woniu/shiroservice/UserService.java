package com.woniu.shiroservice;

import com.woniu.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUser(String account);
    void addUser(User user);
    User finduserByname(String name);
}
