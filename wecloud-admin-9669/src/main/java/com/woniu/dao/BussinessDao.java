package com.woniu.dao;

import com.woniu.entity.Bussiness;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface BussinessDao {
    @Select("select * from business")
    List<Bussiness> findallbussiness();
    @Select("select * from business where id=#{id}")
    Bussiness findupbussiness(String id);
    @Update("update business set name=#{name},role=#{role},premession=#{premession},phone=#{phone},jointime=#{jointime} where id=#{id}")
    void xiugai(Bussiness bussiness);
    @Delete("delete  from business where id=#{id}")
    void del(String id);
    @Insert("insert into business (name,password,phone,jointime,account,state) values (#{name},#{password},#{phone},#{jointime},#{account},#{state})")
    void buadd(Bussiness bussiness);
    @Select("select count(*) from business")
    int findcount();
    @Select("select * from business LIMIT #{ye},3")
    List<Bussiness> findbussiness(int ye);
    @Select("select * from business where role=#{role} LIMIT #{ye},3")
    List<Bussiness> findByRole(String role,int ye);
    @Select("select count(*) from business where role=#{role}")
    int findtotcount(String role);

}
