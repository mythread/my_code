package com.ibm.etp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ibm.etp.dao.UserDao;
import com.ibm.etp.dao.UserDaoImpl;
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
public class LogoutAction extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request = null;
	
	private UserDao userDao;
	
	public String execute() throws Exception {
		String userid = (String) request.getSession().getAttribute("userid");
		if (userid != null) {
			userDao.updateLogoutStatus(userid);
		}
		HttpSession session = request.getSession();
		session.removeAttribute("userid");
		session.removeAttribute("username");

		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}
	
}
