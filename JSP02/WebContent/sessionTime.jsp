<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.util.*"%>
<%
	long l = session.getCreationTime() ;
	long l2 = session.getLastAccessedTime() ;
%>
<h1>session CREATE : <%=new Date(l)%></h1>
<h1>session last access: <%=new Date(l2)%></h1>
<h1><%=(l2-l)/1000%></h1>