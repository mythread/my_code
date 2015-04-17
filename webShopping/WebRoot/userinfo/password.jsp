<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>更改密码</title>
	</head>

	<body>
		<logic:present name="dopass" scope="request">
			<script type="text/javascript">
				window.alert("请先填写密码保护问题及答案 : ( ");
			</script>
		</logic:present>
		<center>
			<table width="70%">
				<tr>
					<td>
						<jsp:include page="head.jsp" /><br>
						<fieldset>
							<legend>
								更改密码
							</legend>
							<center>
								<html:errors property="question" />
							</center>
							<html:form action="userinfo/pass.do" method="post">
								<table align="center" width="70%">
									<tr>
										<td>
											密码保护问题 :
										</td>
										<td>
											<html:text property="question"></html:text>
										</td>
									</tr>
									<tr>
										<td>
											&nbsp;
										</td>
									</tr>
									<tr>
										<td>
											您的问题答案 :
										</td>
										<td>
											<html:password property="answer" value=""></html:password>
										</td>
									</tr>
									<tr>
										<td>
											&nbsp;
										</td>

									</tr>
									<tr>
										<td colspan="2" align="center">
											<input type="hidden" name="method" value="pass">
											<input type="submit" value=" 下 一 步 " />
										</td>
									</tr>
								</table>

							</html:form>
						</fieldset>
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>
