<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>正在返回上一次浏览的页面...</title>
	<SCRIPT LANGUAGE="JavaScript"> 
		<!-- 
		var time = 2; //时间,秒 
		var url = "${param.from}";
		
		if(url == ""){
			time = 0;
			url="/shopping/userinfo/index.jsp";
		}
		
		function Redirect(){ 
			window.location = url; 
		} 
		var i = 0; 
		function dis(){ 
			document.all.s.innerHTML = (time - i) + "秒"; 
			i++; 
		} 
		timer=setInterval('dis()', 1000);//显示时间 
		timer=setTimeout('Redirect()',time * 1000); //跳转 
		
		//--> 
	</SCRIPT>

</head>

<body>

	<logic:present parameter="from">
		<center>
			<table width="90%">
				<tr>
					<td colspan="3">
						<jsp:include page="head.jsp" /><br>
						<br>
						<br>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td width="60%">

						<fieldset>
							<legend>
								会员导航功能
							</legend>
							<br>
							&nbsp;
							<font color="#4b4b4b" size="2">&nbsp;您可以前往以下地址：</font>
							<br>
							&nbsp;
							<font color="#4b4b4b" size="2">&nbsp;系统会在<font
								color="#ff0000"><span id="s">3秒</span> </font>后，自动跳到下面的连接</font>
							<br>
							&nbsp;&nbsp;
							<font size="2"> <a href="${param.from }">${param.from}</a>
							</font>
							<br>
							<br>
						</fieldset>
					</td>
					<td>
					</td>
				</tr>
			</table>
		</center>
	</logic:present>
</body>
</html:html>
