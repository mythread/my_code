package org.webshopping.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UserLoginFilter implements Filter {

	private String path;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		Object object = req.getSession().getAttribute("username");
		if (object != null) {
			chain.doFilter(request, response);

		} else {
			req.getRequestDispatcher(path).forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.path = config.getInitParameter("path");
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
