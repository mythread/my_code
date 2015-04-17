<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>core</title>
</head>
<body bgcolor="#FFFFFF">
　　<hr>
　　<% session.setAttribute("test_session","testValue_session");%>
　　<% request.setAttribute("test_request","testValue_request");%>
　　<% application.setAttribute("test_application","testValue_application");%>
	<% application.setAttribute("test_all","testValue_application");%>
　	<% session.setAttribute("test_all","testValue_session");%>
　　<% request.setAttribute("test_all","testValue_request");%>
　
　　
　　<hr>输出一个字符串：
　　<c:out value="test"/>
　　<hr>带有body的c:out标签，但是body不输到客户端。
　　<% for(int i=0;i<5;i++){%>
　　<c:out value="test2">
　　<% out.println("i");
	i++;%>
　　</c:out>
　　<% }%>
　　<hr>
　　<c:out value="2<10" escapeXml="true">
　　</c:out>
　　<hr>获得session中的属性：
　　<c:out value="${test_session}"/>
　　<hr>获得request中的属性：
　　<c:out value="${test_request}"/>
　　<hr>获得application中的属性：
　　<c:out value="${test_application}"/>
　　<hr>测试表达式语言优先获得哪个属性：request,session,application
　　<c:out value="${test_all}"/>
　　<hr>输出一个默认值：
　　<c:out value="${notex}" default="这个值不存在"/>
　　</body>
</html>
