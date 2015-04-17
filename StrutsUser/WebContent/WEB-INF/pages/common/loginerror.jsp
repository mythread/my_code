<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%="http://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI()%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户名或密码错误</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>
<!-- sjfodsjfdsf -->
<%-- fsdiofjdosa --%>
<body>
<form action="../../../page/common/user_search.html" onSubmit="return validate();">
<div id="page_title">用户名或密码错误</div>
<div class="style4">

	
    <div class="form_middle" >
<table width="224" border="0" align="center">
  <tr>
  	<td>
    <div id="error_msg">
      <div align="center">用户名或密码错误<br>
        请返回登录页面</div>
    </div>
    </td>
  </tr>
  <tr>
    <td><div align="center">
      <input type="button" name="submit" id="submit" value="返回登录" onClick="window.location='<s:url action="login"/>'">
    </div></td>
    </tr>
</table>    
    
    </div>
</div>
</form>
</body>
</html>
