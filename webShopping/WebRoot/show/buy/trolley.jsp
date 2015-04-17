<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
	<head>
		<title>我的购物车</title>
		<script type="text/javascript">
			function del(id)
			{
				var url = "trolley.do?method=delete&pid="+id;
				window.location.href = url;
			}
		
		</script>
	</head>
	<body>
		<center>
			<table width="90%">
				<tr>
					<!-- head start -->
					<td>
						<jsp:include page="../../head.jsp">
							<jsp:param name="path" value="../../" />
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
						<table width="100%">
							<tr>
								<td width="25%">
									<!-- 其他信息 暂无 -->
								</td>
								<!-- 购物车 start -->
								<td>
									<fieldset>
										<legend>
											我的购物车
										</legend>
										<br>
										<html:form action="/show/buy/saleSorder.do" method="post">
											<table width="100%" border="0" cellspacing="0" datapagesize="0">
												<tr>
													<td>
														<b><font color="#666666">商品名称</font>
														</b>
													</td>
													<td align="center">
														<b><font color="#666666">价格￥</font></b>
													</td>
													<td>
														<b><font color="#666666">购买数量</font></b>
													</td>
													<td align="center">
														<b><font color="#666666">删除</font></b>
													</td>
												</tr>
												<tr>
													<td colspan="4">
														<br>
													</td>

												</tr>
												<logic:present name="trolley" scope="session">

													<logic:iterate id="t" name="trolley" scope="session">
														<tr>
															<td>
																${t.name }
															</td>
															<td align="center">
																${t.unitprice }
															</td>
															<td>
																<!-- 购买数量 -->
																<html:text property="count" value="1"></html:text>
															</td>
															<td align="center">
																<img src="../../images/delete.jpg" width="30"
																	height="25" style="cursor: hand" title="删除"
																	onclick="del('${t.pid}');"  />
															</td>
														</tr>
													</logic:iterate>
													<tr>
														<td colspan="4">
															<br>
															<hr size="0">
															<br>
															<font color="#8080c0"> - 基本信息</font>
														</td>
													</tr>
													<tr>
														<td align="right">
															<font color="#333333">联系电话：</font>
														</td>
														<td>
															<input type="text" name="phone" size="13" value="" />
														</td>
														<td align="right">
															<font color="#333333">送货地址：</font>
														</td>
														<td>
															<input type="text" name="address" value="" />
														</td>
													</tr>
													<tr>
														<td colspan="4">
															<br>
															<hr size="0">
															<br>
														</td>
													</tr>
													<tr>
														<td>
															<img src="../../images/money.jpg" width="50" height="35" title="合计" />
														</td>
														<td>
															?
														</td>
														<td colspan="2">
															<input type="hidden" name="method" value="purchase" />
															<html:submit value=" 购 买 " />
															&nbsp;
															<input type="button" value="继续购物"
																onclick="javascript:window.location.href='../../'" />
														</td>

													</tr>

												</logic:present>
												<logic:notPresent name="trolley" scope="session">
													<tr>
														<td colspan="4">
															<font color="#4c4c4c">购物车内暂无物品</font>
														</td>
													</tr>
												</logic:notPresent>
											</table>
										</html:form>
									</fieldset>
								</td>
								<!-- 购物车 end -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>

