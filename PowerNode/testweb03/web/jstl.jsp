<%@ page import="enity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/14
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Student s = new Student();
        s.setName("张三");
        s.setAge(60);

        Student s1 = new Student();
        s1.setName("admin");
        s1.setAge(30);

        Student s2 = new Student();
        s2.setName("tomcat");
        s2.setAge(10);

        List<Student> ss = new ArrayList<>();
        ss.add(s);
        ss.add(s1);
        ss.add(s2);
        session.setAttribute("ss", ss);
        session.setAttribute("s1", s);
    %>
    <%--
        set:
            1）可以直接修改域对象中的数据的属性
            2）直接在域对象中添加一个键值对
            out:等效于jsp中的输出表达式
            if:等效于java中的if语句
            choose:等效于switch语句
    --%>
    <hr>
    <%--<c:set target="${s1}" property="name" value="tomcat"></c:set>--%>
    <br>
    学生姓名：${s1.name}
    <br>
    <c:set var="gender" scope="session" value="women"></c:set>
    学生性别：${gender}
    <hr>
    <c:out value="123"></c:out><br>
    <c:out value="${gender}"></c:out>
    <hr>
    <c:if test="${gender == 'man'}">男</c:if><br>

    性别：<input type="radio" name="gender" value="man" <c:if test="${gender == 'man'}">checked</c:if>>男<input type="radio" name="gender" value="women" <c:if test="${gender == 'women'}">checked</c:if>>女

    <hr>
    <c:choose>
        <c:when test="${s1.age == 20}">
            20岁
        </c:when>
        <c:when test="${s1.age == 30}">
            30岁
        </c:when>
        <c:when test="${s1.age == 40}">
            40岁
        </c:when>
        <c:otherwise>
            年龄不正确
        </c:otherwise>
    </c:choose>
    <hr>
    <table>
        <tr>
            <td>序号</td>
            <td>姓名</td>
            <td>年龄</td>
        </tr>
        <c:forEach items="${ss}" var="stu" varStatus="sta">
            <tr>
                <td>${sta.count}</td>
                <td>${stu.name}</td>
                <td>${stu.age}</td>
            </tr>
        </c:forEach>
    </table>

    <hr>
    <c:forTokens items="a,b,c,d" delims="," var="str">
        ${str}=<br>
    </c:forTokens>
</body>
</html>
