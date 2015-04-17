package etp.note.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author helinxfy 2010
 */

public class LoginFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Session属于HTTP范畴，所以ServletRequest对象需要先转换成HttpServletRequest对象
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// 如果申请的路径不是/login.html或/servlet/Login则应进行session验证
		// 以查看是否非法操作
		// public java.lang.String getServletPath()
		// Returns the part of this request's URL that calls the servlet.
		boolean flag = req.getServletPath().equals("/login.jsp")
				|| req.getServletPath().equals("/Login");
		if (!flag) {
			// 如果session不为空，则可以浏览其他页面
			if (session.getAttribute("uname") != null) {
				chain.doFilter(request, response);
			} else {
				// 跳转到登陆页
				res.sendRedirect("/Note_servlet/login.jsp");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {

	}
}
