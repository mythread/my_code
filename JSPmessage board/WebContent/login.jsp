<%@ page contentType="text/html;charset=gb2312"%>
<html>
<head>
	<title>JSP+JDBC 留言管理程序——登陆</title>
</head>
<body>
<center>
	<h1>留言管理范例 —— JSP + JDBC实现</h1>
	<hr>
	<form action="Login" method="post">
	<table width="40%">
	<tr>
		<td>用户名：</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>密&nbsp;&nbsp;码：</td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="submit" value="登录">
			<input type="reset" value="重置">
		</td>
	</tr>
	</table>
	</form>
</center>
</body>
</html>