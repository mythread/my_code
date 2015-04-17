<%@page contentType="text/html;charset=gb2312"%>
<form action="login.jsp" method="post">
	用户名：<input type="text" name="uname"><br>
	密码：<input type="text" name="upass"><br>
	<input type="submit" value="登陆">
</form>

<%
	// 判断是否有请求内容
	// 在自提交的页面中，必须对程序第一次运行做出处理
	if(request.getParameter("uname")!=null&&request.getParameter("upass")!=null)
	{
		// 第一次的时候，并不能取得请求的参数
		String name = request.getParameter("uname") ;
		String password = request.getParameter("upass") ;
		System.out.println(name) ;
		System.out.println(password) ;
		if("helinxfy".equals(name)&&"java02".equals(password))
		{
			// 表示登陆成功
			// 通过flag属性判断用户是否已经登陆
			session.setAttribute("flag","ok") ;
			// 跳转到welcome.jsp
			response.sendRedirect("welcome.jsp") ;
		}
		else
		{
			// 登陆失败，打印错误
	%>
			<h3>登陆失败！！！</h3>
	<%
		}
	}
%>