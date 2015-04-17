<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%="http://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI()%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员查询页面</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>

<body>
<s:form action="search" method="post" theme="simple">
<div id="page_title">会员查询</div>
<div class="style4">
<span id="error_msg">&nbsp;</span>

<span class="right"><a href="<s:url action="user_edit"/>">会员信息修改</a></span>
<div class="form_middle" >
      
<table width="224" border="0" align="center">     
  <tr>
    <td class="form_col_right">会员ID：</td>
    <td>
    <s:textfield id="userid" name="userid" cssClass="input" />
    </td>
  </tr>
  <tr>
    <td class="form_col_right">会员名：</td>
    <td>
    <s:textfield id="username" name="username" cssClass="input" />
    </td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">
      <input type="submit" name="submit" id="submit" value="搜索">
    </div></td>
    </tr>
</table>    
    
  </div>
<s:if test="result">
<div id="search_result">
  		
  <table width="80%" border="0" align="center">
  <tr>
    <th scope="col">编号</th>
    <th scope="col">会员ID</th>
    <th scope="col">会员名</th>
    <th scope="col">邮箱</th>
    <th scope="col">状态</th>
  </tr>

<s:iterator value="result" id="row" status="i">

  <tr class="
	<s:if test="#i.index % 2 == 0">odd</s:if>
	<s:else>even</s:else>
  ">
  
  	
    <td><s:property value="#i.index + 1"/></td>
    <td><s:property value="#row.USER_ID"/></td>
    <td><s:property value="#row.USER_NAME"/></td>
    <td><s:property value="#row.USER_MAILADDRESS"/></td>
    <td><s:property value="#row.STATUS_NAME"/></td>
  </tr>

</s:iterator>

  </table>
  </div>
</s:if>
  
  
  <!-- 
  <div id="search_result">
  		
  <table width="80%" border="0" align="center">
  <tr>
    <th scope="col">编号</th>
    <th scope="col">会员ID</th>
    <th scope="col">会员名</th>
    <th scope="col">邮箱</th>
    <th scope="col">状态</th>
  </tr>
  <tr class="odd">
    <td>1</td>
    <td>zhangsan</td>
    <td>张三</td>
    <td>zhangsan@123.com</td>
    <td>online</td>
  </tr>
  <tr class="even">
    <td>2</td>
    <td>lisi</td>
    <td>李四</td>
    <td>lisi@123.com</td>
    <td>offline</td>
  </tr>
  </table>
  </div>
   -->
  <div align="center">
 
    <input type="button" name="search" id="search" value="退出" onClick="window.location='<s:url action="logout"/>'">
  </div>
</div>
</s:form>
</body>
</html>
