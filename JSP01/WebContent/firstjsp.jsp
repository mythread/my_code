<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>1st JSP</title>
</head>
<body>
<h1>FirstJSP</h1>
<hr>
<%=request.getRealPath("1") %>

<%SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd"); %>
<%=sf.format(new Date()) %>
</body>
</html>