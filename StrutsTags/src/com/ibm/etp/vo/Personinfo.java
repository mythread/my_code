package com.ibm.etp.vo;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 
 * </dd>
 * </dl>
 * @copyright :Copyright 2010, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2010-8-24	IBM			Peng						create
 */
public class Personinfo {
	private String userid;
	private String username;
	private String email;
	private int age;

	public Personinfo(String userid, String username, String email, int age) {
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.age = age;
	}
	
	public String toString() {
		return "userid:" + userid + "\tuesrname:" + username + "\temail:" + email + "\tage" + age;
	}


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
