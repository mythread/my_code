package com.ibm.etp.login.action;

import com.ibm.etp.login.dto.LoginDTO;
import com.ibm.etp.login.service.LoginService;
import com.ibm.etp.login.vo.LoginVO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 
 * </dd>
 * </dl>
 * @copyright :Copyright 2011, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2011-8-31	IBM			Peng Peng					create
 */
public class LoginAction extends ActionSupport{
	private LoginVO loginVO;
	
	
	public LoginVO getLoginVO() {
		LoginDTO dto = new LoginDTO();
		LoginService loginService = new LoginService(dto);
		
		boolean isLogin = loginService.login();
		
		
		return loginVO;
	}


	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}


	public String login() {
		return SUCCESS;
	}
}
