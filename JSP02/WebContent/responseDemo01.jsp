<%@page contentType="text/html;charset=gb2312"%>
<%!
	// �˴�Ϊȫ�ֱ�������ʼ��һ��
	int i = 0 ;
%>
<%
	// һ����ˢ��һ�Σ�ÿ��ʹi����
	response.setHeader("refresh","2;URL=responseDemo02.jsp") ;
%>
<h1><%=i++%></h1>
�������ת����ӭҳ������<br>
���û����ת���밴<a href="responseDemo02.jsp">����</a>������