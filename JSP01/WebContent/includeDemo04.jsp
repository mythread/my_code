<%-- 使用此语句处理显示中的乱码 --%>
<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>include demo</title>
</head>
<body>
<%
	int i = 100 ;
%>
<h1>includeDemo04.jsp:<%=i%></h1>
<jsp:include page="include.jsp"/>
</body>
</html>