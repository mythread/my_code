package com.ibm.etp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.etp.dao.UserDao;
import com.ibm.etp.dao.UserDaoImpl;

/**
 * Servlet implementation class LogoutAllServlet
 */
public class LogoutAllServlet extends HttpServlet {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void destroy() {
		userDao.logoutall();
	}

	public void init() throws ServletException {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDao = (UserDao) beanFactory.getBean("userDao");
		userDao.logoutall();
	}

}
