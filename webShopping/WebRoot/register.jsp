<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>

<html>
	<head>
		<title>注册通行证</title>
	</head>
	<style type="text/css">
</style>
	<body>
		<center>
			<table width="90%">
				<tr>
					<td>
						<jsp:include page="head.jsp" />
					</td>
				</tr>
				<tr>
					<td>
						<hr> 
						<br> 
					</td>
				</tr>
				<tr>
					<td align="center">


						<table width="90%">
							<tr>
								<td>
									<html:form action="/register.do" method="post">

										<fieldset>
											<legend>
												用户注册
											</legend>
											<table align="center">
												<tr>
													<td colspan="3" align="right">
														<font size="2" color="#666666">请注意：带有<font
															color="red">*</font>的项目必须填写。</font>
													</td>
													<td>
														&nbsp;
													</td>
												</tr>
												<tr>
													<td>
														&nbsp;
													</td>
												</tr>
												<tr>
													<td align="right">
														<font color="red">*</font>通行证用户名：
													</td>
													<td>
														<html:text property="username" />
														<BR />
														<html:errors property="username" />
													</td>
													<td width="50%">
														<font size="2" color="#666666">由字母a～z(不区分大小写)、数字0～9、点、减号或下划线组成</font>
													</td>
												</tr>


												<tr>
													<td>
														&nbsp;
													</td>
												</tr>
												<tr>
													<td align="right">
														<font color="red">*</font>登录密码：
													</td>
													<td>
														<html:password property="password" />
														<BR />
														<html:errors property="password" />
													</td>
													<td rowspan="2">
														<font size="2" color="#666666">密码长度6～16位，字母区分大小写</font>
													</td>
												</tr>
												<tr>
													<td align="right">
														<font color="red">*</font>重复登录密码：
													</td>
													<td>
														<html:password property="repassword" />
														<BR />
														<html:errors property="repassword" />
													</td>
												</tr>
												<tr>
													<td>
														&nbsp;
													</td>
												</tr>
												<tr>
													<td align="right">
														<font color="red">*</font>密码保护问题：
													</td>
													<td>
														<html:text property="question" />
														<BR />
														<html:errors property="question" />
													</td>
													<td rowspan="2">
														<font size="2" color="#666666">密码保护提示问题及答案的长度6～30位，字母区分大小写，一个汉字占两位。用于修复帐号密码</font>
													</td>
												</tr>
												<tr>
													<td align="right">
														<font color="red">*</font>您的答案：
													</td>
													<td>
														<html:password property="answer" />
														<BR />
														<html:errors property="answer" />
													</td>
												</tr>
												<tr>
													<td>
														&nbsp;
													</td>
												</tr>
												<tr>
													<td align="right">
														<font color="red">*</font>保密邮箱：
													</td>
													<td>
														<html:text property="email" />
														<BR />
														<html:errors property="email" />
													</td>
													<td>
														<font size="2" color="#666666">常用邮箱</font>
													</td>
												</tr>
												<tr>
													<td>
														&nbsp;
													</td>
												</tr>
												<tr>
													<td colspan="3" align="center">
														<html:submit value="  注 册 帐 号  " />
													</td>

												</tr>
											</table>
										</fieldset>
									</html:form>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>

