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
下面将显示所有表单错误信息:<br />
<font color="red">
<s:fielderror></s:fielderror>
</font>
<hr />
下面将显示所有Acton错误信息:<br />
<font color="red">
<s:actionerror/>
</font>
<hr />
<s:form action="login"> 
<s:textfield label="userid(长度大于3，小于10。不能用admin和guest登录，不信试试看)" id="userid" name="userid"></s:textfield>
<s:password label="userpwd(长度大于6，小于20)" id="userpwd" name="userpwd"></s:password>
<s:submit ></s:submit>
</s:form>
<hr />
<s:debug></s:debug>
</body>
</html>