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
<s:form action="dynamicResult">
<input type="radio" name="location" value="1.jsp">1.jsp <br>
<input type="radio" name="location" value="2.jsp">2.jsp <br>
<input type="radio" name="location" value="3.jsp">3.jsp <br>
<input type="radio" name="location" value="4.jsp">4.jsp <br>
<s:submit></s:submit>
</s:form>
</body>
</html>