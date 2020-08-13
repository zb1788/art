package com.boz.bean;

import java.util.Date;

public class Employee {
	private Integer id;
	private String name;
	private String genre;
	private Integer age;
	private Date createTime;
	
	private Department department;
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGender(String genre) {
		this.genre = genre;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", genre=" + genre
				+ ", age=" + age + ", createTime=" + createTime
				+ ", department=" + department + "]";
	}

}
