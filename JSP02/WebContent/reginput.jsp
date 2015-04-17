
<%@page contentType="text/html; charset=UTF-8" language="java"%>

<html>
<head>
<title>test</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div align="center">输入表单
  <form name="form1" method="get" action="reginfo.jsp">
    <table width="600" border="0" align="center">
      <tr> 
        <td>姓名</td>
        <td> 
          <input type="text" name="name">
        </td>
      </tr>
      <tr> 
        <td height="19">密码</td>
        <td height="19"> 
          <input type="password" name="pwd">
        </td>
      </tr>

      <tr> 
        <td>性别</td>
        <td> 
          <input type="radio" name="gender" value="male">
          male
          <input type="radio" name="gender" value="female">
          female </td>
      </tr>
      <tr> 
        <td>出生年份</td>
        <td> 
          <select name="year">
            <option value="2000">2000</option>
            <option value="2001">2001</option>
            <option value="2002">2002</option>
            <option value="2003">2003</option>
            <option value="2004">2004</option>
            <option value="2005">2005</option>
            <option value="2006">2006</option>
          </select>
          
        </td>
      </tr>
      <tr> 
        <td>技术能力</td>
        <td> 
          <input type="checkbox" name="tec" value="VB">
          VB 
          <input type="checkbox" name="tec" value=".NET">
          .NET 
          <input type="checkbox" name="tec" value="C++">
          C++ 
          <input type="checkbox" name="tec" value="JAVA">
          JAVA</td>
      </tr>
      <tr> 
        <td> 
          <div align="right"> 
            <input type="submit" name="Submit" value="提交">
          </div>
        </td>
        <td> 
          <input type="reset" name="rs" value="重置">
        </td>
      </tr>
    </table>
    <p>&nbsp;</p>
  </form>
</div>
</body>
</html>
