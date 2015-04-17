<%@ page contentType="text/html;charset=gb2312" language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<html>
<%request.setCharacterEncoding("GB2312") ;
response.setCharacterEncoding("GB2312");
 %>
<jsp:useBean id="cart" scope="session" class="sessions.DummyCart" />

<jsp:setProperty name="cart" property="*" />
<%
	cart.processRequest();
%>
<%!
 String encode(String item)
{String s="";
if(item!=null)
{
try{
s=new String(item.getBytes("ISO-8859-1"),"GB2312");
}catch(UnsupportedEncodingException e)
{}
return s;
}
return null;
}
 %>

<FONT size = 5 COLOR="#CC0000">
<br> 您的购物车中有如下商品:
<ol>
<% 
	String[] items = cart.getItems();
	for (int i=0; i<items.length; i++) {
%>
<li> <% out.print(encode(items[i])); %> 
<%
	}
%>
</ol>

</FONT>

<hr>
<form type="get" action="carts.jsp">
<BR>
选择一项，可执行加入或移除操作:
<br>
Add Item:

<SELECT NAME="item" size="9">
<OPTION>雪人音乐首饰盒
<OPTION>圣诞雪人+圣诞老人糖果盒
<OPTION>毛绒玩具
<OPTION>圣诞老人相框音乐水晶球一个
<OPTION>迷你圣诞老人U盘（2G）项链一条
<OPTION>剑侠黄金装备
<OPTION>魔兽世界点卡
<OPTION>劲舞团
<OPTION>DNF强化装备
</SELECT>


<br> <br>
<INPUT TYPE="submit" name="submit" value="add">
<INPUT TYPE="submit" name="submit" value="remove">

</form>
</html>
