package com.woniu.dao;


import com.woniu.entity.BusinessApply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ApplyDao {
    @Select("select * from apply LIMIT #{ye},3")
    List<BusinessApply> findbussiness(int ye);
    @Select("select count(*) from apply")
    int findcount();
    @Delete("delete  from apply where id=#{id}")
    void del(String id);
    @Select("select * from apply where id=#{id}")
    BusinessApply findOne(String id);
}
