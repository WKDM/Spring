package com.spring.life;

public class Person {
	private Integer id;
	private String sex;
	private String name;
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		System.out.println("第二个生命周期：依赖注入");
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person() {
		System.out.println("第一个生命周期：创建对象");
	}
	public void init(){
		System.out.println("第三个生命周期：初始化");
	}
	@Override
	public String toString() {
		return "第五个生命周期:"+"Person [id=" + id + ", sex=" + sex + ", name=" + name + "]";
	}
	public void destroy(){
		System.out.println("第五个生命周期：销毁");
	}
	
}
