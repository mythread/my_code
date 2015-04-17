package com.ibm.etp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ibm.etp.dao.UserDao;
import com.ibm.etp.dao.UserDaoImpl;
import com.ibm.etp.vo.LoginVO;
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
 * 1.00		2011-10-27	IBM			Peng Peng					create
 */
public class LoginAction extends ActionSupport implements ServletRequestAware{
	private LoginVO loginVO;
	
	private HttpServletRequest request;
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public String login() {
		if (!userDao.isUseridAvailable(loginVO.getUserid())) {
			return "useriderror";
		} else if (!userDao.isLogin(loginVO.getUserid(), loginVO.getPassword())) {
			return "passworderror";
		} else {
			String username = userDao.getUsername(loginVO.getUserid());
			userDao.setOnline(loginVO.getUserid());
			
			HttpSession session = request.getSession();
			session.setAttribute("userid", loginVO.getUserid());
			session.setAttribute("username", username);
		}
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}
	
}
