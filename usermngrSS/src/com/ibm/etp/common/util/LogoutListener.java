package com.ibm.etp.common.util;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.etp.dao.UserDao;

/**
 * Application Lifecycle Listener implementation class LogoutListener
 *
 */
public class LogoutListener implements HttpSessionListener {

	private UserDao userDao;
	
    public void sessionCreated(HttpSessionEvent arg0) {
    }

	public void sessionDestroyed(HttpSessionEvent arg0) {
    	HttpSession session = arg0.getSession();
    	String userid = (String) session.getAttribute("userid");
    	if (userid != null) {
    		BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
    		userDao = (UserDao) beanFactory.getBean("userDao");
    		userDao.logout(userid);
    	}
    }

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
