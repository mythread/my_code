<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>�ҵĶ���</title>
	</head>

	<body>
		<logic:notPresent name="salesOrders" scope="request">
			<jsp:forward page="/show/buy/saleSorder.do">
				<jsp:param name="method" value="show"/>
			</jsp:forward>
		</logic:notPresent>
		<center>
			<table width="70%">
				<tr>
					<td>
						<jsp:include page="head.jsp" /><br>
						<fieldset>
							<legend>
								�ҵĶ���
							</legend>
							<table align="center" width="90%">
								<tr>
									<td>

										<b><font color="#666666">�ͻ���ַ</font>
										</b>

									</td>
									<td>
										<b><font color="#666666">��ϵ�绰</font>
										</b>
									</td>
									<td>
										<b><font color="#666666">����ʱ��</font>
										</b>
									</td>
									<td>
										<b><font color="#666666">�Ƿ���</font>
										</b>
									</td>
									<td>
										<b><font color="#666666">�鿴������</font>
										</b>
									</td>
								</tr>
								<tr>
									<td colspan="5">
										&nbsp;
									</td>
								</tr>
								<logic:iterate id="s" name="salesOrders" scope="request">
									<tr>
										<td>
											${s.address }
										</td>
										<td>
											${s.phone }	
										</td>
										<td>
											${s.buydate }	
										</td>
										<td>
											<bean:define id="status" value="${s.status}" />
											<logic:equal name="status" value="1">û�д���</logic:equal>
											<logic:equal name="status" value="0">�Ѿ�����</logic:equal>
										</td>
										<td>
											<a href="orderitem.jsp?soid=${s.soid }">�鿴</a>	
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
