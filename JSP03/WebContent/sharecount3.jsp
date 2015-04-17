<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>sharecount3.jsp</title>
    
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
  <h1>sharecount3.jsp</h1>
    <jsp:useBean id="counter" class="etp.bean.AccessCount" scope="application">
    <jsp:setProperty name="counter" property="firstPage" value="sharecount3.jsp"/>
    </jsp:useBean>
    <a href="sharecount1.jsp">sharecount1.jsp</a><br>
    <a href="sharecount2.jsp">sharecount2.jsp</a><br>
    统计：<br>
 firstPage： <jsp:getProperty name="counter" property="firstPage"/>
   被访问： <jsp:getProperty name="counter" property="accessCount"/>次
    <jsp:setProperty name="counter" property="accessCountIncrement" value="1"/>
  </body>
</html>
