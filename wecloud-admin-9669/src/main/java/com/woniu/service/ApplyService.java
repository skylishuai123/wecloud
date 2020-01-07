package com.woniu.service;

import com.woniu.entity.BusinessApply;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplyService {
    List<BusinessApply> findbussiness(int ye);
    int findcount();
    void del(String id);
    BusinessApply findOne(String id);
}
