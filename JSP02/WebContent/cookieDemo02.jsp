<%
	Cookie c[] = request.getCookies() ;
%>
<%
	for(int i=0;i<c.length;i++)
	{
		Cookie temp = c[i] ;
%>
		<h1><%=temp.getName()%> --> <%=temp.getValue()%></h1>
<%
	}
%>