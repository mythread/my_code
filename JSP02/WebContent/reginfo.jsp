
<%@page contentType="text/html; charset=UTF-8" language="java"%>
<%!
   public String formatStr(String str){
     return str==null?"":str;
   }
%>

<%
String name = formatStr(request.getParameter("name"));
String pwd = formatStr(request.getParameter("pwd"));
String gender = formatStr(request.getParameter("gender"));
String year = formatStr(request.getParameter("year"));
String[] tecs = request.getParameterValues("tec");
%>

<html>
<head>
<title>info</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div align="center">表单信息反馈
  <form name="form1" method="post" action="">
    <table width="600" border="0" align="center">
      <tr> 
        <td>姓名</td>
		<td><%=name%></td>
      </tr>
      <tr> 
        <td>密码</td>
		<td><%=pwd%></td>
      </tr>
      <tr> 
        <td>性别</td>
		<td><%=gender%></td>
      </tr>
      <tr> 
        <td >出生年份</td>
		<td><%=year%></td>
      </tr>
      <tr> 
        <td width="185">技术能力</td>
        <td width="405"> 
          <% if(tecs!=null){
             for(int i=0;i<tecs.length;i++){
                out.print(tecs[i]);
               out.print("&nbsp;");
             }
           }
        %>
        </td>
      </tr>
    </table>
    <p>&nbsp;</p>
  </form>
</div>
</body>
</html>
