<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  String name = "etp";
%>
<h1>comment</h1>
<!--这个注释用户可以看到[<%=name%>] -->
<%--这个注释用户看不到[<%=name%>] --%>

</body>
</html>