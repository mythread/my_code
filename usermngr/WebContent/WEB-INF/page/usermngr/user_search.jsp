<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<html>
<head>
<base href="<%=request.getRequestURL() %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会员查询页面</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>

<body>
<form action="<%=request.getContextPath() %>/UserSearch" method="post">
<div class="left">${s_username } 欢迎登录查询页面! </div><div id="page_title">会员信息查询</div>
<div class="style4">
<span id="error_msg">&nbsp;</span>
<span class="right"><a href="<%=request.getContextPath() %>/usereditIni">会员信息修改</a></span>
<div class="form_middle" >
      
<table width="224" border="0" align="center">     
  <tr>
    <td class="form_col_right">会员ID：</td>
    <td><input type="text" class="input" name="userid" id="userid" value="${s_userid }"></td>
  </tr>
  <tr>
    <td class="form_col_right">会员名：</td>
    <td><input type="text" class="input" name="username" id="username" value="${s_username }"></td>
  </tr>
  <tr>
    <td colspan="2"><div align="center">
      <input type="submit" name="submit" id="submit" value="搜索">
    </div></td>
    </tr>
</table>    
    
  </div>
  
  <%
  List<HashMap<Object, Object>> list = (List<HashMap<Object, Object>>)request.getAttribute("result");
  
if (list != null && list.size() > 0) {  
%>


<div id="search_result">
  		
  <table width="80%" border="0" align="center">
  <tr>
    <th scope="col">编号</th>
    <th scope="col">会员ID</th>
    <th scope="col">会员名</th>
    <th scope="col">邮箱</th>
    <th scope="col">状态</th>
  </tr>


<%
for(int i = 0; i < list.size(); i++) {
%>



  <tr class="
  <%
	if (i % 2 == 0) {
		out.print("odd");		
	} else {
		out.print("even");
	}
  %>
  ">
    <td><%=i+1 %></td>
    <td><%=list.get(i).get("USER_ID")  %></td>
    <td><%=list.get(i).get("USER_NAME") %></td>
    <td><%=list.get(i).get("USER_MAILADDRESS") %></td>
    <td><%=list.get(i).get("STATUS_NAME") %></td>
  </tr>


<%
}
%>

  </table>
  </div>

<%
}
%>

  <div align="center">
 
    <input type="button" name="search" id="search" value="退出" onClick="window.location='<%=request.getContextPath() %>/Logout'">
  </div>
</div>
</form>
</body>
</html>
