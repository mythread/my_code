package com.ibm.etp.dao;

import java.util.List;

import com.ibm.etp.hibernate.pojo.TUser;

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
public interface UserDao {
	public boolean findIsUseridAvailable(String userid);

	public boolean findUserid(String userid);

	public boolean findIsLogin(String userid, String password);

	public String getUsername(String userid);

	public void updateOnline(String userid);

	public TUser getUserinfo(String userid);

	public List getAll(String userid, String username);

	public void updateLogoutStatus(String userid);

	public void updateLogoutall();

	public void updateUser(String userid, String username,
			String password, String email);

	public void insertUserreg(String userid, String username, String password,
			String email);

}
