<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>form.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
 function validate_required(field,alerttxt)
{
with (field)
  {
  if (value==null||value=="")
    {alert(alerttxt);return false}
  else {return true}
  }
}

function validate_num(field,alerttxt)
{
 var myReg = /[1-9]\d*/;
  with (field)
{
  if(!myReg.test(value)) 
  {
  alert(alerttxt);
  return false
  }
  else
  return true;
}
}

function validate_form(thisform)
{
with (thisform)
{
if (validate_required(itemID,"请填写订单号")==false)
    {itemID.focus();return false}
if (validate_required(numItems,"请填写一个正整数")==false)
    {numItems.focus();return false}
if (validate_num(numItems,"请填写正整数!")==false)
  {numItems.focus();
  return false}
}
}
</script>
</head>
  
  <body>
    <form name="test" action="beaneg4.jsp" onsubmit="return validate_form(this);" method="post">
    订单号:<input type="text" name="itemID"><br>
  数量:<input type="text" name="numItems"><br>
 折扣:<input type="text" name="discountCode"><br>
    <input type="submit" value="查看价格">
    </form>
  </body>
</html>
