package com.ibm.etp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.etp.dao.UserDao;

/**
 * Servlet implementation class UserSearchServlet
 */
public class UserSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");

		List result = UserDao.search(userid, username);

		request.setAttribute("s_userid", userid);
		request.setAttribute("s_username", username);

		request.setAttribute("result", result);

		request.getRequestDispatcher("/usersearchIni").forward(request,
				response);
	}

}
