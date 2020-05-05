package com.spring.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBySpring {
	public static void main(String[] args) {
		//1.初始化容器
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.通过getBean()货的对象
//		Person person = (Person) ac.getBean("person");
//		Person person = ac.getBean(Person.class);//与配置文件中的id无关
		Person person = ac.getBean("person2", Person.class);
		System.out.println(person);
		ac.close();
	}
}
