<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<logic:present name="newProduct" scope="request">
	<table width="100%">
		<tr>
			<td>
				&nbsp;
			</td>
			<td>
				<b><font color="#666666">��Ʒ</font></b>
			</td>
			<td>
				<b><font color="#666666">����</font></b>
			</td>
			<td>
				<b><font color="#666666">�ؼ�</font></b>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				&nbsp;
			</td>
		</tr>
		<logic:iterate id="np" name="newProduct" scope="request">
			<tr>
				<td rowspan="2" width="100" height="60">
					<img src="${ np.picture }" width="60" height="60">
				</td>
				<td width="200">
					<a href="show/product.jsp?pid=${ np.pid }">${np.name }</a>
				</td>
				<td width="200">
					${np.unitprice }��
				</td>
				<td width="200">
					${np.discount }��
				</td>
			</tr>
			<tr>
				<td colspan="3">
					${np.descr }
				</td>
			</tr>
			<tr>
				<td colspan="4">
					&nbsp;
				</td>
			</tr>

		</logic:iterate>
	</table>
</logic:present>

