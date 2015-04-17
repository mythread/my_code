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
在Struts2中得到JSP隐式对象方法有很多，在这里，我们只介绍两种方式，通过IoC得到request, session, application对象<br />

<a href="<s:url action="get1"/>">get1.action</a><br />
<a href="<s:url action="get2"/>">get2.action</a><br />
</body>
</html>