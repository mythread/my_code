<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="GB2312"%>
<jsp:useBean id="smart" scope="page" class="org.lxh.smart.SmartUpload"/>
<%
	// 1���ϴ���ʼ��
	smart.initialize(pageContext) ;
	// 2��׼���ϴ�
	smart.upload() ;
	// 3�������ϴ����ļ�
	// smart.save("/upload") ;
%>

<%
	String name = smart.getRequest().getParameter("name") ;
%>
smart.getRequest().getParameter("name"):
<%=name%><br>
request.getParameter("name"):
<%=request.getParameter("name") %>