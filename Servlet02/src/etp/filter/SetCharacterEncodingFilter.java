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

public class SetCharacterEncodingFilter implements Filter {
	//encoding 编码变量
	protected String encoding = null;
	//过滤器配置信息变量
	protected FilterConfig filterConfig = null;
	//是否忽视客户端自设编码变量 ，为true则忽略，为false则不忽略
	protected boolean ignore = true;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		//获得初始化参数
		this.encoding = filterConfig.getInitParameter("encoding");
		String value = filterConfig.getInitParameter("ignore");
		//如果未在配置文件web.xml中设置ignore选项，则默认设置为true
		if (value == null)
			this.ignore = true;
		//无论配置文件中ignore是大写还是小写的true，皆将ignore设置为true
		else if (value.equalsIgnoreCase("true"))
			this.ignore = true;
		//如果配置文件中ignore不论为大写还是小写的yes，皆将ignore设置为true
		else if (value.equalsIgnoreCase("yes"))
			this.ignore = true;
		else
			this.ignore = false;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//当ignore为true或未设置编码时
		if (ignore || (request.getCharacterEncoding() == null)) {
			String encoding = selectEncoding(request);
			if (encoding != null) {
				request.setCharacterEncoding(encoding);
				response.setCharacterEncoding(encoding);
			}
		}
		chain.doFilter(request, response);
	}

	protected String selectEncoding(ServletRequest request) {
		return (this.encoding);
	}

	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;

	}

}
