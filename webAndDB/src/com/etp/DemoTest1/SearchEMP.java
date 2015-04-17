package com.etp.DemoTest1;

/**
 * @author zxc
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchEMP
 */
public class SearchEMP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SearchEMP() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Connection 对象
		Connection connection = null;

		// PreparedStatement 对象
		PreparedStatement statement = null;

		// 结果集对象
		ResultSet rs = null;

		// 查找驱动类，此操作会抛出异常，需要捕获
		try {
			// oracle的驱动类路径
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 获得与oracle数据库操作的statement，此操作会抛出异常
		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "scott", "123");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		// 从浏览器获得客户需要查询的员工employeeNO,employeeName
		String NO = request.getParameter("employeeNO");
		String Name = request.getParameter("employeeName");

		// // 定义一个标记变量flag
		// boolean flag = false;

		// 获得与oracle数据库操作的prepareStatement
		// 此操作会抛出异常
		try {
			statement = connection
					.prepareStatement("SELECT * FROM EMP,DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO AND EMPNO="
							+ "'" + NO + "'" + "AND ENAME=" + "'" + Name + "'");
		} catch (SQLException e) {
			e.printStackTrace();

		}
		// // 使用statement对象执行sql查询语句，此操作会抛出异常
		// try {
		// rs = statement.executeQuery();
		// // flag = true;
		// } catch (SQLException e) {
		// e.printStackTrace();
		// // 抛出异常并返回查询失败信息!
		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
		// out.println("<html><head>");
		// out.println("<title>系统错误!</title></head>");
		// out.println("<body>对不起!查询失败!</body></html>");
		// out.flush();
		// }

		// 向浏览器返回查询信息并打印HTML
		try {
			rs = statement.executeQuery();
			// flag = true;
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			while (rs.next()) {
				out.println("<html><head>");
				out.println("<title>返回查询信息!</title></head>");
				out.println("<body></body></html>");
				out
						.println("<form id=\"form1\" name=\"form1\" method=\"post\" action=\"\">");
				out.println("<table width=\"100%\" border=\"1\">");
				out.println("<tr>");
				out.println("<td>EMPNO</td>");
				out.println("<td>ENAME</td>");
				out.println("<td>JOB</td>");
				out.println("<td>MGR</td>");
				out.println("<td>HIREDATE</td>");
				out.println("<td>SAL</td>");
				out.println("<td>COMM</td>");
				out.println("<td>DEPTNO</td>");
				out.println("<td>DNAME</td>");
				out.println("<td>LOC</td>");
				out.println("</tr><tr>");
				out.println("<tr>");
				out.println(" <td>" + rs.getString(1) + "&nbsp;</td>");
				out.println(" <td>" + rs.getString(2) + "&nbsp;</td>");
				out.println(" <td>" + rs.getString(3) + "&nbsp;</td>");
				out.println(" <td>" + rs.getString(4) + "&nbsp;</td>");
				out.println(" <td>" + rs.getString(5) + "&nbsp;</td>");
				out.println(" <td>" + rs.getString(6) + "&nbsp;</td>");
				out.println(" <td>" + rs.getString(7) + "&nbsp;</td>");
				out.println(" <td>" + rs.getString(8) + "&nbsp;</td>");
				out.println(" <td>" + rs.getString(9) + "&nbsp;</td>");
				out.println(" <td>" + rs.getString(10) + "&nbsp;</td>");
				out.println("</tr>");
				out.println("</table></form>");
				out.println("</body></html>");
				out.flush();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// 抛出异常并返回查询失败信息!
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><head>");
			out.println("<title>system error!</title></head>");
			out.println("<body>sorry!search failing!</body></html>");
			out.flush();
		}
		// 关闭所有连接，此操作会抛出异常
		try {
			rs.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 设置所有对象为null
		rs = null;
		statement = null;
		connection = null;

	}
}