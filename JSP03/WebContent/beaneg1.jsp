<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>beaneg1.jsp</title>
    
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
    <jsp:useBean id="stringbean" class="etp.bean.StringBean"/>
  初始化：<jsp:getProperty name="stringbean" property="message"/>
  <br>
  设置...
  <jsp:setProperty name="stringbean" property="message" value="Big big world!"/>
  <br> 
  取值：<jsp:getProperty name="stringbean" property="message" />
  <br>
  设置... <br>
  <%stringbean.setMessage("2nd Big big world") ;%>
  取值： <%=stringbean.getMessage() %>
  </body>
</html>
