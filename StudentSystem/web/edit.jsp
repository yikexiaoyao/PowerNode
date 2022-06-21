<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/16
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改学生信息</title>
</head>
<body>
    <form id="addForm" action="student" method="post"><br>
        姓名：<input type="text" name="name" value="${student.name}"><br>
        年龄：<input type="text" name="age" value="${student.age}"><br>
        性别：<input type="radio" name="gender" value="1" <c:if test="${student.gender == '1'}">checked</c:if>>男
        <input type="radio" name="gender" value="0" <c:if test="${student.gender == '0'}">checked</c:if>>女<br>
        地址：<input type="text" name="address" value="${student.address}"><br>
        备注：<input type="text" name="remark" value="${student.remark}"><br>
        <span id="msg" style="color: red">${msg}</span><br>
        <input type="hidden" name="method" value="edit">
        <input type="hidden" name="id" value="${student.id}">
        <input type="submit" value="保存">
    </form>
</body>
</html>
