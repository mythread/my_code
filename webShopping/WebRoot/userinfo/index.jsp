<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
	<head>
		<title>�û���������</title>
	</head>
	<style type="text/css">
</style>
	<body>
		<logic:notPresent name="edit" scope="request">
			<jsp:forward page="/userinfo/info.do">
				<jsp:param name="method" value="edit" />
			</jsp:forward>
		</logic:notPresent>

		<logic:present name="editsuc" scope="request">
			<script type="text/javascript">
				window.alert("��ϲ������Ϣ���³ɹ� : )");
			</script>
		</logic:present>
		<logic:present name="dopasssuc" scope="request">
			<script type="text/javascript">
				window.alert("��ϲ����������³ɹ� : )");
			</script>
		</logic:present>
		<center>
			<table width="70%">
				<tr>
					<td>
						<jsp:include page="head.jsp" /><br>
						<logic:present name="edit" scope="request">
							<html:form action="userinfo/info.do" method="post">
								<fieldset>
									<legend>
										�û���Ϣ
									</legend>
									<table align="center" width="70%">
										<tr>
											<td>
												&nbsp;
											</td>
										</tr>
										<tr>
											<td>
												ͨ��֤�û�����
											</td>
											<td>
												${ sessionScope.username }
											</td>
										</tr>

										<tr>
											<td>
												&nbsp;
											</td>
										</tr>


										<tr>
											<td>
												�������䣺
											</td>
											<td>
												<html:text property="email"></html:text>
											</td>

										</tr>
										<tr>
											<td>
												&nbsp;
											</td>
										</tr>
										<tr>
											<td>
												��ϵ�绰��
											</td>
											<td>
												<html:text property="phone"></html:text>
											</td>

										</tr>
										<tr>
											<td>
												&nbsp;
											</td>
										</tr>
										<tr>
											<td>
												��ϵ��ַ��
											</td>
											<td>
												<html:text property="address"></html:text>
											</td>

										</tr>
										<tr>
											<td>
												&nbsp;
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center">
												<input type="hidden" name="method" value="doedit">
												<html:submit value="  �� �� �� Ϣ  " />
											</td>
										</tr>
									</table>
								</fieldset>
							</html:form>
						</logic:present>
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>

