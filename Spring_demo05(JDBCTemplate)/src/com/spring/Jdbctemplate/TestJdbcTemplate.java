package com.spring.Jdbctemplate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TestJdbcTemplate {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("jdbc.xml");
	JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate",JdbcTemplate.class);
	
	@Test
	public void testUpdate() {
		//jdbcTemplate.update("insert into emp values(null,'张三',23,'男')");
//		String sql = "insert into emp values(null,?,?,?)";
//		jdbcTemplate.update(sql, "李四",25,"女");	//单个增删改
		
//		//正确的批量删除
//		String eid = "1,17,18";
//		String sql = "delete from emp where eid in ("+eid+")";	
//		jdbcTemplate.update(sql);
		
//		//错误的批量删除
//		String sql = "delete from emp where eid in (?)";	
//		String eid = "1,17,18";
//		jdbcTemplate.update(sql,eid);
		
		
//		//模糊查询错误的方法
//		String mohu = "a";
//		String sql = "select * from emp where like '%?%'";
		
//		//模糊查询正确的方法
//		String mohu = "a";
//		String sql = "select * from emp where like concat('%',?,'%')";
	}
	
	@Test
	public void testBatchUpdate(){
		String sql = "insert into emp values(null,?,?,?)";
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[]{"a1",1,"男"});
		list.add(new Object[]{"a2",2,"女"});
		list.add(new Object[]{"a3",3,"男"});
		jdbcTemplate.batchUpdate(sql,list);//批量增删改
	}
	
	@Test
	public void testQueryForObject(){
////		jdbcTemplate.queryForObject(sql, requiredType)用来获取单个的值
////		jdbcTemplate.queryForObject(sql, rowMapper)用来获取单条数据
//		String sql = "select eid,ename,eage,esex from emp where eid = ?";
//		RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);//将列名（字段名或字段名的别名）与属性名映射
//		Emp emp = jdbcTemplate.queryForObject(sql,new Object[] {23},rowMapper);
//		System.out.println(emp);
		
		
		String sql = "select count(*) from emp";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
		
	}
	@Test
	public void testQuery(){
		String sql = "select eid,ename,eage,esex from emp";
		RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);
		List<Emp> lists = jdbcTemplate.query(sql, rowMapper);
		for(Emp emp:lists){
			System.out.println(emp);
		}
	}
	

}
