package com.ibm.etp.action;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 得到jsp常用的隐式对象
 * </dd>
 * </dl>
 * @copyright :Copyright 2010, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2010-8-23	IBM			Peng						create
 */
public class GetJSPObjectAction1 extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private ServletContext application;
	
	public String execute() throws Exception {
		// 向request对象放入一个属性
		request.setAttribute("email", "abc@163.com");
		// 向session对象放入一个属性
		session.setAttribute("now", new Date());
		// 向application对象放入一个属性
		application.setAttribute("projname", "StrutsGetJSPObjects");
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
		session = request.getSession();
		application = session.getServletContext();
	}

	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}

}
