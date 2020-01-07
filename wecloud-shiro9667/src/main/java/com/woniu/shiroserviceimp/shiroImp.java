package com.woniu.shiroserviceimp;

import com.woniu.dao.UserDao;
import com.woniu.entity.User;
import com.woniu.shiroservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class shiroImp implements UserService {

    @Autowired
    private UserDao d;
    @Override
    public User findUser(String account) {
        return d.findUser(account);
    }

    @Override
    public void addUser(User user) {
        d.addUser(user);
    }

    @Override
    public User finduserByname(String name) {
        return d.finduserByname(name);
    }


}
