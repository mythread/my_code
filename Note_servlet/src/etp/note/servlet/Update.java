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
 public class Update extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Update() {
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
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		// 接收参数
		int id = 0 ;
		try
		{
			id = Integer.parseInt(request.getParameter("id")) ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Note note = null ;
		try
		{
			note = DAOFactory.getNoteDAOInstance().queryById(id) ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			if(note!=null)
			{
				id = note.getId() ;
				String title = note.getTitle() ;
				String author = note.getAuthor() ;
				String content = note.getContent() ;
				out.print("<form action=\"UpdateDo\" method=\"post\">");
				out.print("<table>");
				out.print("<tr>");
				out.print("<td colspan=\"2\">修改留言</td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td>标题：</td>");
				out.print("<td><input type=\"text\" name=\"title\" value=\""+title+"\"></td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td>作者：</td>");
				out.print("<td><input type=\"text\" name=\"author\" value=\""+author+"\"></td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td>内容：</td>");
				out.print("<td><textarea name=\"content\" cols=\"30\" rows=\"6\">"+content+"</textarea></td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td colspan=\"2\">");
				out.print("<input type=\"hidden\" name=\"id\" value="+id+"\">");
				out.print("<input type=\"submit\" value=\"更新\">");
				out.print("<input type=\"reset\" value=\"重置\">");
				out.print("</td>");
				out.print("</tr>");
				out.print("</table>");
				out.print("</form>");
			}
			else
			{
				out.print("没有发现，要更新的内容！！<br>");
				out.print("请确认要更新的留言是否存在！！<br>");
			}
		out.print("<h3><a href=\"ListNotes\">回到留言列表页</a></h3>");
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