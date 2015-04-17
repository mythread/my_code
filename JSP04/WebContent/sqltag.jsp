z<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<title>core</title>
</head>
<body>
<h1> 使用 SQL 标签库</h1>

<sql:setDataSource
driver = "com.mysql.jdbc.Driver" url= 
"jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=utf-8" user="root" password="root" var="conn"/>
<sql:transaction dataSource="${conn}">
<sql:update var="update" scope="page">
drop table if EXISTS note1
</sql:update>
<sql:update var="update" scope="page">
CREATE TABLE note1 (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(20) NOT NULL,
  author varchar(20) NOT NULL,
  content varchar(50) default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
</sql:update>
<sql:update>
INSERT INTO `note1` (`title`, `author`, `content`) VALUES 
  ('test01','hl','agjlakjgalg'),
  ('test','helinxfy','welcome java world ');

</sql:update>
<sql:update>
  commit;
</sql:update>
</sql:transaction>
<sql:query var="all" dataSource="${conn}">
select * from note1 where author='hl'
</sql:query>
<c:catch var="sqle">
 <c:forEach var="row" items="${all.rows}">
  <c:out value="${row.id}" />
  <c:out value="${row.title}" />
  <c:out value="${row.author}" />
  <c:out value="${row.content}"/>
  <br>
 </c:forEach>
</c:catch>


</body>

</html>
