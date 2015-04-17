<%@ page language="java" import="java.util.*;" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>方法的声明</title>
	</head>

	<body>
    <%!// 这是一个方法的声明
	public float divide(float x, float y) {
		return x / y;
	}%>
本页面用于调用一个自己创建的方法divide(float x, float y)，并打印出2/3的结果<br /><br />

&lt;%<br />
float f = divide(2, 3);<br />
out.print(f);<br />
%&gt;<br /><br />

divide(2, 3)的结果是：<br />
<%
	float f = divide(2, 3);
	out.print(f);
%><br /><br />

  &lt;%= divide(2, 3) %&gt;<br />
  
  另外一种调用方法打印出divide(2, 3)的结果：<br /><br />
  <%=divide(2, 3)%>
  </body>
</html>
