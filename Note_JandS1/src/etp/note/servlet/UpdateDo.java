package etp.note.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etp.note.factory.DAOFactory;
import etp.note.vo.Note;

/**
 * Servlet implementation class for Servlet: Update
 *
 */
 public class UpdateDo extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public UpdateDo() {
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
		out.println("  <HEAD><TITLE>UpdateDo</TITLE></HEAD>");
		out.println("  <BODY>");
		Note note=new Note();
		note.setTitle(request.getParameter("title"));
		note.setAuthor((String)request.getSession().getAttribute("uname"));
		note.setId(Integer.parseInt(request.getParameter("id")));
		note.setContent(request.getParameter("content"));
		System.out.println(note.getTitle()+","+note.getContent());
		try{
			DAOFactory.getNoteDAOInstance().update(note) ;
			response.setHeader("refresh","2;URL=ListNotes") ;
			out.print("留言修改成功，两秒后跳转到留言列表页！！！<br>");
			out.print("如果没有跳转，请按<a href=\"ListNote\">这里</a>！！！");
		}catch(Exception e)
		{
			e.printStackTrace();
			response.setHeader("refresh","2;URL=ListNotes") ;
			out.print("留言修改失败，两秒后跳转到留言列表页！！！<br>");
			out.print("如果没有跳转，请按<a href=\"ListNote\">这里</a>！！！");
		}
		out.println("</BODY>");
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