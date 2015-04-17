package com.ibm.etp.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ibm.etp.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 
 * </dd>
 * </dl>
 * @copyright :Copyright 2012, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2012-03-29	WXIBM		ZXC				create
 */
public class UserRegAction extends ActionSupport implements ServletRequestAware{
	private String userid;
	
	private String username;
	
	private String password;
	
	private String confirmpassword;
	
	private String email;
	
	private HttpServletRequest request;

	public String execute() throws Exception {
		if (UserDao.hasUserid(userid)) {
			this.addActionError("用户ID已存在");
			return INPUT;
		}
		UserDao.userreg(userid, username, confirmpassword, email);
		request.getSession().setAttribute("userid", userid);
		request.getSession().setAttribute("username", username);
		
		return SUCCESS;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}
	
}
