<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="GB2312"%>
<jsp:useBean id="smart" scope="page" class="org.lxh.smart.SmartUpload"/>
<%
	// 1、上传初始化
	smart.initialize(pageContext) ;
	// 2、准备上传
	smart.upload() ;
	// 3、保存上传的文件
	// smart.save("/upload") ;
	String ext = smart.getFiles().getFile(0).getFileExt() ;
%>

<%
	String name = smart.getRequest().getParameter("name") ;
%>
<%
	// 保存文件
	smart.getFiles().getFile(0).saveAs("/upload/"+name+"."+ext) ;
%>