<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Date"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try{
	Context initCtx=new InitialContext();
	Context ctx=(Context)initCtx.lookup("java:comp/env");
	Object obj=(Object)ctx.lookup("jdbc/db");
	javax.sql.DataSource ds=(javax.sql.DataSource)obj;
	Connection conn=ds.getConnection();
	Statement stmt=conn.createStatement();
	String sql="select * from person";
	ResultSet rs=stmt.executeQuery(sql);
	rs.next();
	String s=rs.getString(1);
	out.print(s);
	rs.close();
	stmt.close();
	conn.close();
}catch(Exception e)
{
out.print(e.toString())	;
}
%>
</body>
</html>