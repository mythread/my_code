<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getRequestURL() %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>系统登录</title>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../../js/common.js"></script>
<script language="javascript">
function validate() {
	var userid = trim(document.getElementById("userid").value);
	var password = trim(document.getElementById("password").value);
	
	var error_msg = "";
	var result = true;
	
	if (userid.length < 3) {
		error_msg = addALine(error_msg, "会员ID至少为3位长度");
		result = false;
	}
	if (!isLetterOrDigital(userid)) {
		error_msg = addALine(error_msg, "会员ID只能有英文和数字");
		result = false;
	}
	if (password.length != 6) {
		error_msg = addALine(error_msg, "密码必须为6位长度");
		result = false;	
	}
	
	if(!result) {
		var error_msg_obj = document.getElementById("error_msg");
		error_msg_obj.innerHTML = error_msg;
	}
	return result;	
}
</script>
</head>
<body>



<form action="<%=request.getContextPath() %>/login" method="post" onsubmit="return validate()">
<div id="page_title">
会员登录</div>
<div class="style4">

	
    <div class="form_middle" >
<table width="224" border="0" align="center">
  <tr>
  	<td colspan="2">
    <div id="error_msg"></div>
    </td>
  </tr>      
  <tr>
    <td class="form_col_right">会员ID：
    </td>
    <td><input type="text" class="input" name="userid" id="userid"></td>
  </tr>
  <tr>
    <td class="form_col_right">密码：</td>
    <td><input type="password" class="input" name="password" id="password"></td>
  </tr>
  <tr>
    <td><input type="submit" name="submit" id="submit" value="登录" ></td>
    <td><input type="reset" name="reset" id="reset" value="重置"></td>
  </tr>
</table>    
    
    </div>
    
    <div align="center"><a href="<%=request.getContextPath() %>/UserRegIni">会员注册</a></div>
</div>
</form>
</body>
</html>
