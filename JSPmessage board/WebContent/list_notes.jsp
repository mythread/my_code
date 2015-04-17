<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="etp.note.vo.Note"%>
<html>
<head>
	<title>JSP+JDBC ���Թ�����򡪡���½</title>
</head>
<body>
<center>
	<h1>���Թ����� ���� JSP + JDBCʵ��</h1>
	<hr>
	
<form action="ListNotes" method="POST">
	�������ѯ���ݣ�<input type="text" name="keyword">
	<input type="submit" value="��ѯ">
</form>
<h3><a href="insert.jsp">���������</a></h3>
<table width="80%" border="1">
	<tr>
		<td>����ID</td>
		<td>����</td>
		<td>����</td>
		<td>����</td>
		<td>ɾ��</td>
	</tr>
	<%
			//��ȡ��ListNotes�����õ�List
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
					<td><a href="Delete?id=<%=id%>">ɾ��</a></td>
				</tr>
	<%
			}
			// �ж�i��ֵ�Ƿ�ı䣬����ı䣬���ʾ�����ݣ���֮��������
			if(notes.size()==0)
			{
				// ������ʾ
	%>
				<tr>
					<td colspan="5">û���κ����ݣ�����</td>
				</tr>
	<%
			}
	%>
</table>
</center>
</body>
</html>