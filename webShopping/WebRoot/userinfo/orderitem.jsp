<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>我的订单项</title>
	</head>

	<body>
		<logic:notPresent parameter="soid" scope="request">
			<script type="text/javascript">
				window.location.href="salesorder.jsp";
			</script>
		</logic:notPresent>
		<logic:notPresent name="orderItem" scope="request">
			<jsp:forward page="/userinfo/orderItem.do">
				<jsp:param name="soid" value="${param.soid}"/>
			</jsp:forward>
		</logic:notPresent>
		<center>
			<table width="70%">
				<tr>
					<td>
						<jsp:include page="head.jsp" /><br>
						<fieldset>
							<legend>
								我的订单项
							</legend>
							<table align="center" width="70%">
								<tr>
									<td>
										<b><font color="#666666">商品名称</font> </b>
									</td>
									<td align="center">
										<b><font color="#666666">价格￥</font> </b>
									</td>
									<td>
										<b><font color="#666666">购买数量</font> </b>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										&nbsp;
									</td>
								</tr>
								<logic:iterate id="o" name="orderItem" scope="request">
									<tr>
										<td>
											${o.name }
										</td>
										<td>
											${o.unitprice }
										</td>
										<td>
											${o.count }
										</td>
									</tr>
								</logic:iterate>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>
