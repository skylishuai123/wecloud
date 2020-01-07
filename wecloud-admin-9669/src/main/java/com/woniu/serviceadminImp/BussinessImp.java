package com.woniu.serviceadminImp;


import com.woniu.dao.BussinessDao;
import com.woniu.entity.Bussiness;
import com.woniu.service.BussinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BussinessImp implements BussinessService {
    @Autowired
    private BussinessDao d;

    @Override
    public List<Bussiness> findallbussiness() {

        return d.findallbussiness();
    }

    @Override
    public Bussiness findupbussiness(String id) {
        return d.findupbussiness(id);
    }

    @Override
    public void xiugai(Bussiness bussiness) {
        d.xiugai(bussiness);
    }

    @Override
    public void del(String id) {
        d.del(id);
    }

    @Override
    public void buadd(Bussiness bussiness) {
        d.buadd(bussiness);
    }

    @Override
    public int findcount() {
        return d.findcount();
    }

    @Override
    public List<Bussiness> findbussiness(int ye) {
        return d.findbussiness(ye);
    }


    @Override
    public List<Bussiness> findByRole(String role, int ye) {
        return d.findByRole(role,ye);
    }

    @Override
    public int findtotcount(String role) {
        return d.findtotcount(role);
    }


}
