package com.woniu.dao;

import com.woniu.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    @Select("select * from user where account=#{account}")
    User findUser(String account);
    @Insert("insert into user (account,password,email,name,idcard,phone) values (#{account},#{password},#{email},#{name},#{idcard},#{phone})")
    void addUser(User user);
    @Select("select * from user where name=#{name}")
    User finduserByname(String name);

}
