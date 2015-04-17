<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>core</title>
</head>
<body>
    <H2>数字格式示例</H2>
    将 <B>123.4</B> 格式化为:
    <fmt:formatNumber value="123.4" type="number"  
    minFractionDigits="3" /><BR>
    <HR>
    <H2>货币格式示例</H2>
    <c:set var="salary" value="125000" />
    工资: <c:out value="${salary}"/><BR>
    <fmt:setLocale value="en_GB"/>
    用本机的 <B>en_GB</B> 将工资格式化为:
    <fmt:formatNumber type="currency" value="${salary}"   
    /><BR>
    <fmt:setLocale value="zh_CN"/>
    用本机的 <B>zh_CN</B> 将工资格式化为:
    <fmt:formatNumber type="currency" value="${salary}"   
    /><BR>
    <HR>
</body>

</html>
