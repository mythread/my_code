<%@page contentType="text/html;charset=gb2312"%>
<%--
	�û������ȵ�½֮�󣬲��ܷ��ʴ�ҳ��
	����û�û�е�½������ʾ�û���ȥ���µ�½
--%>
<%
	if(session.getAttribute("flag")!=null)
	{
		// session�����ù���������½��
%>
<h1>��ӭ���ٱ�ҳ������</h1>
<h2><a href="logout.jsp">ע��</a></h2>
<%
	}
	else
	{
		// �������ת��login.jspҳ��֮��
		response.setHeader("refresh","2;URL=login.jsp") ;
%>
<h1>����δ��½�����ȵ�½������</h1>
<%
	}
%>