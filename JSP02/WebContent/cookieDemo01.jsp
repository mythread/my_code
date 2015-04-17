<%
	Cookie c1 = new Cookie("name","helinxfy") ;
	Cookie c2 = new Cookie("password","JAVA02") ;

	c1.setMaxAge(60) ;
	c2.setMaxAge(60) ;
%>
<%
	response.addCookie(c1) ;
	response.addCookie(c2) ;
%>