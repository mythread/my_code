<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>��������</title>

		<script type="text/javascript">
			function validate() {
				var pass = document.getElementById("pass");
				var repass = document.getElementById("repass");
				
				if(pass.value == repass.value){
					return true;
				} else {
					window.alert("�ظ�������д���� : ( ");
					return false;
				}
			} 
		</script>
	</head>

	<body>
		<center>
			<table width="70%">
				<tr>
					<td>
						<jsp:include page="head.jsp" /><br>
						<fieldset>
							<legend>
								��������
							</legend>
							<html:form action="userinfo/pass.do" method="post"
								onsubmit="return validate()">

								<table align="center" width="70%">

									<tr>
										<td>
											�������� :
										</td>
										<td>
											<input type="password" name="password" value="" id="pass">
											<BR />
											<html:errors property="password" />
										</td>
									</tr>
									<tr>
										<td>
											&nbsp;
										</td>
									</tr>
									<tr>
										<td>
											�ظ����� :
										</td>
										<td>
											<input type="password" name="repassword" value="" id="repass">
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
										<td colspan="2" align="center">
											<input type="hidden" name="method" value="dopass">
											<input type="submit" value=" �� �� �� �� " />
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
