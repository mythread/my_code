package com.ibm.etp.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		

		
		if (isLogin(req) || this.isInWhitelist(req)) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(req.getContextPath() + "/error.html");
		}
	
	}
	
	private boolean isInWhitelist(HttpServletRequest request) {
		List<String> whitelist = new ArrayList<String>();
		whitelist.add("/index.jsp");
		whitelist.add("/css");
		whitelist.add("/js");
		whitelist.add("/login");
		whitelist.add("/logout");
		whitelist.add("/error");
		whitelist.add("/userreg");
		whitelist.add("/user_reg");
		
		String requesturi = request.getRequestURI().toLowerCase();
		String contextPath = request.getContextPath().toLowerCase();
		
		if (requesturi.equals(contextPath + "/")) {
			return true;
		}
		
		for (String string : whitelist) {
			if (requesturi.startsWith(contextPath + string)) {
				return true;
			}
		}
		return false;
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
