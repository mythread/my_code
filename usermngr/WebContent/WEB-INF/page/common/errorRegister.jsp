<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getRequestURL() %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册内容出错啦</title>
<link href="../../../css/css.css" rel="stylesheet" type="text/css">
</head>
<!-- sjfodsjfdsf -->
<%-- fsdiofjdosa --%>
<body>
<form action="../../../page/common/user_search.html" onSubmit="return validate();">
<div id="page_title">注册错误</div>
<div class="style4">

	
    <div class="form_middle" >
<table width="224" border="0" align="center">
  <tr>
  	<td>
    <div id="error_msg">
      <div align="center">密码发生错误<br>
        请确保两次输入的密码一致!</div>
    </div>
    </td>
  </tr>
  <tr>
    <td><div align="center">
      <input type="button" name="submit" id="submit" value="返回" onClick="history.back()">
    </div></td>
    </tr>
</table>    
    
    </div>
</div>
</form>
</body>
</html>
