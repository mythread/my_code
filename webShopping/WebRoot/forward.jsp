<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
	<html:base />

	<title>���ڷ�����һ�������ҳ��...</title>
	<SCRIPT LANGUAGE="JavaScript"> 
		<!-- 
		var time = 2; //ʱ��,�� 
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
			document.all.s.innerHTML = (time - i) + "��"; 
			i++; 
		} 
		timer=setInterval('dis()', 1000);//��ʾʱ�� 
		timer=setTimeout('Redirect()',time * 1000); //��ת 
		
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
								��Ա��������
							</legend>
							<br>
							&nbsp;
							<font color="#4b4b4b" size="2">&nbsp;������ǰ�����µ�ַ��</font>
							<br>
							&nbsp;
							<font color="#4b4b4b" size="2">&nbsp;ϵͳ����<font
								color="#ff0000"><span id="s">3��</span> </font>���Զ��������������</font>
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
