<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Vector" %>
<html>
  <head>
   
  </head>
  <body>
    <h1>Tag Plugin Examples - &lt;c:forEach></h1>
    <h3>Iterating over a range</h3>
    <c:forEach var="item" begin="1" end="10">
        ${item}
    </c:forEach>

    <% Vector v = new Vector();
	v.add("One"); v.add("Two"); v.add("Three"); v.add("Four");

	pageContext.setAttribute("vector", v);
    %>

    <h3>Iterating over a Vector</h3>

    <c:forEach items="${vector}" var="item" >
	${item}
    </c:forEach>
  </body>
</html> 
