package com.spring.userModel.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	public UserDaoImpl(){
		System.out.println("UserDaoImpl");
	}

	@Override
	public void addUser() {
		System.out.println("添加成功");
	}
}
