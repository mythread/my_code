<%@ page contentType="text/html;charset=gbk"%>
<html>
<body>
<%
	// 接收内容
	request.setCharacterEncoding("GBK") ;
	String name = request.getParameter("uname") ;
	String inst[] = request.getParameterValues("inst") ;
%>
<h1>用户名为：<%=name%></h1>
<h1>兴趣为：
<%
	for(int i=0;i<inst.length;i++)
	{
%>
		<%=inst[i]%>、
<%
	}
%>
</h1>
</body>
</html>