package com.ibm.etp.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.etp.dao.UserDao;

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
 * 1.00		2012-03-28	IBM			zxc					create
 */
public class UserSearchIniServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userid = (String) req.getSession().getAttribute("userid");
		List<HashMap<Object, Object>> list = UserDao.getUserinfo(userid);
		String username = (String) list.get(0).get("USER_NAME");
		req.setAttribute("s_userid", userid);
		req.setAttribute("s_username", username);
		
		req.getRequestDispatcher("/WEB-INF/page/usermngr/user_search.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
