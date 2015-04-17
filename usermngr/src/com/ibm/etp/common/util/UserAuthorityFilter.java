package com.ibm.etp.common.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserAuthorityFilter
 */
public class UserAuthorityFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		boolean isLogin = this.isLogin((HttpServletRequest) request);
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String whitelist1 = req.getContextPath() + "/error";
		String whitelist2 = req.getContextPath() + "/index.jsp";
		String whitelist3 = req.getContextPath() + "/login";
		String whitelist4 = req.getContextPath() + "/css";
		String whitelist5 = req.getContextPath() + "/js";
		String whitelist6 = req.getContextPath() + "/userregini";
		String whitelist7 = req.getContextPath() + "/UserReg";
		String whitelist9 = req.getContextPath() + "/userreg";
		String whitelist10 = req.getContextPath() + "/errorRegister.jsp";	
		String whitelist8 = req.getContextPath() + "/";

		String requesturi = req.getRequestURI().toLowerCase();
		System.out.println(requesturi);
		
		if (requesturi.startsWith(whitelist1)
				|| requesturi.startsWith(whitelist2)
				|| requesturi.startsWith(whitelist3)
				|| requesturi.startsWith(whitelist4)
				|| requesturi.startsWith(whitelist5)
				|| requesturi.startsWith(whitelist6)
				|| requesturi.startsWith(whitelist7)
				|| requesturi.startsWith(whitelist9)
				|| requesturi.startsWith(whitelist10)
				|| requesturi.equals(whitelist8)) {
			
			chain.doFilter(request, response);
		} else if (isLogin(req)) {
			
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(req.getContextPath() + "/ErrorIni");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	private boolean isLogin(HttpServletRequest request) {
		Object object = request.getSession().getAttribute("userid");
		if (object == null) {
			return false;
		}
		return true;
	}

}
