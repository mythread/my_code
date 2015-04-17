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
		System.out.println("过滤器"+this.getClass().getName()+"初始化 init(FilterConfig arg0)");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("** 过滤器"+this.getClass().getName()+" doFilter (chain之前)...");
		chain.doFilter(request, response);
		System.out.println("** 过滤器"+this.getClass().getName()+" doFilter (chain之后)...");
	}

	public void destroy() {
		System.out.println("过滤器"+this.getClass().getName()+"销毁 destroy()");
	}

}
