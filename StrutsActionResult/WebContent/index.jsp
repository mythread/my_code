<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
试试看下面不同的result跳转类型<br>

<a href="<s:url action="dispatcher"/>">dispatcher(default)</a><br>
<a href="<s:url action="redirect"/>">redirect</a><br>
<a href="<s:url action="chain"/>">chain(跳到其他action，forward方式)</a><br>
<a href="<s:url action="redirectAction"/>">redirectAction</a><br>
<hr>
试试看下面的全局result跳转类型<br>
<a href="<s:url action="globalResult"/>">globalResult</a><br>
<hr>
试试看下面的Dynamic result跳转类型<br>
<a href="dynamicResult.jsp">dynamicResult.jsp</a><br>
</body>
</html>