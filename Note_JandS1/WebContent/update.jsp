<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.sql.*"%>
<%@page import="etp.note.vo.Note"%>
<html>
<head>
	<title>JSP+JDBC ���Թ�����򡪡���½</title>
</head>
<body>
<center>
	<h1>���Թ����� ���� JSP + JDBCʵ��</h1>
	<hr>
	<%
	Note note=(Note)request.getAttribute("note");
	%>
	<form action="UpdateDo" method="post">
		<table>
			<tr>
				<td colspan="2">�޸�����</td>
			</tr>
			<tr>
				<td>���⣺</td>
				<td><input type="text" name="title" value="<%=note.getTitle()%>"></td>
			</tr>
			<tr>
				<td>���ݣ�</td>
				<td><textarea name="content" cols="30" rows="6"><%=note.getContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" name="id" value="<%=note.getId()%>">
					<input type="submit" value="����">
					<input type="reset" value="����">
				</td>
			</tr>
		</table>
	</form>
	<h3><a href="ListNotes">�ص������б�ҳ</a></h3>
</center>
</body>
</html>