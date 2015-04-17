<%@ page pageEncoding="UTF-8"%>
<html>
  <head>
    <title>JSP 2.0 Expression Language - Basic Arithmetic</title>
  </head>
  <body>
    <h1>JSP 2.0 EL</h1>
    <hr>
    <!-- 
<blockquote> 标签可定义一个块引用。
<blockquote> 与 </blockquote> 之间的所有文本都会从常规文本中分离出来，
经常会在左、右两边进行缩进，而且有时会使用斜体。
也就是说，块引用拥有它们自己的空间。
     -->
    <blockquote>
      <code>
        <table border="1" bgColor="#80ffff" align="left" cellpadding="2" cellspacing="2">
          <thead style="color: blue">
	    <td><b>Expression Language Expression</b></td>
	    <td><b>Result</b></td>
	  </thead>
	  <tr>
	    <td>\${1}</td>
	    <td>${1}</td>
	  </tr>
	  <tr>
	    <td>\${1 + 2}</td>
	    <td>${1 + 2}</td>
	  </tr>
	  <tr>
	    <td>\${1.2 + 2.3}</td>
	    <td>${1.2 + 2.3}</td>
	  </tr>
	  <tr>
	    <td>\${1.2E4 + 1.4}</td>
	    <td>${1.2E4 + 1.4}</td>
	  </tr>
	  <tr>
	    <td>\${-4 - 2}</td>
	    <td>${-4 - 2}</td>
	  </tr>
	  <tr>
	    <td>\${21 * 2}</td>
	    <td>${21 * 2}</td>
	  </tr>
	  <tr>
	    <td>\${3/4}</td>
	    <td>${3/4}</td>
	  </tr>
	  <tr>
	    <td>\${3 div 4}</td>
	    <td>${3 div 4}</td>
	  </tr>
	  <tr>
	    <td>\${3/0}</td>
	    <td>${3/0}</td>
	  </tr>
	   <tr>
	    <td>\${3/-0}</td>
	    <td>${3/-0}</td>
	  </tr>
	  <tr>
	    <td>\${-3/0}</td>
	    <td>${-3/0}</td>
	  </tr>
	  <tr>
	    <td>\${10%4}</td>
	    <td>${10%4}</td>
	  </tr>
	  <tr>
	    <td>\${10 mod 4}</td>
	    <td>${10 mod 4}</td>
	  </tr>
	  <tr>
	    <td>\${1<2}</td>
	    <td>${1<2}</td>
	  </tr>
	   <tr>
	    <td>\${1 lt 2}</td>
	    <td>${1 lt 2}</td>
	  </tr>
	  <tr>
	    <td>\${true&&false}</td>
	    <td>${true&&false}</td>
	  </tr>
	  <tr>
	    <td>\${true and false}</td>
	    <td>${true and false}</td>
	  </tr>
	   <tr>
	   <%!String s="aaa"; %>
	    <td>\${empty s}</td>
	    <td>${empty s}</td>
	  </tr>
	   <tr>
	   <%session.setAttribute("s1","ag"); %>
	    <td>\${empty s1}</td>
	    <td>${empty s1}</td>
	  </tr>
    <tr>
      <td>\${(1==2) ? 3 : 4}</td>
      <td>${(1==2) ? 3 : 4}</td>
    </tr>
	</table>
      </code>
    </blockquote>
  </body>
</html>
