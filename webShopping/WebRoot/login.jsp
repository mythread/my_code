<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>

<html>
	<head>
		<title>�û���¼</title>
	</head>
	<script type="text/javascript">
		// ���ڵ�¼�󷵻���һ�������ҳ��
		function login(){
			var login = document.getElementById("login");
			var from = "${param.from }";
			if(from == ""){
				return true;
			} else {
				login.action="login.do?from="+from;
				return true;
			}
		}
	</script>
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
						<br>
						<br>
						<table width="40%">
							<tr>
								<td>
									<fieldset>
										<legend>
											�û���¼
										</legend>
										<form id="login" action="login.do" method="post"
											onsubmit="return login();">
											<center>
												<html:errors property="loginerr" />
												<table width="25%">
													<tr>
														<td>
															�û��� :
														</td>
														<td>
															<html:text property="username" value=""></html:text><BR />
															<html:errors property="username" />
														</td>
													</tr>
													<tr>
														<td>
															��&nbsp;&nbsp;�� :
														</td>
														<td>
															<html:password property="password" value=""></html:password><BR />
															<html:errors property="password" />
														</td>
													</tr>
													<tr>
														<td>
															<input type="submit" value=" ��¼ " />
														</td>
														<td align="right">
															<a href="register.jsp">ע��</a>
															<a href="">�������룿</a>
														</td>
													</tr>
												</table>
											</center>
										</form>
									</fieldset>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

		</center>
	</body>
</html>

