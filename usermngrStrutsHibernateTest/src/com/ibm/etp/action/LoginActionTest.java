/**
 * 对usermngrStrutsHibernate工程LoginAction类进行用例测试
 */
package com.ibm.etp.action;

import com.ibm.etp.vo.LoginVO;

import junit.framework.TestCase;

/**
 * @author zxc
 *
 */
public class LoginActionTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	private LoginAction loginaction;
	
	private LoginVO loginvo;
	
	protected void setUp() throws Exception {
	
		loginaction= new LoginAction();
		loginvo= new LoginVO();
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.ibm.etp.action.LoginAction#login()}.
	 */
	public void testLogin() {
		
		loginvo.setUserid("zhangsan");
		loginvo.setPassword("123789");
		loginaction.setLoginVO(loginvo);
	
		assertEquals("用ID错误数据进行用例测试","useriderror",loginaction.login());
	
	}

}
