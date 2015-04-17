<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>core</title>
</head>
<body bgcolor="#FFFFFF">
该 JSP页面在一个 session 作用域内的变量中存储 sessionvariable,<br>
 此 Web 应用程序中的其他 JSP 页面可以访问此变量.
    <p>
    <c:set var="sessionvariable" value="${80+8}"
    scope="session"  />
在删除 sessionvariable 之前先显示它的值: 
    <c:out value="${sessionvariable}"/>
    <c:remove var="sessionvariable" scope="session" />
    <br/>
显示并删除后的 sessionvariable 的值. <br />
    <c:out value="${sessionvariable}"> sessionvariable为NULL </c:out>
　　</body>
</html>
