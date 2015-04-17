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
本页面可以防止重复提交！<br>
<s:form action="form">
<s:textfield name="username" label="username"></s:textfield>
<s:submit></s:submit>
<!-- 这是拦截器的token -->
<s:token></s:token>
</s:form>
</body>
</html>