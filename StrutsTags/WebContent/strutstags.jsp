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
<s:form action="dsfsafdsa" theme="simple">

1. 常用的property标签，打印基本信息<br>
username: <font color="red"><s:property value="username"/></font>
<hr>

2. 常用的property标签，取值为字符串<br>
string: <font color="red">我这里使用了<s:property value="'<s:property>'" />标签打印出来的<s:property value="'这里是我手工输入字符串'"/></font><br>
<hr>

3. 从request取值，因为是从Stack Context得到，所以要加#:<br>
#request.username: <font color="red"><s:property value="#request.username"/></font><br>
<hr>

4. <s:property value="'<s:if>'"/>逻辑判断标签: if...else<br>
查找personinfoList对象是否存在，如有，就打印<br>
<s:if test="personinfoList != null">
    <s:property value="personinfoList"/>
</s:if>
<br>
<hr>

5. <s:property value="'<s:iterator>'"/>遍历集合<br>

<s:if test="personinfoList" >
    <s:iterator value="personinfoList" id="personinfo" status="i">
        <s:property value="#i.index + 1"/>
        <s:property value="#personinfo.username"/>
        <s:property value="#personinfo.userid"/>
        <s:property value="#personinfo.age"/>
        <s:property value="#personinfo.email"/>
        <br>
    </s:iterator>
</s:if>
<s:else>
    查询对象不存在
</s:else>
<br>
<hr>


6. 这个时候，我们可以把集合遍历到表格里面<br>
<table border="1">
    <tr>
        <td>No.</td>
        <td>userid</td>
        <td>username</td>
        <td>age</td>
        <td>email</td>
    </tr>
    <s:iterator value="personinfoList" id="personinfo" status="i">
        <tr>
            <td><s:property value="#i.index + 1"/></td>
            <td><s:property value="#personinfo.username"/></td>
            <td><s:property value="#personinfo.userid"/></td>
            <td><s:property value="#personinfo.age"/></td>
            <td><s:property value="#personinfo.email"/></td>
        </tr>
    </s:iterator>
</table>
<br>
<hr>

7. 如果该人未成年，会该行标红<br>
<table border="1">
    <tr>
        <td>No.</td>
        <td>userid</td>
        <td>username</td>
        <td>age</td>
        <td>email</td>
    </tr>
    <s:if test="personinfoList" >
        <s:iterator value="personinfoList" id="personinfo" status="i">
            <s:if test="#personinfo.age < 18">
                <tr>
                <!-- 该行标红 -->
                <font color="red">
                    <td><s:property value="#i.index + 1"/></td>
                    <td><s:property value="#personinfo.username"/></td>
                    <td><s:property value="#personinfo.userid"/></td>
                    <td><s:property value="#personinfo.age"/></td>
                    <td><s:property value="#personinfo.email"/></td>
                </font>
                </tr>
            </s:if>
            <s:else>
                <tr>
                    <td><s:property value="#i.index + 1"/></td>
                    <td><s:property value="#personinfo.username"/></td>
                    <td><s:property value="#personinfo.userid"/></td>
                    <td><s:property value="#personinfo.age"/></td>
                    <td><s:property value="#personinfo.email"/></td>
                </tr>
            </s:else>
        </s:iterator>
    </s:if>
</table>
<br>
<hr>

8. ui标签。这里只用文本框来做示例。<br>
刚才在前一张页面里面输入的username字段，在使用Struts标签之后，会自动得到名为username的值<br>
<s:textfield id="username" name="username"/>
<hr>

9. password标签<br>
password: <s:password id="username" name="username"/>
<hr>

10. textarea标签<br>
textarea: <s:textarea id="username" name="username" />
<hr>

11. checkbox标签<br>
<s:checkboxlist name="province" list="checkboxMap" />
<hr>

12. radio标签<br>
<s:radio name="province_radio" list="checkboxMap" />
<hr>

13. select标签<br>
<s:select name="province_select" list="checkboxMap" />

<s:debug></s:debug>
</s:form>
</body>
</html>