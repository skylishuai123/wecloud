package com.woniu.dao;

import com.woniu.entity.BusinessApply;
import com.woniu.entity.Bussiness;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface ApplyDao {
    @Insert("insert into apply (account,password,phone,jointime,name) values (#{account},#{password},#{phone},#{jointime},#{name})")
    void addApply(BusinessApply businessApply);
    @Select("select * from business where account=#{account}")
    Bussiness findBusiness(Bussiness bussiness);
    @Select("select * from business where account=#{account}")
    Bussiness findB(String account);
}
