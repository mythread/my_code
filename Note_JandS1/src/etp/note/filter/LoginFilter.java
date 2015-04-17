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
		// Session����HTTP���룬����ServletRequest������Ҫ��ת����HttpServletRequest����
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// ��������·������/login.html��/servlet/Login��Ӧ����session��֤
		// �Բ鿴�Ƿ�Ƿ�����
		// public java.lang.String getServletPath()
		// Returns the part of this request's URL that calls the servlet.
		boolean flag = req.getServletPath().equals("/login.jsp")
				|| req.getServletPath().equals("/Login");
		if (!flag) {
			// ���session��Ϊ�գ�������������ҳ��
			if (session.getAttribute("uname") != null) {
				chain.doFilter(request, response);
			} else {
				// ��ת����½ҳ
				res.sendRedirect("/Note_servlet/login.jsp");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {

	}
}
