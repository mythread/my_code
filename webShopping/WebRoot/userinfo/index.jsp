<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
	<head>
		<title>用户管理中心</title>
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
				window.alert("恭喜您，信息更新成功 : )");
			</script>
		</logic:present>
		<logic:present name="dopasssuc" scope="request">
			<script type="text/javascript">
				window.alert("恭喜您，密码更新成功 : )");
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
										用户信息
									</legend>
									<table align="center" width="70%">
										<tr>
											<td>
												&nbsp;
											</td>
										</tr>
										<tr>
											<td>
												通行证用户名：
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
												保密邮箱：
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
												联系电话：
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
												联系地址：
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
												<html:submit value="  更 新 信 息  " />
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

