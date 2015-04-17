import com.ibm.etp.action.LoginActionTest;
import com.ibm.etp.dao.UserDaoTest;
import com.ibm.etp.dao.UserDaoTest1;

import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for default package");
		//$JUnit-BEGIN$
        //添加测试类
	    suite.addTestSuite(LoginActionTest.class);
	    
	    suite.addTestSuite(UserDaoTest.class);
	    
	    suite.addTestSuite(UserDaoTest1.class);
		
		//$JUnit-END$
		return suite;
	}

}
