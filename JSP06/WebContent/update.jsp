<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.sql.*"%>
<%@page import="etp.note.vo.Note"%>
<html>
<head>
	<title>JSP+JDBC 留言管理程序——登陆</title>
</head>
<body>
<center>
	<h1>留言管理范例 —— JSP + JDBC实现</h1>
	<hr>
	<%
	Note note=(Note)request.getAttribute("note");
	%>
	<form action="UpdateDo" method="post">
		<table>
			<tr>
				<td colspan="2">修改留言</td>
			</tr>
			<tr>
				<td>标题：</td>
				<td><input type="text" name="title" value="<%=note.getTitle()%>"></td>
			</tr>
			<tr>
				<td>内容：</td>
				<td><textarea name="content" cols="30" rows="6"><%=note.getContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" name="id" value="<%=note.getId()%>">
					<input type="submit" value="更新">
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
	<h3><a href="ListNotes">回到留言列表页</a></h3>
</center>
</body>
</html>