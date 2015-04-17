package etp.note.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etp.note.factory.DAOFactory;
import etp.note.vo.Note;

/**
 * Servlet implementation class for Servlet: Insert
 *
 */
 public class Insert extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Insert() {
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
		out.println("  <HEAD><TITLE>Insert</TITLE></HEAD>");
		out.println("  <BODY>");
		Note note=new Note();
		//从insert.html中读取参数信息，并保存到note中
		note.setTitle(request.getParameter("title"));
		note.setContent(request.getParameter("content"));
		//利用登录时所保存的用户名作为note中的作者信息
		note.setAuthor((String)request.getSession().getAttribute("uname"));
		try
		{
			DAOFactory.getNoteDAOInstance().insert(note) ;
			response.setHeader("refresh","2;URL=ListNotes") ;
			out.print("留言添加成功，两秒后跳转到留言列表页！！！<br>");
			out.print("如果没有跳转，请按<a href=\"ListNote\">这里</a>！！！");
		}
		catch(Exception e)
		{
			response.setHeader("refresh","2;URL=ListNotes") ;
			out.print("留言添加失败，两秒后跳转到留言列表页！！！<br>");
			out.print("如果没有跳转，请按<a href=\"ListNote\">这里</a>！！！");
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