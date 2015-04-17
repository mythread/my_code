<%@page contentType="text/html;charset=gb2312"%>
<%
	if(session.isNew())
	{
%>
<h1>欢迎光临本页！！！</h1>
<%
	}
	else
	{
%>
<h1>您不是新的session</h1>
<%
	}
%>