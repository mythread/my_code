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
 * 1.00		2010-8-24	IBM			Peng						create
 */
public class TestResultAction extends ActionSupport {
	
	public String dispatcher() {
		return SUCCESS;
	}
	
	public String redirect() {
		return SUCCESS;
	}
	
	public String chain() {
		return SUCCESS;
	}
	
	public String redirectchain() {
		return SUCCESS;
	}

}
