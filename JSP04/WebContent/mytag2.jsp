 <%@page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib  prefix="etptag" uri="http://ibmetp.wx/java02/1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Encoding Test</title>
    <meta content="content-type" content="text/html;charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <etptag:echo msg="IBM Java02,good good study,day day up!"></etptag:echo><br>
   <etptag:formatdate date="<%=new Date()%>" type="both" pattern="MM/dd/yyyy"/>
   <etptag:echo msg="<%=application.getServerInfo() %>"/><br>
   <etptag:formatdate date="<%=new Date()%>" type="short" pattern="date"/><br>
   <etptag:formatdate date="<%=new Date()%>" type="short" pattern="time"/><br>
   <etptag:formatdate date="<%=new Date()%>" type="short" pattern="all"/>
  </body>
</html>
