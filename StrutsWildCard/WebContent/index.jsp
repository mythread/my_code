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
<a href="<s:url action="User_add"/>">StrutsWildCard/User_add.action</a><br />
<a href="<s:url action="User_del"/>">StrutsWildCard/User_del.action</a><br />
<a href="<s:url action="User_update"/>">StrutsWildCard/User_update.action</a><br />
<a href="<s:url action="User_search"/>">StrutsWildCard/User_search.action</a><br />
</body>
</html>