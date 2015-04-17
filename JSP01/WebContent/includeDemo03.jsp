<%-- 使用此语句处理显示中的乱码 --%>
<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>include demo</title>
</head>
<body>
<jsp:include page="incl.jsp"/>
<jsp:include page="incl.txt"/>
<jsp:include page="incl.inc"/>
</body>
</html>