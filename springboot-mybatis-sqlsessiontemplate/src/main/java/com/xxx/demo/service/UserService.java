package com.xxx.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.demo.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public Integer getCount(){
		return userDao.selectCount();
	}
}
