package etp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author helinxfy 2010
 */

public class CharFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String content = request.getParameter("content");
		// 如果indexOf返回-1则表示没有查到所要的内容
		if (content != null) {
			if (content.indexOf("sb") == -1) {
				chain.doFilter(request, response);
			} else {
				System.out.println("有非法文字");
				((HttpServletResponse) response)
						.sendRedirect("/Servlet02/error.jsp");
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
