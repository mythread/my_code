<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<logic:present name="categoryRoot" scope="request">
	<logic:iterate id="cgr" name="categoryRoot" scope="request">
		<a href="show/index.jsp?cid=${ cgr.cid }">${ cgr.name }</a>
		<br>
		<br>
	</logic:iterate>
</logic:present>
