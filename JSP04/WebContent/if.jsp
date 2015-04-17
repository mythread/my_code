<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Vector" %>
<html>
  
  <body>
   &lt;c:if test="\${1==1}" var="t" scope="session"&gt;:
    <c:if test="${1==1}" var="t" scope="session">
    ${t}<br>
    </c:if>
    &lt;c:if test="\${1==1}"&gt;:
    <c:if test="${1==1}">
    1==1<br>
    </c:if>
    &lt;c:if test="\${1!=1}"&gt;:
    <c:if test="${1!=1}">
    1!=1<br>
    </c:if>
  </body>
</html> 
