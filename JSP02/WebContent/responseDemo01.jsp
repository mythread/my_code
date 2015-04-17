<%@page contentType="text/html;charset=gb2312"%>
<%!
	// 此处为全局变量，初始化一次
	int i = 0 ;
%>
<%
	// 一秒种刷新一次，每次使i自增
	response.setHeader("refresh","2;URL=responseDemo02.jsp") ;
%>
<h1><%=i++%></h1>
两秒后跳转到欢迎页！！！<br>
如果没有跳转，请按<a href="responseDemo02.jsp">这里</a>！！！