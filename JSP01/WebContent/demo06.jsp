<%@ page contentType="text/html;charset=gbk"%>
<html>
<body>
<%
	// ��������
	request.setCharacterEncoding("GBK") ;
	String name = request.getParameter("uname") ;
	String pass = request.getParameter("upass") ;
%>
<h1>����Ϊ��<%=name%></h1>
<h1>����Ϊ��<%=pass%></h1>
</body>
</html>