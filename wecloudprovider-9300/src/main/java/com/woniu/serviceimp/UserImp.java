package com.woniu.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.dao.UserDao;
import com.woniu.entity.User;
import com.woniu.commnonservice.UserServic;

@Service
public class UserImp implements UserServic {
	@Autowired
	private UserDao d;
	@Override
	public List<User> finduser() {
		// TODO Auto-generated method stub
		return d.finduser();
	}

}
