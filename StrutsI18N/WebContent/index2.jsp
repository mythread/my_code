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
本页面使用国际化动态产生<br>
<s:property value="getText('welcome')"/><br>
<s:form action="login" theme="simple">
<s:property value="getText('username')"/><input type="text" id="username" name="username" /><br>
<s:submit></s:submit>
</s:form>
<s:debug></s:debug>
</body>
</html>