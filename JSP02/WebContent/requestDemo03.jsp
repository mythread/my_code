<%
	String name = (String)request.getAttribute("name") ;
	String password = (String)request.getAttribute("password") ;
%>
<h1>name : <%=name%></h1>
<h1>password : <%=password%></h1>