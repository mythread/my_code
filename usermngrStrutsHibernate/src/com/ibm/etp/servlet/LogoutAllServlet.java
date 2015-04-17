package com.ibm.etp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.ibm.etp.dao.UserDao;

/**
 * Servlet implementation class LogoutAllServlet
 */
public class LogoutAllServlet extends HttpServlet {

	public void destroy() {
		UserDao.logoutall();
	}

	public void init() throws ServletException {
		UserDao.logoutall();
	}

	
	
}
