<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<title>include demo使用&lt;jsp:include&gt;</title>
</head>
<body>
incl.jsp
<BR>
<jsp:include page="incl.jsp">
	<jsp:param name="ref1" value="helinxfy"/>
	<jsp:param name="ref2" value="JAVA"/>
</jsp:include>
<BR>
incl.txt
<jsp:include page="incl.txt">
	<jsp:param name="ref1" value="helinxfy"/>
	<jsp:param name="ref2" value="JAVA"/>
</jsp:include>
<BR>
incl.inc
<jsp:include page="incl.inc"/>
</body>
</html>