<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <title>JSP 2.0 Expression Language - Implicit Objects</title>
  </head>
  <body>
    <h1>JSP 2.0 Expression Language - Implicit Objects</h1>

    <blockquote>
      <br>
      <code>
        <table border="1">
          <thead>
	    <td><b>EL Expression</b></td>
	    <td><b>Result</b></td>
	  </thead>
	
	  <tr>
	    <td>\${pageContext.request.requestURL}</td>
	    <td>${pageContext.request.requestURL}</td>
	  </tr>
	  <tr>
	    <td>\${pageContext.request.contextPath}</td>
	    <td>${pageContext.request.contextPath}</td>
	  </tr>
	  <tr>
	    <td>\${pageContext.request.method}</td>
	    <td>${pageContext.request.method}</td>
	  </tr>
	  <tr>
	    <td>\${pageContext.request.protocol}</td>
	    <td>${pageContext.request.protocol}</td>
	  </tr>
	  <tr>
	    <td>\${pageContext.request.remoteUser}</td>
	    <td>${pageContext.request.remoteUser}</td>
	  </tr>
	  <tr>
	    <td>\${pageContext.servletContext.serverInfo}</td>
	    <td>${pageContext.servletContext.serverInfo}</td>
	  </tr>
	</table>
      </code>
    </blockquote>
  </body>
</html>
