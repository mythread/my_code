package com.ibm.etp.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ibm.etp.dao.UserDao;
import com.ibm.etp.hibernate.pojo.TUser;
import com.ibm.etp.vo.UserEditVO;
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
public class UserEditAction extends ActionSupport implements
		ServletRequestAware {

	private UserEditVO userEditVO;

	private HttpServletRequest request;

	private UserDao userDao;
	

	public UserEditVO getUsereditvo() {
		return userEditVO;
	}

	public void setUsereditvo(UserEditVO usereditvo) {
		this.userEditVO = usereditvo;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public String init() throws Exception {
//		userEditVO.setUserid((String) request.getSession().getAttribute(
//				"userid"));
		
//		if (userEditVO.getUserid() != null) {
			//TUser tUser = userDao.getUserinfo(userEditVO.getUserid());
			TUser tUser = userDao.getUserinfo((String) request.getSession().getAttribute("userid"));
			
//			System.out.println("************");
//			System.out.println("   "+userEditVO.getUserid()+"   ");
//			System.out.println("************");
			
//			userEditVO.setUsername(tUser.getUserName());
//			userEditVO.setEmail(tUser.getUserMailaddress());
//			userEditVO.setUsername("zhangcai");
//			userEditVO.setEmail("zxc");
//		}
		return SUCCESS;
	}

	public String execute() {
		userDao.updateUser(userEditVO.getUserid(), userEditVO.getUsername(),
				userEditVO.getConfirmpassword(), userEditVO.getEmail());
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}
	
}