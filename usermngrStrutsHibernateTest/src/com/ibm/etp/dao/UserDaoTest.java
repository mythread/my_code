/**
 * 对usermngrStrutsHibernate工程UserDao类进行用例测试
 */
package com.ibm.etp.dao;

import junit.framework.TestCase;

/**
 * @author zxc
 * 
 */
public class UserDaoTest extends TestCase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for
	 * {@link com.ibm.etp.dao.UserDao#isUseridAvailable(java.lang.String)}.
	 */
	public void testIsUseridAvailable() {

		assertEquals("用离线数据进行用例测试", true, UserDao.isUseridAvailable("zhangsan"));

		assertEquals("用离线数据进行用例测试", false, UserDao
				.isUseridAvailable("sdafajjf"));

		assertEquals("用离线数据进行用例测试", true, UserDao.isUseridAvailable("lisi0000"));

	}

	/**
	 * Test method for
	 * {@link com.ibm.etp.dao.UserDao#hasUserid(java.lang.String)}.
	 */
	public void testHasUserid() {
	}

	/**
	 * Test method for
	 * {@link com.ibm.etp.dao.UserDao#isLogin(java.lang.String, java.lang.String)}
	 * .
	 */
	public void testIsLogin() {
	}

	/**
	 * Test method for
	 * {@link com.ibm.etp.dao.UserDao#getUsername(java.lang.String)}.
	 */
	public void testGetUsername() {
	}

	/**
	 * Test method for
	 * {@link com.ibm.etp.dao.UserDao#setOnline(java.lang.String)}.
	 */
	public void testSetOnline() {
	}

	/**
	 * Test method for
	 * {@link com.ibm.etp.dao.UserDao#getUserinfo(java.lang.String)}.
	 */
	public void testGetUserinfo() {
	}

	/**
	 * Test method for
	 * {@link com.ibm.etp.dao.UserDao#search(java.lang.String, java.lang.String)}
	 * .
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
	 * Test method for
	 * {@link com.ibm.etp.dao.UserDao#useredit(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	public void testUseredit() {
	}

	/**
	 * Test method for
	 * {@link com.ibm.etp.dao.UserDao#userreg(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}
	 * .
	 */
	public void testUserreg() {
	}

}
