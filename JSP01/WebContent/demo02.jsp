<%@ page contentType="text/html;charset=gbk"%>
<html>
<body>
<%
	// ��������
	/*
	String name = request.getParameter("uname") ;
	byte[] b = name.getBytes("ISO8859-1") ;
	name = new String(b) ;
	*/
	// String name = new String(request.getParameter("uname").getBytes("ISO8859-1")) ;
	request.setCharacterEncoding("GBK") ;
	String name = request.getParameter("uname") ;
%>
<h1>��������Ϊ��<%=name%></h1>
</body>
</html>