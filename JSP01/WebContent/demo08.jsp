<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.*"%>
<html>
<body>
<%
	// ½ÓÊÕÄÚÈÝ
	request.setCharacterEncoding("GBK") ;
	Enumeration enu = request.getParameterNames() ;
%>
<%
	while(enu.hasMoreElements())
	{
		String name = (String)enu.nextElement() ;
		if(name.startsWith("**"))
		{
			String temp[] = request.getParameterValues(name) ;
%>
			<h1><%=name%> -->
<%
			for(int i=0;i<temp.length;i++)
			{
%>
				<%=temp[i]%>¡¢
<%
			}
%>
			</h1>
<%
		}
		else
		{
%>
			<h1><%=name%> --> <%=request.getParameter(name)%></h1>
<%
		}
	}
%>
</body>
</html>