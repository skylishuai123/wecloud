package com.woniu.service;

import com.woniu.entity.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    Admin findUser(Admin admin);
}
