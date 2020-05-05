package com.spring.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac =new ClassPathXmlApplicationContext("beans_di.xml");
		Student st1 = ac.getBean("s1", Student.class);
		System.out.println(st1);
		
		Student st2 = ac.getBean("s2", Student.class);
		System.out.println(st2);
		
		Student st3 = ac.getBean("s3", Student.class);
		System.out.println(st3);
		Student st4 = ac.getBean("s4", Student.class);
		System.out.println(st4);
		
		Teacher te1 = ac.getBean("t1",Teacher.class);
		System.out.println(te1);
		Teacher te2 = ac.getBean("t2",Teacher.class);
		System.out.println(te2);
		Teacher te3 = ac.getBean("t3",Teacher.class);
		System.out.println(te3);
	}
}
