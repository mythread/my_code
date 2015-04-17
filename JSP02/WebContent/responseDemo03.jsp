<%@page contentType="text/html;charset=gb2312"%>
<h1>欢迎光临：responseDemo03.jsp</h1>
<%
	System.out.println("** 跳转之前...") ;
%>
<%
	// 进行跳转
	response.sendRedirect("responseDemo04.jsp?id=mldn") ;
%>
<!--jsp:forward page="responseDemo04.jsp"/-->
<%
	System.out.println("** 跳转之后...") ;
%>
