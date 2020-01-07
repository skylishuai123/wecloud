package com.woniu.dao;

import com.woniu.entity.Admin;
import com.woniu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface AdminDao {
    @Select("select * from admin where account=#{account}")
    Admin findUser(Admin admin);

}
