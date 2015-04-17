package com.ibm.etp.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ibm.etp.dao.UserDao;
import com.ibm.etp.dao.UserDaoImpl;
import com.ibm.etp.hibernate.pojo.TUser;
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
 * 1.00		2012-4-12	IBM			zxc					create
 */
public class UserEditAction1 extends ActionSupport implements
		ServletRequestAware {

	private String userid;
	
	private String username;
	
	private String password;
	
	private String confirmpassword;
	
	private String email;

	private HttpServletRequest request;
	
	private UserDao userDao;

	public String init() throws Exception {
		userid = (String) request.getSession().getAttribute("userid");
		if(userid != null) {
			TUser tUser = userDao.getUserinfo(userid);
			username = tUser.getUserName();
			email = tUser.getUserMailaddress();
		}
		return SUCCESS;
	}
	
	public String execute() {
		userDao.updateUser(userid, username, confirmpassword, email);
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
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

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}
	
}