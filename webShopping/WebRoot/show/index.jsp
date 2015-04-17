<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>商品列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
			<link rel="stylesheet" type="text/css" href="styles.css">
		-->
		
		<!-- 登录后返回上一次浏览的页面 start -->
		<script type="text/javascript">
			function forwardlogin(){
				var url = new Array();
				url.push("../");
				url.push("login.jsp?from=");
				url.push(document.location.href);
				document.location.href=url.join("");
			}
		</script>
		<!-- 登录后返回上一次浏览的页面 end -->
		
	</head>
	<body>
	<logic:present parameter="cid" scope="request">
		<logic:notPresent name="products" scope="request">
			<jsp:forward page="/show/product.do">
				<jsp:param name="method" value="products" />
				<jsp:param name="cid" value="${param.cid}" />
			</jsp:forward>
		</logic:notPresent>
		<logic:notPresent name="categoryChild" scope="request">
			<jsp:forward page="/show/category.do">
				<jsp:param name="method" value="listChild" />
				<jsp:param name="cid" value="${param.cid}" />
			</jsp:forward>
		</logic:notPresent>
	</logic:present>
	<logic:notPresent parameter="cid" scope="request">
		<script type="text/javascript">
			window.location.href="../";
		</script>
	</logic:notPresent>
		<center>
			<table width="90%">
				<tr>
					<!-- head start -->
					<td>
						<jsp:include page="../head.jsp">
							<jsp:param name="path" value="../" />
						</jsp:include>
					</td>
					<!-- head end -->
				</tr>
				<tr>
					<td>
						<hr>
						<br>
					</td>
				</tr>
				<tr>
					<td>
						热推、热销产品
						<br>
						<br>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%">
							<tr>
								<!-- 分类 start -->
								<td width="25%" valign="top">
									<jsp:include page="listcategory.jsp">
										<jsp:param name="cid" value="${requestScope.cid}" />
									</jsp:include>
								</td>
								<!-- 分类 end -->
								<!-- 商品 start -->
								<td>
									<fieldset>
										<legend>
											商品区
										</legend>
										<br>
										<jsp:include page="listproduct.jsp">
											<jsp:param name="cid" value="${requestScope.cid}" />
										</jsp:include>
										<br>
									</fieldset>
								</td>
								<!-- 商品 end -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>
