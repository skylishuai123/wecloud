package com.woniu.shopserviceimp;


import com.woniu.dao.ApplyDao;
import com.woniu.entity.BusinessApply;
import com.woniu.entity.Bussiness;
import com.woniu.shopservice.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyServiceImp implements ApplyService {
    @Autowired
    private ApplyDao applyDao;
    @Override
    public void addApply(BusinessApply businessApply) {
        applyDao.addApply(businessApply);
    }

    @Override
    public Bussiness findBusiness(Bussiness bussiness) {
        return applyDao.findBusiness(bussiness);
    }

    @Override
    public Bussiness findB(String account) {
        return applyDao.findB(account);
    }
}
