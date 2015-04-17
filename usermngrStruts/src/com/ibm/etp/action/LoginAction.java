package com.ibm.etp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ibm.etp.dao.UserDao;
import com.ibm.etp.vo.LoginVO;
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
 * 1.00		2012-03-29	WXIBM		ZXC				create
 */
public class LoginAction extends ActionSupport implements ServletRequestAware{
	private LoginVO loginVO;
	
	private HttpServletRequest request;
	
	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public String login() {
		//判断用户是否是会员且是第一次登录
		if (!UserDao.isUseridAvailable(loginVO.getUserid())) {
			return "useriderror";
		} else if (!UserDao.isLogin(loginVO.getUserid(), loginVO.getPassword())) {//判断用户名与密码是否匹配
			return "passworderror";
		} else {
			String username = UserDao.getUsername(loginVO.getUserid());
			//登录成功,设置用户状态为在线
			UserDao.setOnline(loginVO.getUserid());
			
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
