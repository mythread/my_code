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
<br> ���Ĺ��ﳵ����������Ʒ:
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
ѡ��һ���ִ�м�����Ƴ�����:
<br>
Add Item:

<SELECT NAME="item" size="9">
<OPTION>ѩ���������κ�
<OPTION>ʥ��ѩ��+ʥ�������ǹ���
<OPTION>ë�����
<OPTION>ʥ�������������ˮ����һ��
<OPTION>����ʥ������U�̣�2G������һ��
<OPTION>�����ƽ�װ��
<OPTION>ħ������㿨
<OPTION>������
<OPTION>DNFǿ��װ��
</SELECT>


<br> <br>
<INPUT TYPE="submit" name="submit" value="add">
<INPUT TYPE="submit" name="submit" value="remove">

</form>
</html>
