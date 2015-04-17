<%
	String name = (String)pageContext.getAttribute("name") ;
	String password = (String)application.getAttribute("password") ;
%>
<h1>name : <%=name%></h1>
<h1>password : <%=password%></h1>