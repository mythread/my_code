<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="etp.note.vo.Note"%>
<html>
<head>
	<title>JSP+JDBC 留言管理程序——登陆</title>
</head>
<body>
<center>
	<h1>留言管理范例 —— JSP + JDBC实现</h1>
	<hr>
	
<form action="ListNotes" method="POST">
	请输入查询内容：<input type="text" name="keyword">
	<input type="submit" value="查询">
</form>
<h3><a href="insert.jsp">添加新留言</a></h3>
<table width="80%" border="1">
	<tr>
		<td>留言ID</td>
		<td>标题</td>
		<td>作者</td>
		<td>内容</td>
		<td>删除</td>
	</tr>
	<%
			//获取在ListNotes中设置的List
		    List<Note> notes=(List)request.getAttribute("notes");
			Iterator<Note> rs=notes.iterator();
			while(rs.hasNext())
			{
				Note note=(Note)rs.next();
				int id = note.getId();
				String title = note.getTitle();
				String author = note.getAuthor();
				String content = note.getContent();
	%>
				<tr>
					<td><%=id%></td>
					<td><a href="Update?id=<%=id%>"><%=title%></a></td>
					<td><%=author%></td>
					<td><%=content%></td>
					<td><a href="Delete?id=<%=id%>">删除</a></td>
				</tr>
	<%
			}
			// 判断i的值是否改变，如果改变，则表示有内容，反之，无内容
			if(notes.size()==0)
			{
				// 进行提示
	%>
				<tr>
					<td colspan="5">没有任何内容！！！</td>
				</tr>
	<%
			}
	%>
</table>
</center>
</body>
</html>