package etp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author helinxfy 2010
 */

public class FilterLifeCycle implements Filter {
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("������"+this.getClass().getName()+"��ʼ�� init(FilterConfig arg0)");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("** ������"+this.getClass().getName()+" doFilter (chain֮ǰ)...");
		chain.doFilter(request, response);
		System.out.println("** ������"+this.getClass().getName()+" doFilter (chain֮��)...");
	}

	public void destroy() {
		System.out.println("������"+this.getClass().getName()+"���� destroy()");
	}

}
