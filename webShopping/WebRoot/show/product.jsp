<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<logic:notPresent name="showOne" scope="request">
	<jsp:forward page="/show/product.do">
		<jsp:param name="method" value="showOne" />
		<jsp:param name="pid" value="${param.pid}" />
	</jsp:forward>
</logic:notPresent>
<head>
	<html:base />

	<title>商品信息</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<logic:present name="showOne" scope="request">
		<script type="text/javascript">
			function buy(){
				var username = "${sessionScope.username}";
				if(username == ""){
					var url = new Array();
					url.push("../forwardLogin.jsp?from=");
					url.push(document.location.href);
					document.location.href=url.join("");
				} else {
					var trolley = document.getElementById("trolley");
					trolley.submit();
				}
			}
			// <!-- 登录后返回上一次浏览的页面 -->
			function forwardlogin(){
				var url = new Array();
				url.push("../");
				url.push("login.jsp?from=");
				url.push(document.location.href);
				document.location.href=url.join("");
			}
		</script>
	</logic:present>
</head>

<body>

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
					<%-- showPorductw为标记 --%>
					<logic:present name="showOne" scope="request">
						<form id="trolley" action="buy/trolley.do" method="post">
							<input type="hidden" name="pid"
								value="<bean:write property='pid' name='productForm' />" />
							<input type="hidden" name="name"
								value="<bean:write property='name' name='productForm' />" />
							<input type="hidden" name="unitprice"
								value="<bean:write property='unitprice' name='productForm' />" />
							<input type="hidden" name="method" value="append" />
						</form>
						<table width="100%">
							<tr>
								<td width="25%">
									<!-- 其他信息 暂无 -->
								</td>
								<!-- 商品 start -->
								<td>
									<fieldset>
										<legend>
											商品展示
										</legend>
										<br>
										<table width="100%">
											<tr>
												<td rowspan="3" width="30%">
													<img
														src="../<bean:write property="picture" name="productForm"/>"
														width="150" height="150" />
													<br>
													<br>
												</td>
												<td colspan="2">
													<b><bean:write property="name" name="productForm" /> </b>
												</td>
											</tr>
											<tr>
												<td width="25%">
													单价:
													<bean:write property="unitprice" name="productForm" />
													￥
												</td>
												<td>
													优惠价:
													<bean:write property="discount" name="productForm" />
													￥
												</td>
											</tr>
											<tr>
												<td>
													<img src="../images/buy.gif" style="cursor: hand"
														onclick="buy();">
												</td>
												<td>
													<img src="../images/addshoucang.gif" style="cursor: hand"
														onclick="">
												</td>
											</tr>
											<!-- 其他信息 strat 按照此格式写-->
											<tr style="background-color: rgb(0, 128, 255);">
												<td colspan="3">
													&nbsp;
													<font color="#ffffff">产品描述</font>
												</td>
											</tr>
											<tr>
												<td colspan="3">
													<br>
													<bean:write property="descr" name="productForm" />
													<br>
													<br>
												</td>
											</tr>
											<!-- 其他信息 end  按照此格式写-->
										</table>
									</fieldset>
								</td>
								<!-- 商品 end -->
							</tr>
						</table>
					</logic:present>
				</td>
			</tr>
		</table>
	</center>
</body>
</html:html>
