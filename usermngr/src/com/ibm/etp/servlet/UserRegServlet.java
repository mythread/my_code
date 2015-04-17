package com.ibm.etp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.etp.dao.UserDao;
import com.ibm.etp.vo.RegisterVO;

/**
 * Servlet implementation class UserRegServlet
 */
public class UserRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("这里进入UserRegServlet");
		if (request.getParameter("userid").trim().isEmpty()
				|| request.getParameter("username").trim().isEmpty()
				|| request.getParameter("password").trim().isEmpty()) {

			response.sendRedirect(request.getContextPath()
					+ "/WEB-INF/page/common/errorRegister.jsp");

		} else {
			if (!request.getParameter("password").trim().equals(
					request.getParameter("confirmpassword").trim())) {
				response.sendRedirect(request.getContextPath()
						+ "/WEB-INF/page/common/errorRegister.jsp");

			} else {
				RegisterVO registerVO = new RegisterVO();

				registerVO.setUserid(request.getParameter("userid").trim());
				registerVO.setUsername(request.getParameter("username").trim());
				registerVO.setPassword(request.getParameter("password").trim());
				registerVO.setEmail(request.getParameter("email").trim());

				UserDao.InsertInfo(registerVO);

				response.sendRedirect(request.getContextPath() + "/LoginIni");
			}
		}
	}

}
