<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%="http://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI()%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
@import url("../css/cs.css");
-->
</style>
</head>

<body class="backgroud">
<h1>亲爱的<s:property value="username"/>,欢迎你! </h1>
<form id="form1" name="form1" method="post" action="search.jsp">
  <table width="100%" border="0" align="center" class="tablestyle">
    <tr>
      <td>查询会员信息!</td>
    </tr>
    <tr>
      <td><label>
        <input type="submit" name="check" id="enter" value="查询" />
      </label></td>
    </tr>
  </table>
</form>
<br>
</body>
</html>
