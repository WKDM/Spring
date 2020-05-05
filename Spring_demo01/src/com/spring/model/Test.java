package com.spring.model;

public class Test {
	public static void main(String[] args) {
		//在person类中使用的是默认的无参构造
		Person person = new Person();
		person.setId(1);
		person.setName("王可");
		System.out.println(person);
	}
}
