package com.etp.stu.hibernate.pojo;

// Generated 2012-4-5 18:56:58 by Hibernate Tools 3.3.0.GA

import java.util.Date;

/**
 * TUserinfo generated by hbm2java
 */
public class TUserinfo implements java.io.Serializable {

	private String userid;
	private String username;
	private Integer age;
	private Date birthday;

	public TUserinfo() {
	}

	public TUserinfo(String userid) {
		this.userid = userid;
	}

	public TUserinfo(String userid, String username, Integer age, Date birthday) {
		this.userid = userid;
		this.username = username;
		this.age = age;
		this.birthday = birthday;
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

}
