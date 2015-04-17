<%
	String name = (String)request.getAttribute("name") ;
	String password = (String)request.getAttribute("password") ;
%>
<h1>name : <%=name%></h1>
<h1>password : <%=password%></h1>
<a href="requestDemo03.jsp">requestDemo03.jsp</a>