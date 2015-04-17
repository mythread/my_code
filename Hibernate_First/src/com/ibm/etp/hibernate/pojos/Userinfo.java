package com.ibm.etp.hibernate.pojos;

// Generated 2011-5-9 13:35:48 by Hibernate Tools 3.3.0.GA

import java.util.Date;

/**
 * Userinfo generated by hbm2java
 */
public class Userinfo implements java.io.Serializable {

	private Integer id;
	private String userid;
	private String username;
	private Integer age;
	private Date birthday;
	private Double salary;
	private String ismarry;

	public Userinfo() {
	}

	public Userinfo(Integer id) {
		this.id = id;
	}

	public Userinfo(Integer id, String userid, String username, Integer age,
			Date birthday, Double salary, String ismarry) {
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.age = age;
		this.birthday = birthday;
		this.salary = salary;
		this.ismarry = ismarry;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getIsmarry() {
		return this.ismarry;
	}

	public void setIsmarry(String ismarry) {
		this.ismarry = ismarry;
	}

}