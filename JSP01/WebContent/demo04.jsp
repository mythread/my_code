<%@ page contentType="text/html;charset=gbk"%>
<html>
<body>
<%
	// ��������
	request.setCharacterEncoding("GBK") ;
	String name = request.getParameter("uname") ;
	String inst[] = request.getParameterValues("inst") ;
%>
<h1>�û���Ϊ��<%=name%></h1>
<h1>��ȤΪ��
<%
	for(int i=0;i<inst.length;i++)
	{
%>
		<%=inst[i]%>��
<%
	}
%>
</h1>
</body>
</html>