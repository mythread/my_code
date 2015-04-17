package etp.note.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etp.note.factory.DAOFactory;
import etp.note.vo.Note;

/**
 * Servlet implementation class for Servlet: List
 * 
 */
public class ListNotes extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ListNotes() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Note> all = null;
		try {
			if (keyword == null) {
				all = DAOFactory.getNoteDAOInstance().queryAll();
			} else {
				all = DAOFactory.getNoteDAOInstance().queryByLike(keyword);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator<Note> iter = all.iterator();
		List<Note> notes = new ArrayList<Note>();
		while (iter.hasNext()) {
			Note note = (Note) iter.next();
			// 从数据库中取出内容
			String title = note.getTitle();
			String author = note.getAuthor();
			String content = note.getContent();
			if (keyword != null) {
				// 需要将数据返红
				title = title.replaceAll(keyword, "<font color=\"red\">"
						+ keyword + "</font>");
				author = author.replaceAll(keyword, "<font color=\"red\">"
						+ keyword + "</font>");
				content = content.replaceAll(keyword, "<font color=\"red\">"
						+ keyword + "</font>");
				note.setTitle(title);
				note.setAuthor(author);
				note.setContent(content);
			}
			notes.add(note);
		}
		request.setAttribute("notes", notes);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/list_notes.jsp");
		dispatcher.forward(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}