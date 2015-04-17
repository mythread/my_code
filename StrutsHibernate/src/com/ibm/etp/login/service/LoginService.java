package com.ibm.etp.login.service;

import com.ibm.etp.login.dao.LoginDao;
import com.ibm.etp.login.dto.LoginDTO;

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
public class LoginService {
	private LoginDTO dto;
	
	public LoginService(LoginDTO dto) {
		this.dto = dto;
	}

	public LoginDTO getDto() {
		return dto;
	}

	public void setDto(LoginDTO dto) {
		this.dto = dto;
	}

	public boolean login() {
		return LoginDao.login(dto.getUsername(), dto.getPassword());
		
	}
}
