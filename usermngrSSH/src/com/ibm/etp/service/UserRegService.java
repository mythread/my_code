package com.ibm.etp.service;

import com.ibm.etp.dao.UserDao;
import com.ibm.etp.dto.UserRegDTO;

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
public class UserRegService {
	private UserRegDTO userRegDTO;
	
	private UserDao userDao;
	
	public UserRegDTO getUserRegDTO() {
		return userRegDTO;
	}

	public void setUserRegDTO(UserRegDTO userRegDTO) {
		this.userRegDTO = userRegDTO;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean insertUserReg() {
		if (userDao.findIsUseridAvailable(userRegDTO.getUserid())) {
			return false;
		}
		userDao.insertUserreg(userRegDTO.getUserid(), userRegDTO.getUsername(), userRegDTO.getPassword(), userRegDTO.getEmail());
		
//		if (Integer.MAX_VALUE != 0) {
//			throw new RuntimeException();
//		}
		
		userDao.insertUserreg("woiruowe", userRegDTO.getUsername(), userRegDTO.getPassword(), userRegDTO.getEmail());
		return true;
	}
}
