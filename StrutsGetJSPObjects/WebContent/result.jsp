<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 第一种打印方式，JSP表达式 -->
第一种打印方式，JSP表达式<br /><br />
<%=request.getAttribute("email") %><br />
<%=session.getAttribute("now") %><br />
<%=application.getAttribute("projname") %>
<hr />

<!-- 第二种打印方式，EL表达式 -->
第二种打印方式，EL表达式<br /><br />
${request.email }<br />
${session.now }<br />
${application.projname }<br />
<hr />

<!-- 第三种打印方式，OGNL表达式(Struts2用) -->
第三种打印方式，OGNL表达式(Struts2用)<br /><br />
<s:property value="#request.email "/><br />
<s:property value="#session.now "/><br />
<s:property value="#application.projname "/><br />
<hr />
<s:property value="#application.jsp_classpath "/><br />

以下是struts的debug输出信息，可以给出所有当前可用值的信息<br />
你应当可以在Stack Context表格中找到request行和session行<br />
里面可以查看到我们放到request对象中的email和放到session对象的now<br />
<s:debug></s:debug>
</body>
</html>