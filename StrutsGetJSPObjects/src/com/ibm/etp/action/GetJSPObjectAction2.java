package com.ibm.etp.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

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
 * 1.00		2010-8-10	IBM			Peng						create
 */
public class GetJSPObjectAction2 extends ActionSupport implements RequestAware, SessionAware, ApplicationAware{
	
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;
	
	public String execute() throws Exception {
		// 向request对象放入一个属性
		request.put("email", "abc@163.com");
		// 向session对象放入一个属性
		session.put("now", new Date());
		// 向application对象放入一个属性
		application.put("projname", "StrutsGetJSPObjects");
		return SUCCESS;
	}

	public void setRequest(Map arg0) {
		this.request = arg0;
	}

	public void setSession(Map arg0) {
		this.session = arg0;
	}

	public void setApplication(Map arg0) {
		this.application = arg0;
	}

}
