<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>��������</title>
	</head>

	<body>
		<logic:present name="dopass" scope="request">
			<script type="text/javascript">
				window.alert("������д���뱣�����⼰�� : ( ");
			</script>
		</logic:present>
		<center>
			<table width="70%">
				<tr>
					<td>
						<jsp:include page="head.jsp" /><br>
						<fieldset>
							<legend>
								��������
							</legend>
							<center>
								<html:errors property="question" />
							</center>
							<html:form action="userinfo/pass.do" method="post">
								<table align="center" width="70%">
									<tr>
										<td>
											���뱣������ :
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
											��������� :
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
											<input type="submit" value=" �� һ �� " />
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
