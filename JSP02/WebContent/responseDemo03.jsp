<%@page contentType="text/html;charset=gb2312"%>
<h1>��ӭ���٣�responseDemo03.jsp</h1>
<%
	System.out.println("** ��ת֮ǰ...") ;
%>
<%
	// ������ת
	response.sendRedirect("responseDemo04.jsp?id=mldn") ;
%>
<!--jsp:forward page="responseDemo04.jsp"/-->
<%
	System.out.println("** ��ת֮��...") ;
%>
