package com.spring.datasource;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

public class Test {
	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("datasource.xml");
		DruidDataSource dataSource = ac.getBean("datasource",DruidDataSource.class);
		System.out.println(dataSource.getConnection());
		
	}
}
