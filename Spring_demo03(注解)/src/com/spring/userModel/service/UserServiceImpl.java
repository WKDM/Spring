package com.spring.userModel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.userModel.dao.UserDao;
import com.spring.userModel.dao.UserDaoImpl;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	public UserServiceImpl(){
		System.out.println("UserServiceImpl");
	}

	@Override
	public void addUser() {
		
		userDao.addUser();
	}
}
