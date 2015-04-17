<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>  
  </head>
  <body>
    <h1> &lt;c:choose></h1>
    <c:forEach var="index" begin="0" end="4">
      # ${index}: <br>
      <c:choose>
	<c:when test="${index == 1}">
            陈敏<br>
	</c:when>
	<c:when test="${index == 2}">
          孙龙<br>
	</c:when>
	<c:when test="${index == 3}">
          张雷<br>
	</c:when>
	<c:otherwise>
     陆广芳<br>
     姜鑫<br>
    孙练<br>
	</c:otherwise>
      </c:choose>
    </c:forEach>
  </body>
</html> 
