package com.ibm.etp.action;

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
public class UserAddAction extends ActionSupport{
	private UserAddVO userAddVO;
	
	public String execute() throws Exception {
		System.out.println("【UserAddAction.execute()】 username:" + userAddVO.getUsername());
		System.out.println("【UserAddAction.execute()】 password:" + userAddVO.getPassword());
		System.out.println("【UserAddAction.execute()】 confirmpwd:" + userAddVO.getConfirmpwd());
		System.out.println("【UserAddAction.execute()】 email:" + userAddVO.getEmail());
		return SUCCESS;
	}

	public UserAddVO getUserAddVO() {
		return userAddVO;
	}

	public void setUserAddVO(UserAddVO userAddVO) {
		this.userAddVO = userAddVO;
	}
}
