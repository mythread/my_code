<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="GB2312"%>
<jsp:useBean id="smart" scope="page" class="org.lxh.smart.SmartUpload"/>
<%
	// 1���ϴ���ʼ��
	smart.initialize(pageContext) ;
	// 2��׼���ϴ�
	smart.upload() ;
	// 3�������ϴ����ļ�
	// smart.save("/upload") ;
	String ext = smart.getFiles().getFile(0).getFileExt() ;
%>

<%
	String name = smart.getRequest().getParameter("name") ;
%>
<%
	// �����ļ�
	smart.getFiles().getFile(0).saveAs("/upload/"+name+"."+ext) ;
%>