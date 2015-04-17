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
public class UserAction extends ActionSupport{
	public String add() {
		System.out.println("【UserAction.add()】" + "");
		return SUCCESS;
	}
	public String del() {
		System.out.println("【UserAction.del()】" + "");
		return SUCCESS;
	}
	public String update() {
		System.out.println("【UserAction.update()】" + "");
		return SUCCESS;
	}
	public String search() {
		System.out.println("【UserAction.search()】" + "");
		return SUCCESS;
	}
}
