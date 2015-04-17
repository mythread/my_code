<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%="http://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI()%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员查询页面</title>
<link href="../css/cs.css" rel="stylesheet" type="text/css" />
<script src="../js/common.js"></script>
<script src="../js/untitled.js"></script>
</head>
<body class="backgroud">
<h1 id="h1">会员查询</h1>
<s:form id="form1" name="form1" method="post" action="system_error.jsp" onsubmit="return TOinfo()" theme="simple">
  <table width="100%" border="2">
    <tr>
      <td><table width="100%" border="0">
    <tr>
      <td><table width="100%" border="0" class="tabletool">
        <tr>
          <td colspan="2" class="red" id="error_msg"><br></td>
          <td width="45%" class="purple"><a href="update.jsp">会员信息修改</a></td>
        </tr>
        <tr>
          <td width="21%">会员ID:
            <label>
              <s:textfield name="userid" id="userid" size="10" onblur="validuserID()" onchange="changeID()" />
            </label></td>
          <td width="34%">会员名:
            <label>
              <s:textfield name="username" id="username"  onblur="validusername()" onchange="changeName()"/>
            </label></td>
          <td class="tabletail"><label>
            <input type="submit" name="search" id="enter" value="检索" />
          </label></td>
        </tr>
        <tr>
          <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="useridError"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="usernameError"></span></td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td><table width="100%" border="3">
        <tr class="tablefont">
          <td>编号</td> <!--编号必须为数字3位-->
          <td>会员ID</td> <!--会员ID必须为字母数字8位-->
          <td>会员名</td> <!--会员名必须为字母数字1-20位-->
          <td>邮箱</td> <!--邮箱为字母数字0-30位,可以位为空-->
          <td>状态</td> <!--状态必须为字母1-20位-->
        </tr>
        <tr class="yellow">
          <td>1</td>
          <td>Rolls-Royce</td>
          <td>劳伦斯</td>
          <td>Rolls-Royce@ibm.cn.com</td>
          <td>online</td>
        </tr>
        <tr class="jacinth">
          <td id="NO"></td>
          <td id="myid">&nbsp;</td>
          <td id="myname">&nbsp;</td>
          <td id="myemail">&nbsp;</td>
          <td id="mystate">&nbsp;</td>
        </tr>
        <tr class="yellow">
          <td id="NO2"></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr class="jacinth">
          <td class="jacinth" id="NO3"></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td colspan="5"><br><br><br><br><br><br><br><br><br><br><br><br><br>&nbsp;</td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td class="tabletail"><label>
        <input type="button" name="exit" id="enter" value="退出" onclick="gotoLinkIndex()"/><br><br>
      </label></td>
    </tr>
  </table></td>
    </tr>
  </table>
  
</s:form>
</body>
</html>