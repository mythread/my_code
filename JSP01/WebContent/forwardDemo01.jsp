<%
	String name = "helinxfy" ;
%>

<jsp:forward page="forwardDemo02.jsp">
	<jsp:param name="ref1" value="JAVA"/>
	<jsp:param name="ref2" value="<%=name%>"/>
</jsp:forward>