<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>beaneg2.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <jsp:useBean id="entry" class="etp.bean.SaleEntity"/>
    <jsp:setProperty name="entry" property="itemID" value='<%=request.getParameter("itemID") %>'/>
  	<%
  	int numItemsOrdered=1;
  	try{
  	numItemsOrdered=Integer.parseInt(request.getParameter("numItems"));
  	}catch(NumberFormatException e){ e.printStackTrace();System.out.println("格式转换异常");}
  	 %>
  	 <jsp:setProperty name="entry" property="numItems" value="<%=numItemsOrdered %>"/>
  	 <%
  	 double discountCode=1.0;
  	 try{
  	 discountCode=Double.parseDouble(request.getParameter("discountCode"));
  	 }catch(NumberFormatException e){ e.printStackTrace(); System.out.println("格式转换异常");}
  	  %>
  	<jsp:setProperty name="entry" property="discountCode" value="<%=discountCode %>"/>
  	<table border="1">
  	<tr align="center" style="color: blue">
  	<td>订单号</td><td>单价</td><td>数量</td><td>总价</td>
  	</tr>
  	<tr align="center">
  		<td>
  		<jsp:getProperty name="entry" property="itemID"/>
  		</td>
  		<td>
  		￥<jsp:getProperty name="entry" property="itemCost"/>
  		</td>
  		<td>
  		<jsp:getProperty name="entry" property="numItems"/>
  		</td>
  		<td>
  		￥<jsp:getProperty name="entry" property="totalCost"/>
  		</td>
  	</tr>
  	</table>
  </body>
</html>
