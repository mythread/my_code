<%@page contentType="text/html;charset=gb2312"%>
<form action="login.jsp" method="post">
	�û�����<input type="text" name="uname"><br>
	���룺<input type="text" name="upass"><br>
	<input type="submit" value="��½">
</form>

<%
	// �ж��Ƿ�����������
	// �����ύ��ҳ���У�����Գ����һ��������������
	if(request.getParameter("uname")!=null&&request.getParameter("upass")!=null)
	{
		// ��һ�ε�ʱ�򣬲�����ȡ������Ĳ���
		String name = request.getParameter("uname") ;
		String password = request.getParameter("upass") ;
		System.out.println(name) ;
		System.out.println(password) ;
		if("helinxfy".equals(name)&&"java02".equals(password))
		{
			// ��ʾ��½�ɹ�
			// ͨ��flag�����ж��û��Ƿ��Ѿ���½
			session.setAttribute("flag","ok") ;
			// ��ת��welcome.jsp
			response.sendRedirect("welcome.jsp") ;
		}
		else
		{
			// ��½ʧ�ܣ���ӡ����
	%>
			<h3>��½ʧ�ܣ�����</h3>
	<%
		}
	}
%>