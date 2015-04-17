<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<logic:present name="categoryChild" scope="request">
	<logic:iterate id="cgc" name="categoryChild" scope="request">
		<a href="index.jsp?cid=${ cgc.cid }">${ cgc.name }</a>
		<br>
		<br>
	</logic:iterate>
</logic:present>

