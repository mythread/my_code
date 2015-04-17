<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<logic:present name="products" scope="request">
	<table width="100%">
		<tr>
			<td>
				&nbsp;
			</td>
			<td> 
				<b><font color="#666666">商品</font> </b>
			</td>
			<td>
				<b><font color="#666666">单价</font> </b>
			</td>
			<td>
				<b><font color="#666666">特价</font> </b>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				&nbsp;
			</td>
		</tr>
		<logic:iterate id="p" name="products" scope="request">
			<tr>
				<td rowspan="2" width="100" height="60">
					<img src="../${ p.picture }" width="60" height="60">
				</td>
				<td width="200">
					<a href="product.jsp?pid=${ p.pid }">${p.name }</a>
				</td>
				<td width="200">
					${p.unitprice }￥
				</td>
				<td width="200">
					${p.discount }￥
				</td>
			</tr>
			<tr>
				<td colspan="3">
					${p.descr }
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

