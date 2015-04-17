package etp.lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author helinxfy 2010
 */

public class LifeCycle extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LifeCycle() {
		System.out.println("构造LifeCycle()");
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	/*public void init() throws ServletException {
		System.out.println("初始化init()");
	}*/
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LifeCycle 初始化init(ServletConfig config)");
		System.out.println(config.getInitParameter("name"));
	}
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		System.out.println("销毁 destroy()");
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("调用doGet()");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("调用doPost()");
	}

	
}
