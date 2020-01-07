package com.woniu.service;

import com.woniu.entity.Bussiness;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BussinessService {
    List<Bussiness> findallbussiness();
    Bussiness findupbussiness(String id);
    void xiugai(Bussiness bussiness);
    void del(String id);
    void buadd(Bussiness bussiness);
    int findcount();
    List<Bussiness> findbussiness(int ye);
    List<Bussiness> findByRole(String role,int ye);
    int findtotcount(String role);
}
