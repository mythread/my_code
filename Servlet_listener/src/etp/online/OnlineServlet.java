package etp.online;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: OnlineServlet
 *
 */
 public class OnlineServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public OnlineServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>List</TITLE><meta http-equiv=\"Content-Type\" content=\"text/html; charset=GB2312\"></HEAD>");
		out.println("  <BODY>");
		HttpSession session=request.getSession();
		//向session接收输入的用户名 
			if(request.getParameter("name")!=null)
			{
				System.out.println(request.getParameter("name"));
				session.setAttribute("uname",request.getParameter("name")) ;
			}
		out.print("<h2>在线人员</h2>");
		out.print("<hr>");
			List l = (List)getServletContext().getAttribute("alluser") ;
			Iterator iter = l.iterator() ;
			while(iter.hasNext())
			{
				out.print("<li>"+iter.next());
			}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}   	  	    
}