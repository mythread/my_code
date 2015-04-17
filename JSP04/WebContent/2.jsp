<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
    <title>JSP 2.0 Expression Language - Implicit Objects</title>
  </head>
  <body>
    <h1>JSP 2.0 Expression Language - Implicit Objects</h1>

    <blockquote>
      <b>Change Parameter</b>
      <form action="2.jsp" method="GET">
	  foo = <input type="text" name="foo" value='${fn:escapeXml(param["foo"])}'>
          <input type="submit">
      </form>
      <br>
      <code>
        <table border="1">
          <thead>
	    <td><b>EL Expression</b></td>
	    <td><b>Result</b></td>
	  </thead>
	  <tr>
	    <td>\${param.foo}</td>
	    <td>${fn:escapeXml(param["foo"])}&nbsp;</td>
	  </tr>
	  <tr>
	    <td>\${param["foo"]}</td>
	    <td>${fn:escapeXml(param["foo"])}&nbsp;</td>
	  </tr>
	  <tr>
	    <td>\${header["host"]}</td>
	    <td>${fn:escapeXml(header["host"])}&nbsp;</td>
	  </tr>
	  <tr>
	    <td>\${header["accept"]}</td>
	    <td>${fn:escapeXml(header["accept"])}&nbsp;</td>
	  </tr>
	  <tr>
	    <td>\${header["user-agent"]}</td>
	    <td>${fn:escapeXml(header["user-agent"])}&nbsp;</td>
	  </tr>
	  <tr>
	    <td>\${header["referer"]}</td>
	    <td>${fn:escapeXml(header["referer"])}&nbsp;</td>
	  </tr>
	</table>
      </code>
    </blockquote>
  </body>
</html>
