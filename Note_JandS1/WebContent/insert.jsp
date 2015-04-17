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
	<form action="Insert" method="post">
		<table>
			<tr>
				<td colspan="2">添加新留言</td>
			</tr>
			<tr>
				<td>标题：</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>内容：</td>
				<td><textarea name="content" cols="30" rows="6"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="添加">
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
	<h3><a href="list_notes.jsp">回到留言列表页</a></h3>
</center>
</body>
</html>