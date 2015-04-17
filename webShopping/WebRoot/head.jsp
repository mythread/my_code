<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<table width="100%">
	<tr>
		<td>
			<font size="6" face="楷体_GB2312"><b>网上商城</b> </font>
		</td>
	</tr>
	<tr>
		<td>
			&nbsp;
		</td>
	</tr>
	<tr>
		<td align="right">
			<tt><a href="${param.path }index.jsp">首页</a> </tt>
			<tt><a href="javascript:forwardlogin()">登录</a> </tt>
			<tt><a href="${param.path }register.jsp">注册</a> </tt>
			<tt><a href="${param.path }">搜索</a> </tt>
			<logic:present name="username" scope="session">
				<tt><a href="${param.path }show/buy/trolley.jsp"
					target="_blank">我的购物车</a> </tt>
				<tt><a href="${param.path }userinfo/index.jsp">用户管理</a> </tt>
			</logic:present>
		</td>
	</tr>
</table>
