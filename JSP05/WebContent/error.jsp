<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error</title>
</head>
<body   bgcolor=gray   topmargin="10"   leftmargin="0"   id="TheBody">    
  <table   border="0"   bgcolor=#e0e0e0   align="center"   cellspacing="0"   style="BORDER-RIGHT:gray   2px   solid;   BORDER-TOP:white   2px   solid;   BORDER-LEFT:white   2px   solid;   BORDER-BOTTOM:gray   2px   solid"   width="407">    
      <tr>    
          <td   width=10px></td>    
          <td><%=exception.toString()%></td>     
      </tr>    
  </table>       

</body>
</html>