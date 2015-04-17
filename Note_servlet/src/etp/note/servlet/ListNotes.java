package etp.note.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etp.note.factory.DAOFactory;
import etp.note.vo.Note;

/**
 * Servlet implementation class for Servlet: List
 *
 */
 public class ListNotes extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ListNotes() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int i=0;
		String sql=null;
		String keyword=request.getParameter("keyword");
		List<Note> all=null;
		try{
			if(keyword==null)
			{
				all=DAOFactory.getNoteDAOInstance().queryAll();
			}
			else
			{
				all=DAOFactory.getNoteDAOInstance().queryByLike(keyword);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>List Notes</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print(" <form action=\"ListNotes\" method=\"POST\">");
		out.print("�������ѯ���ݣ�<input type=\"text\" name=\"keyword\">");
		out.print("<input type=\"submit\" value=\"��ѯ\">");
		out.print("</form>");
		out.print("<h3><a href=\"insert.html\">���������</a></h3>");
		out.println("<table width=\"80%\" border=\"1\">");
		out.print("<tr>");
		out.print("<td>����ID</td>");
		out.print("<td>����</td>");
		out.print("<td>����</td>");
		out.print("<td>����</td>");
		out.print("<td>ɾ��</td>");
		out.print("</tr>");
		Iterator<Note> iter = all.iterator() ;
		while(iter.hasNext())
		{
			Note note = (Note)iter.next() ;
			i++ ;
			// ����ѭ����ӡ����ӡ�����е����ݣ��Ա����ʽ
			// �����ݿ���ȡ������
			int id = note.getId() ;
			String title = note.getTitle() ;
			String author = note.getAuthor() ;
			String content = note.getContent() ;

			if(keyword!=null)
			{
				// ��Ҫ�����ݷ���
				title = title.replaceAll(keyword,"<font color=\"red\">"+keyword+"</font>") ;
				author = author.replaceAll(keyword,"<font color=\"red\">"+keyword+"</font>") ;
				content = content.replaceAll(keyword,"<font color=\"red\">"+keyword+"</font>") ;
			}
			out.print("<tr>");
			out.print("<td>"+id+"</td>");
			out.print("<td><a href=\"Update?id="+id+"\">"+title+"</a></td>");
			out.print("<td>"+author+"</td>");
			out.print("<td>"+content+"</td>");
			out.print("<td><a href=\"Delete?id="+id+"\">ɾ��</a></td>");
			out.print("</tr>");
		}
		// �ж�i��ֵ�Ƿ�ı䣬����ı䣬���ʾ�����ݣ���֮��������
		if(i==0)
		{
			out.print("<tr>");
			out.print("<td colspan=\"5\">û���κ����ݣ�����</td>");
			out.print("</tr>");
		}
		out.print("</table>");
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