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
	//encoding �������
	protected String encoding = null;
	//������������Ϣ����
	protected FilterConfig filterConfig = null;
	//�Ƿ���ӿͻ������������� ��Ϊtrue����ԣ�Ϊfalse�򲻺���
	protected boolean ignore = true;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		//��ó�ʼ������
		this.encoding = filterConfig.getInitParameter("encoding");
		String value = filterConfig.getInitParameter("ignore");
		//���δ�������ļ�web.xml������ignoreѡ���Ĭ������Ϊtrue
		if (value == null)
			this.ignore = true;
		//���������ļ���ignore�Ǵ�д����Сд��true���Խ�ignore����Ϊtrue
		else if (value.equalsIgnoreCase("true"))
			this.ignore = true;
		//��������ļ���ignore����Ϊ��д����Сд��yes���Խ�ignore����Ϊtrue
		else if (value.equalsIgnoreCase("yes"))
			this.ignore = true;
		else
			this.ignore = false;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//��ignoreΪtrue��δ���ñ���ʱ
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
