<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<table width="100%">
	<tr>
		<td>
			<font size="6" face="����_GB2312"><b>�����̳�</b> </font>
		</td>
	</tr>
	<tr>
		<td>
			&nbsp;
		</td>
	</tr>
	<tr>
		<td align="right">
			<tt><a href="${param.path }index.jsp">��ҳ</a> </tt>
			<tt><a href="javascript:forwardlogin()">��¼</a> </tt>
			<tt><a href="${param.path }register.jsp">ע��</a> </tt>
			<tt><a href="${param.path }">����</a> </tt>
			<logic:present name="username" scope="session">
				<tt><a href="${param.path }show/buy/trolley.jsp"
					target="_blank">�ҵĹ��ﳵ</a> </tt>
				<tt><a href="${param.path }userinfo/index.jsp">�û�����</a> </tt>
			</logic:present>
		</td>
	</tr>
</table>
