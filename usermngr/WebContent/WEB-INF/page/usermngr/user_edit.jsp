<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getRequestURL() %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员修改页面</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../../../js/common.js"></script>
<script language="javascript">
function validate() {
	var userid = trim(document.getElementById("userid").value);
	var username = trim(document.getElementById("username").value);
	var password = trim(document.getElementById("password").value);
	var confirmpassword = trim(document.getElementById("confirmpassword").value);
	var email = trim(document.getElementById("email").value);
	
	var error_msg = "";
	var result = true;
	
	if (userid.length <3 ) {
		error_msg = addALine(error_msg, "会员ID至少为3位长度");
		result = false;
	}
	if (!isLetterOrDigital(userid)) {
		error_msg = addALine(error_msg, "会员ID只能有英文和数字");
		result = false;
	}
	if (username < 2 || username > 20) {
		error_msg = addALine(error_msg, "用户名长度必须为2到20位");
		result = false;
	}
	if (!isFullAngle(username)) {
		error_msg = addALine(error_msg, "用户名必须为汉字");
		result = false;
	}
	if (password.length != 6) {
		error_msg = addALine(error_msg, "密码必须为6位长度");
		result = false;	
	}
	if (confirmpassword != password) {
		error_msg = addALine(error_msg, "两次输入密码不一致");
		result = false;	
	}
	if (email.length > 20 || email.length < 0) {
		error_msg = addALine(error_msg, "邮箱地址为0到20个字符");
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
<form name="form1" method="post" action="<%=request.getContextPath() %>/UserEdit" onSubmit="return validate()">
<div id="page_title">会员修改</div>
<div class="style4">

	
    <div class="form_middle" >
<table width="224" border="0" align="center">
  <tr>
  	<td colspan="2">
    <div id="error_msg"></div>
    </td>
  </tr>      
  <tr>
    <td class="form_col_right">会员ID：</td>
    <td><input type="text" class="input" name="userid" id="userid" value="${userid }"></td>
  </tr>
  <tr>
    <td class="form_col_right">会员名：</td>
    <td><input type="text" class="input" name="username" id="username" value="${username }"></td>
  </tr>
  <tr>
    <td class="form_col_right">设置密码：</td>
    <td><input name="password" type="password" class="input" id="password"></td>
  </tr>
  <tr>
    <td class="form_col_right">确认密码：</td>
    <td><input name="confirmpassword" type="password" class="input" id="confirmpassword"></td>
  </tr>
  <tr>
    <td class="form_col_right">邮箱：</td>
    <td><input name="email" type="text" class="input" id="email" value="<%=request.getAttribute("mail") %>"></td>
  </tr>
  <tr>
    <td><input type="submit" name="submit" id="submit" value="修改"></td>
    <td><input type="button" name="button" id="button" value="返回" onClick="history.back()"></td>
  </tr>
</table>    
    
    </div>
</div>
</form>
</body>
</html>
