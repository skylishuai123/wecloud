package com.woniu.serviceadminImp;

import com.woniu.dao.ApplyDao;
import com.woniu.dao.BussinessDao;
import com.woniu.entity.BusinessApply;
import com.woniu.entity.Bussiness;
import com.woniu.service.ApplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplyServiceImp implements ApplyService {
    @Autowired
    private ApplyDao applyDao;
    @Autowired
    private BussinessDao bussinessDao;
    @Override
    public List<BusinessApply> findbussiness(int ye) {
        return applyDao.findbussiness(ye);
    }

    @Override
    public int findcount() {
        return applyDao.findcount();
    }

    @Transactional
    @Override
    public void del(String id) {
       BusinessApply businessApply= findOne(id);
       Bussiness bussiness = new Bussiness(0,businessApply.getAccount(),businessApply.getName(),businessApply.getPassword(),null,null,businessApply.getPhone(),businessApply.getJointime(),1);
       bussinessDao.buadd(bussiness);
       applyDao.del(id);

    }

    @Override
    public BusinessApply findOne(String id) {
        return applyDao.findOne(id);
    }
}
