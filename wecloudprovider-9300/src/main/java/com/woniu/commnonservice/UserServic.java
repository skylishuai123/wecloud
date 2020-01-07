package com.woniu.commnonservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woniu.entity.User;
@Service
public interface UserServic {
	List<User> finduser();
}
