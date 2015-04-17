package com.ibm.etp.dao;

import java.util.List;

import com.ibm.etp.hibernate.pojo.TUser;

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
 * 1.00		2011-11-4	IBM			Peng Peng					create
 */
public interface UserDao {
	public boolean isUseridAvailable(String userid);

	public boolean hasUserid(String userid);

	public boolean isLogin(String userid, String password);

	public String getUsername(String userid);

	public void setOnline(String userid);

	public TUser getUserinfo(String userid);

	public List search(String userid, String username);

	public void logout(String userid);

	public void logoutall();

	public void useredit(String userid, String username,
			String password, String email);

	public void userreg(String userid, String username, String password,
			String email);

}
