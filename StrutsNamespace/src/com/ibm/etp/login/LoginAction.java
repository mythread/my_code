package com.ibm.etp.login;

import com.opensymphony.xwork2.ActionSupport;

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
 * 1.00		2010-8-22	IBM			Peng						create
 */
public class LoginAction extends ActionSupport{

	public String execute() throws Exception {
		System.out.println("【com.ibm.etp.login.LoginAction.execute()】" + "");
		return SUCCESS;
	}

}
