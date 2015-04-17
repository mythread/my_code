<%
	String name = (String)session.getAttribute("name") ;
	String password = (String)session.getAttribute("password") ;
%>
<h1>name : <%=name%></h1>
<h1>password : <%=password%></h1>