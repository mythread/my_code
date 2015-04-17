<%@ page contentType="text/html;charset=gb2312"%>
<html>
<head>
	<title>JSP+JDBC 留言管理程序——登陆</title>
</head>
<body>
<center>
	<h1>留言管理范例 —— JSP + JDBC实现</h1>
	<hr>
	<br>
			<h2>登陆成功</h2>
			<h2>欢迎<font color="red" size="12">
				<%=session.getAttribute("uname")%>
			</font>光临ETP留言程序</h2>
			<h3><a href="ListNotes">进入留言管理页面</a></h3>
</center>
</body>
</html>