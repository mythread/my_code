package com.ibm.etp.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 自定义的追踪拦截器，用于打印Struts2调用的Acton类名
 * </dd>
 * </dl>
 * @copyright :Copyright 2010, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2010-7-5	IBM			Peng						create
 */
public class LogInterceptor extends AbstractInterceptor{

	/**
	 * <dl>
	 * <dt><b>Method机能概要:</b></dt>
	 * <dd>在控制台打印调用的Action类名</dd>
	 * </dl>
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		// 调用Action前，打印调用Action类名
		System.out.println("调用Action：" + invocation.getAction().getClass().getSimpleName());
		// 调用Action类
		String result = invocation.invoke();
		// 调用Action后，打印调用Action类名
		System.out.println("离开Action：" + invocation.getAction().getClass().getSimpleName());
		return result;
	}
}
