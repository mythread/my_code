<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
1. 访问action内的普通属性<br>
username: <font color="red" ><s:property value="username"/><br></font>
password: <font color="red" ><s:property value="password"/><br></font>
<hr>

2. 访问action内的其他对象属性<br>
person: <font color="red" ><s:property value="person"/><br></font>
person.age: <font color="red" ><s:property value="person.age"/><br></font>
<hr>

3. 访问action内的对象的普通方法<br>
person.getAge(): <font color="red" ><s:property value="person.getAge()"/><br></font>
person.toString(): <font color="red" ><s:property value="person.toString()"/><br></font>
<hr>

4. 访问静态方法<br>
@com.ibm.etp.vo.Person@getCountry(): <font color="red" ><s:property value="@com.ibm.etp.vo.Person@getCountry()"/><br></font>
<hr>

5. 访问静态变量<br>
@com.ibm.etp.vo.Person@country: <font color="red" ><s:property value="@com.ibm.etp.vo.Person@country"/><br></font>
<hr>

6. 访问List<br>
List: <font color="red" ><s:property value="personList"/><br></font>
<hr>

7. 访问List某个元素<br>
List[0]: <font color="red" ><s:property value="personList[0]"/><br></font>
List[1]: <font color="red" ><s:property value="personList[1]"/><br></font>
List[2]: <font color="red" ><s:property value="personList[2]"/><br></font>
List[3]: <font color="red" ><s:property value="personList[3]"/><br></font>
<hr>

8. 访问List中元素某个属性的集合<br>
List{age}: <font color="red" ><s:property value="personList.{age}"/><br></font>
<hr>

9. 访问List中元素某个属性的集合中的特定值<br>
personList[0].age: <font color="red" ><s:property value="personList[0].age"/><br></font>
<hr>

10. 访问Map<br>
personMap: <font color="red" ><s:property value="personMap"/><br></font>
<hr>

11. 访问Map中某个元素<br>
personMap.p30: <font color="red" ><s:property value="personMap.p30"/><br></font>
<hr>

12. 访问Map中所有的key<br>
personMap.keys: <font color="red" ><s:property value="personMap.keys"/><br></font>
<hr>

13. 访问Map中所有的value<br>
personMap.values: <font color="red" ><s:property value="personMap.values"/><br></font>
<hr>

<s:debug></s:debug>
</body>
</html>