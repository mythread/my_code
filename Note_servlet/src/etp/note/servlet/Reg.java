package etp.note.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etp.note.factory.DAOFactory;
import etp.note.vo.Person;

/**
 * Servlet implementation class for Servlet: Reg
 *
 */
 public class Reg extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Reg() {
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
		// �����յĲ�������person
		Person person=new Person();
		person.setId(request.getParameter("id"));
		person.setName(request.getParameter("name"));
		person.setPassword(request.getParameter("password"));
		try
		{
			DAOFactory.getPersonDAOInstance().reg(person);
			request.getSession().setAttribute("uname", person.getName());
			response.setHeader("refresh","2;URL=suc.html") ;
			out.print("ע��ɹ����������ת�������б�ҳ������<br>");
			out.print("���û����ת���밴<a href=\"ListNote\">����</a>������");
		}catch(Exception e)
		{
			e.printStackTrace();
			response.setHeader("refresh","2;URL=ListNotes") ;
			out.print("ע��ʧ�ܣ��������ת�������б�ҳ������<br>");
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