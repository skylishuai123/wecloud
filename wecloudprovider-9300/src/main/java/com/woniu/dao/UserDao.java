package com.woniu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.woniu.entity.User;

public interface UserDao {
	@Select("select * from user")
	List<User> finduser();
}
