<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>

<html>
	<head>
		<title>ע��ͨ��֤</title>
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
												�û�ע��
											</legend>
											<table align="center">
												<tr>
													<td colspan="3" align="right">
														<font size="2" color="#666666">��ע�⣺����<font
															color="red">*</font>����Ŀ������д��</font>
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
														<font color="red">*</font>ͨ��֤�û�����
													</td>
													<td>
														<html:text property="username" />
														<BR />
														<html:errors property="username" />
													</td>
													<td width="50%">
														<font size="2" color="#666666">����ĸa��z(�����ִ�Сд)������0��9���㡢���Ż��»������</font>
													</td>
												</tr>


												<tr>
													<td>
														&nbsp;
													</td>
												</tr>
												<tr>
													<td align="right">
														<font color="red">*</font>��¼���룺
													</td>
													<td>
														<html:password property="password" />
														<BR />
														<html:errors property="password" />
													</td>
													<td rowspan="2">
														<font size="2" color="#666666">���볤��6��16λ����ĸ���ִ�Сд</font>
													</td>
												</tr>
												<tr>
													<td align="right">
														<font color="red">*</font>�ظ���¼���룺
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
														<font color="red">*</font>���뱣�����⣺
													</td>
													<td>
														<html:text property="question" />
														<BR />
														<html:errors property="question" />
													</td>
													<td rowspan="2">
														<font size="2" color="#666666">���뱣����ʾ���⼰�𰸵ĳ���6��30λ����ĸ���ִ�Сд��һ������ռ��λ�������޸��ʺ�����</font>
													</td>
												</tr>
												<tr>
													<td align="right">
														<font color="red">*</font>���Ĵ𰸣�
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
														<font color="red">*</font>�������䣺
													</td>
													<td>
														<html:text property="email" />
														<BR />
														<html:errors property="email" />
													</td>
													<td>
														<font size="2" color="#666666">��������</font>
													</td>
												</tr>
												<tr>
													<td>
														&nbsp;
													</td>
												</tr>
												<tr>
													<td colspan="3" align="center">
														<html:submit value="  ע �� �� ��  " />
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

