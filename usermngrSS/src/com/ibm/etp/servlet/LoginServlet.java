package com.ibm.etp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.etp.dao.UserDaoImpl;

/**
 * <dl>
 * <dt><b>类机能概要:</b></dt><dd>
 * 
 * </dd>
 * </dl>
 * @copyright :Copyright 2011, IBM ETP. All right reserved.
 *【Update History】
 * Version	Date		Company		Name			Anken-No	Anken-Name
 * -------	----------	----------	--------------	----------	------------
 * 1.00		2011-10-18	IBM			Peng Peng					create
 */
public class LoginServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");

//		if (!UserDaoImpl.isUseridAvailable(userid)) {
//			resp.sendRedirect(req.getContextPath() + "/ErrorIni");
//		} else if (!UserDaoImpl.isLogin(userid, password)) {
//			resp.sendRedirect(req.getContextPath() + "/ErrorIni");
//		} else {
//			String username = UserDaoImpl.getUsername(userid);
//			UserDaoImpl.setOnline(userid);
//			HttpSession session = req.getSession();
//			session.setAttribute("userid", userid);
//			session.setAttribute("username", username);
////			req.getRequestDispatcher("/page/usermngr/user_search.jsp").forward(req, resp);
//			resp.sendRedirect(req.getContextPath() + "/usersearchIni");
//		}
	}
}
