<%@ page contentType="text/html;charset=gbk"%>
<html>
<body>
<%
	// 接收内容
	request.setCharacterEncoding("GBK") ;
	String name = request.getParameter("uname") ;
	String pass = request.getParameter("upass") ;
%>
<h1>内容为：<%=name%></h1>
<h1>内容为：<%=pass%></h1>
</body>
</html>