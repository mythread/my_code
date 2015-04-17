package etp.note.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etp.note.factory.DAOFactory;

/**
 * Servlet implementation class for Servlet: Delete
 *
 */
 public class Delete extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Delete() {
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
		out.println("  <HEAD><TITLE>Delete</TITLE></HEAD>");
		out.println("  <BODY>");
		// ���ղ���
		int id = 0 ;
		try
		{
			id = Integer.parseInt(request.getParameter("id")) ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			DAOFactory.getNoteDAOInstance().delete(id) ;
			response.setHeader("refresh","2;URL=ListNotes") ;
			out.print("����ɾ���ɹ����������ת�������б�ҳ������<br>");
			out.print("���û����ת���밴<a href=\"ListNote\">����</a>������");
		}catch(Exception e)
		{
			response.setHeader("refresh","2;URL=ListNotes") ;
			out.print("����ɾ��ʧ�ܣ��������ת�������б�ҳ������<br>");
			out.print("���û����ת���밴<a href=\"ListNote\">����</a>������");
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