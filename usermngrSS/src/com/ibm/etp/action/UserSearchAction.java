package com.ibm.etp.action;

import java.util.ArrayList;
import java.util.List;

import com.ibm.etp.dao.UserDao;
import com.ibm.etp.dao.UserDaoImpl;
import com.ibm.etp.hibernate.pojo.TUser;
import com.ibm.etp.vo.UserSearchResultVO;
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
 * 1.00		2011-10-31	IBM			Peng Peng					create
 */
public class UserSearchAction extends ActionSupport {
	private String userid;
	
	private String username;
	
	private UserDao userDao;
	
	private List<UserSearchResultVO> result = new ArrayList<UserSearchResultVO>();
	
	public String search() {
		List result = userDao.search(userid, username);
		for (int i = 0; i < result.size(); i++) {
			Object[] objects = (Object[]) result.get(i);
			TUser tUser = (TUser) objects[0];
			UserSearchResultVO resultVO = new UserSearchResultVO();
			resultVO.setUserid(tUser.getUserId());
			resultVO.setUsername(tUser.getUserName());
			resultVO.setEmail(tUser.getUserMailaddress());
			resultVO.setStatusName(tUser.getTStatus().getStatusName());
			this.result.add(resultVO);
		}
		return SUCCESS;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List getResult() {
		return result;
	}

	public void setResult(List result) {
		this.result = result;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}
	
}
