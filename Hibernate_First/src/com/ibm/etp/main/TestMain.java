package com.ibm.etp.main;

import java.util.Date;

import com.ibm.etp.dao.UserinfoDAO;
import com.ibm.etp.hibernate.pojos.Userinfo;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 
 * </dd>
 * </dl>
 * @copyright :Copyright 2010, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2011-5-9	IBM			Peng Peng					create
 */
public class TestMain {
	public static void main(String[] args) {
		Userinfo userinfo = new Userinfo();
		userinfo.setId(382);
		userinfo.setUserid("zs");
		userinfo.setUsername("张三");
		userinfo.setAge(24);
		userinfo.setBirthday(new Date());
		userinfo.setIsmarry("2");
		userinfo.setSalary(29443.3D);

		UserinfoDAO.executeUpdate(userinfo);
		
	}
	
}
