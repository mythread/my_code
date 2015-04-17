/**
 * 
 */
package com.ibm.etp.dao;

import com.ibm.etp.hibernate.pojo.TStatus;
import com.ibm.etp.hibernate.pojo.TUser;
import com.ibm.etp.hibernate.util.HibernateSessionFactory;
import com.ibm.etp.vo.LoginVO;

import junit.framework.TestCase;

/**
 * @author ETP
 *
 */
public class UserDaoTest1 extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
	
		UserDao.userreg("zhangcai", "张兄才", "123456", "zhangxiongcai337@163.com");
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {

	   UserDao.userDelete("zhangcai");
	
	}

	/**
	 * Test method for {@link com.ibm.etp.dao.UserDao#isUseridAvailable(java.lang.String)}.
	 */
	public void testIsUseridAvailable() {
	}

	/**
	 * Test method for {@link com.ibm.etp.dao.UserDao#hasUserid(java.lang.String)}.
	 */
	public void testHasUserid() {
	}

	/**
	 * Test method for {@link com.ibm.etp.dao.UserDao#isLogin(java.lang.String, java.lang.String)}.
	 */
	public void testIsLogin() {
		
		LoginVO loginVO =new LoginVO();
		
		loginVO.setUserid("zhangcai");
		loginVO.setPassword("123456");
		
		assertEquals("",true,UserDao.isLogin(loginVO.getUserid(), loginVO.getPassword()));
		
	}

	/**
	 * Test method for {@link com.ibm.etp.dao.UserDao#getUsername(java.lang.String)}.
	 */
	public void testGetUsername() {
	}

	/**
	 * Test method for {@link com.ibm.etp.dao.UserDao#setOnline(java.lang.String)}.
	 */
	public void testSetOnline() {
	}

	/**
	 * Test method for {@link com.ibm.etp.dao.UserDao#getUserinfo(java.lang.String)}.
	 */
	public void testGetUserinfo() {
	}

	/**
	 * Test method for {@link com.ibm.etp.dao.UserDao#search(java.lang.String, java.lang.String)}.
	 */
	public void testSearch() {
	}

	/**
	 * Test method for {@link com.ibm.etp.dao.UserDao#logout(java.lang.String)}.
	 */
	public void testLogout() {
	}

	/**
	 * Test method for {@link com.ibm.etp.dao.UserDao#logoutall()}.
	 */
	public void testLogoutall() {
	}

	/**
	 * Test method for {@link com.ibm.etp.dao.UserDao#useredit(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	public void testUseredit() {
	}

	/**
	 * Test method for {@link com.ibm.etp.dao.UserDao#userreg(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	public void testUserreg() {
	}

}
