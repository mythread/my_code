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
<s:form action="userAdd">
<s:textfield name="userAddVO.username" label="username"/>
<s:textfield name="userAddVO.password" label="password"/>
<s:textfield name="userAddVO.confirmpwd" label="confirmpwd"/>
<s:textfield name="userAddVO.email" label="email"/>
<s:submit />
</s:form>
</body>
</html>