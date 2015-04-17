<%@page contentType="text/html;charset=gb2312"%>
<%--
	用户必须先登陆之后，才能访问此页面
	如果用户没有登陆，则提示用户回去重新登陆
--%>
<%
	if(session.getAttribute("flag")!=null)
	{
		// session被设置过，正常登陆过
%>
<h1>欢迎光临本页！！！</h1>
<h2><a href="logout.jsp">注销</a></h2>
<%
	}
	else
	{
		// 两秒后跳转到login.jsp页面之中
		response.setHeader("refresh","2;URL=login.jsp") ;
%>
<h1>您还未登陆，请先登陆！！！</h1>
<%
	}
%>