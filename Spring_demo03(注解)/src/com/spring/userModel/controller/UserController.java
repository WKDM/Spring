package com.spring.userModel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.userModel.service.UserService;
import com.spring.userModel.service.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	public void addUser(){
		userService.addUser();
	}
	
	public UserController(){
		System.out.println("UserController");
	}
}
