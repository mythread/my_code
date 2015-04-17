<%-- 使用此语句处理显示中的乱码 --%>
<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>include demo使用incluse指令</title>
</head>
<body>
<%@include file="incl.jsp"%>
<%@include file="incl.txt"%>
<%@include file="incl.inc"%>
</body>
</html>