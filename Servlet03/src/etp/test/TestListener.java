package etp.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: TestListener
 * 
 */
public class TestListener extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public TestListener() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//…Ë÷√ Ù–‘£¨“‘±„≤‚ ‘º‡Ã˝∆˜
		//application
		getServletContext().setAttribute("1", "1");
		
		//session
		HttpSession session=request.getSession();
		session.setAttribute("name","helinxfy") ;
		// session.removeAttribute("name") ;
		//session.invalidate() ;
		
		//request
		request.setAttribute("name","request") ;
		request.setAttribute("name","request") ;
		request.removeAttribute("name");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}