package com.woniu.shopservice;

import com.woniu.entity.BusinessApply;
import com.woniu.entity.Bussiness;
import org.springframework.stereotype.Service;

@Service
public interface ApplyService {
    void addApply(BusinessApply businessApply);
    Bussiness findBusiness(Bussiness bussiness);
    Bussiness findB(String account);
}
