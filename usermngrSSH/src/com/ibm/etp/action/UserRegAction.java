package com.ibm.etp.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ibm.etp.dto.UserRegDTO;
import com.ibm.etp.service.UserRegService;
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
public class UserRegAction extends ActionSupport implements ServletRequestAware{
	private String userid;
	
	private String username;
	
	private String password;
	
	private String confirmpassword;
	
	private String email;
	
	private HttpServletRequest request;
	
	private UserRegService userRegService;
	
	private UserRegDTO userRegDTO;

	public String execute() throws Exception {
		this.populateDTO();
		if (!userRegService.insertUserReg()) {
			this.addActionError("用户ID已存在");
			return INPUT;
		}
		request.getSession().setAttribute("userid", userid);
		request.getSession().setAttribute("username", username);
		return SUCCESS;
	}

	private void populateDTO() {
		userRegDTO.setEmail(email);
		userRegDTO.setPassword(password);
		userRegDTO.setUserid(userid);
		userRegDTO.setUsername(username);
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

	public void setUserRegService(UserRegService userRegService) {
		this.userRegService = userRegService;
	}

	public UserRegService getUserRegService() {
		return userRegService;
	}

	public void setUserRegDTO(UserRegDTO userRegDTO) {
		this.userRegDTO = userRegDTO;
	}

	public UserRegDTO getUserRegDTO() {
		return userRegDTO;
	}
	
}
