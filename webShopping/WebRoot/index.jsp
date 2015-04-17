<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>��ҳ</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
			<link rel="stylesheet" type="text/css" href="styles.css">
		-->
		
		<!-- ��¼�󷵻���һ�������ҳ�� start -->
		<script type="text/javascript">
			function forwardlogin(){
				var url = new Array();
				url.push("login.jsp?from=");
				url.push(document.location.href);
				document.location.href=url.join("");
			}
		</script>
		<!-- ��¼�󷵻���һ�������ҳ�� end -->
		
	</head>
	<body>
		<logic:notPresent name="newProduct" scope="request">
			<jsp:forward page="/show/product.do?method=listNew"></jsp:forward>
		</logic:notPresent>
		<logic:notPresent name="categoryRoot" scope="request">
			<jsp:forward page="/show/category.do?method=listRoot"></jsp:forward>
		</logic:notPresent>

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
					<td>
						���ơ�������Ʒ
						<br>
						<br>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%">
							<tr>
								<!-- ���� start -->
								<td width="25%" valign="top">
									<jsp:include page="categoryroot.jsp" />
								</td>
								<!-- ���� end -->
								<!-- ��Ʒ start -->
								<td>
									<fieldset>
										<legend>
											������Ʒ
										</legend>
										<br>
										<jsp:include page="productnew.jsp" />
										<br>
									</fieldset>
								</td>
								<!-- ��Ʒ end -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>
