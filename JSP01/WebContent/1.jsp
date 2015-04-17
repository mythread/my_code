<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <body>
<h1>表达式</h1>
<%="hello world"%><br/>
<b>PI的值是：</b><%=Math.PI %><br/>
<b>100,99的最大值是 :</b><%=Math.max(100,99) %><br/>
<b>100,99的最小值是 :</b><%=Math.min(100,99) %><br/>
<b>3+2-5 结果是:</b><%=3+2-5 %><br/>
<b>(3+2)==5 结果是:</b><%=(3+2)==5 %><br/>
<b>(3+2)!=5 结果是:</b><%=(3+2)!=5 %><br/>
</body>
</html>
