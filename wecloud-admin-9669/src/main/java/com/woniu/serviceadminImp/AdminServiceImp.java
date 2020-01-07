package com.woniu.serviceadminImp;

import com.woniu.dao.AdminDao;
import com.woniu.entity.Admin;
import com.woniu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    @Cacheable("findUser")
    public Admin findUser(Admin admin) {
        return adminDao.findUser(admin);
    }
}
