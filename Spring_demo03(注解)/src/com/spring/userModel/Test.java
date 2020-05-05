package com.spring.userModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.userModel.controller.UserController;
import com.spring.userModel.dao.UserDaoImpl;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("user.xml");
		UserController uc = ac.getBean("userController",UserController.class);
		System.out.println(uc);
		uc.addUser();		
	}
}
