<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%="http://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI()%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册页面</title>
<link href="../css/cs.css" rel="stylesheet" type="text/css" />
<script src="../js/common.js"></script>
<script src="../js/untitled.js"></script>
</head>
<body class="backgroud">
<h1 id="h1">会员修改</h1>
<s:form action="index.jsp" method="post" name="form1" id="form1" onsubmit="return system_error()" theme="simple">
  <table width="100%" border="0" align="center" class="tablestyle" >
    <tr>
      <td colspan="2" class="red" id="error_msg"><br></td>
    </tr>
    <tr>
      <td width="50%" class="tableside">会员ID:</td>
      <td width="50%" class="red" id="td"><label>
        <s:textfield name="userid" cssClass="left" id="userid" onblur="validuserID()" onchange="changeID()"/>
      </label><span id="useridError"></span></td>
    </tr>
    <tr>
      <td class="tableside">会员名:</td>
      <td class="red" id="td"><label>
        <s:textfield name="username" cssClass="left" id="username" onblur="validusername()" onchange="changeName()"/>
      </label><span id="usernameError"></span></td>
    </tr>
    <tr>
      <td class="tableside">设置密码:</td>
      <td class="red" id="td"><label>
        <s:password name="setpwd" cssClass="left" id="userpassword" onblur="validuserpassword()" onchange="changePWD()"/>
      </label><span id="userpwdError"></span></td>
    </tr>
    <tr>
      <td class="tableside">确认密码:</td>
      <td class="red" id="td">
        <label>
          <s:password  name="pwd"  cssClass="left" id="password" onblur="validpassword()" onchange="isChangePWD()"/>
      </label><span id="pwdError"></span></td>
    </tr>
    <tr>
      <td class="tableside">邮箱:</td>
      <td class="red" id="td"><label>
        <s:textfield name="email" cssClass="left" id="email" />
      </label></td>
    </tr>
    <tr>
      <td class="tableside"><label>
        <input type="submit" name="button1" id="register" value="会员修改" />
      </label></td>
      <td class="tabletail"><input type="button" name="button2" id="back" value="返回"  onclick="gotoLinkSearch()"/></td>
    </tr>
  </table>
</s:form>
</body>
</html>
