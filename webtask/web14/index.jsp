<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆页面</title>
<link href="css/cs.css" rel="stylesheet" type="text/css" />
<script src="js/common.js"></script>
<script src="untitled.js"></script>
</head>
<!-- onsubmit="return error_msg()"-->
<body class="backgroud">
<h1 id="h1">会员登录</h1>
<form id="form1" name="form1" method="post" action="welcome.jsp" onsubmit="return systemlogin_error()">
  <table width="100%" border="2" align="center" class="tablestyle">
    <tr>
      <td class="red" id="error_msg"><br></td>
    </tr>
    <tr>
      <td><table width="100%" border="0">
        <tr>
          <td colspan="2">&nbsp;<br><br></td>
          </tr>
        <tr>
          <td width="48%" class="tableside">会员ID:</td>
          <td width="52%"><label>
            <input name="userid" type="text" class="left" id="userid" onblur="validuserID()" onchange="changeID()" />
          </label><span id="useridError"></span></td>
        </tr>
        <tr>
          <td class="tableside">密码:</td>
          <td><label>
            <input name="password" type="password" class="left" id="userpassword" onblur="validuserpassword()" onchange="changePWD()"/>
          </label><span id="userpwdError"></span></td>
        </tr>
        <tr>
          <td class="tableside"><label>
            <input type="submit" name="login" id="enter" value="登录"/>
          </label></td>
          <td class="tabletail"><label>
            <input name="set" type="reset" class="tabletail" id="setback" value="重置" />
          </label></td>
        </tr>
        <tr>
          <td colspan="2">&nbsp;<br><br><br></td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td><a href="register.jsp">会员注册<br><br></a></td>
    </tr>
  </table>
</form>
</body>
</html>
