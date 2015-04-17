<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base
	href="<%="http://" + request.getServerName() + ":"
					+ request.getServerPort() + request.getRequestURI()%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员注册页面</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../../../js/common.js"></script>
<script language="javascript">
function validate() {
	var useridIni = "<s:property value="userid"/>";
	
	var userid = trim(document.getElementById("userid").value);
	var username = trim(document.getElementById("username").value);
	var password = trim(document.getElementById("password").value);
	var confirmpassword = trim(document.getElementById("confirmpassword").value);
	var email = trim(document.getElementById("email").value);
	
	var error_msg = "";
	var result = true;
	
	if (userid.length != 8) {
		error_msg = addALine(error_msg, "会员ID必须为8位长度");
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
	if (email.length > 20 || email.length < 1) {
		error_msg = addALine(error_msg, "邮箱地址必须为1到20个字符");
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
<s:form action="userreg" onsubmit="return validate()" method="post"
	theme="simple">
	<div id="page_title">会员注册</div>
	<div class="style4">


	<div class="form_middle">
	<table width="224" border="0" align="center">
		<tr>
			<td colspan="2">
			<div id="error_msg"><s:if test="!actionErrors.isEmpty()">
				<s:iterator value="actionErrors" id="actionError">
					<s:property value="#actionError" />
					<br />
					<s:hidden name="actionError" />
				</s:iterator>
			</s:if></div>
			</td>
		</tr>
		<tr>
			<td class="form_col_right">会员ID：</td>
			<td><s:textfield name="userid" id="userid" cssClass="input" /></td>
		</tr>
		<tr>
			<td class="form_col_right">会员名：</td>
			<td><s:textfield name="username" id="username" cssClass="input" /></td>
		</tr>
		<tr>
			<td class="form_col_right">设置密码：</td>
			<td><s:password name="password" id="password" cssClass="input" /></td>
		</tr>
		<tr>
			<td class="form_col_right">确认密码：</td>
			<td><s:password name="confirmpassword" id="confirmpassword"
				cssClass="input" /></td>
		</tr>
		<tr>
			<td class="form_col_right">邮箱：</td>
			<td><s:textfield name="email" id="email" cssClass="input" /></td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" id="submit" value="注册"></td>
			<td><input type="reset" name="reset" id="reset" value="重置"></td>
		</tr>
	</table>
	</div>
	</div>
</s:form>
</body>
</html>
