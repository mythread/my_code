
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>response对象测试</title>
</head>
<body>
response对象测试
<%
response.setContentType("text/html; charset=utf-8");
response.sendRedirect("response2.jsp");
%>
</body>
</html>
