﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员注册页面</title>
<link href="css/cs.css" rel="stylesheet" type="text/css" />
<script src="js/common.js"></script>
<script src="untitled.js"></script>
</head>
<!-- onsubmit="return error_msg()"-->															
<body class="backgroud">
<h1 id="h1">会员注册</h1>
<form id="form1" name="form1" method="post" action="index.jsp"  onsubmit="return system_error()">
  <table width="100%" border="0" align="center" class="tablestyle">
    <tr>
      <td colspan="2" class="red" id="error_msg"><br>
</td>
    </tr>
    <tr>
      <td width="48%" class="tableside">会员ID:</td> <!--会员ID必须为字母数字8位-->
      <td width="52%" class="left"><label>
        <input name="userid" type="text" class="left" id="userid"  onblur="validuserID()" onchange="changeID()"/>
      </label>
      <span id="useridError">
      </span>
      </td>
    </tr>
    <tr>
      <td class="tableside">会员名:</td>    <!--会员名必须为字符1-20位-->
      <td class="left"><label>
        <input name="uname" type="text" class="left" id="username" onblur="validusername()" onchange="changeName()"/>
      </label><span id="usernameError"></span></td>
    </tr>
    <tr>
      <td class="tableside">设置密码:</td> <!--密码必须为字母数字6位-->
      <td class="left"><label>
        <input name="usetpwd" type="password" class="left" id="userpassword" onblur="validuserpassword()" onchange="changePWD()"/>
      </label><span id="userpwdError"></span></td>
    </tr>
    <tr>
      <td class="tableside">确认密码:</td> <!--确认密码必须为字母数字6位-->
      <td class="left"><label>
        <input name="upwd" type="password" class="left" id="password" onblur="validpassword()" onchange="isChangePWD()"/>
      </label><span id="pwdError"></span></td>
    </tr>
    <tr>
      <td class="tableside">邮箱:</td>  <!--邮箱为字母数字0-30位,可以为空-->
      <td class="left"><label>
        <input name="umail" type="text" class="left" id="umail"/>
      </label></td>
    </tr>
    <tr>
      <td class="tableside"><label>
        <input type="submit" name="register" id="register" value="会员注册"/>
      </label></br></br></td>
      <td><label>
        <input type="button" name="back" id="back" value="返回" onclick="gotoLinkIndex()" />
      </label></br></br></td>
    </tr>
  </table>
</form>
</body>
</html>