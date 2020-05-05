package com.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
		Student student = ac.getBean("student",Student.class);
		System.out.println(student);
	}
}
