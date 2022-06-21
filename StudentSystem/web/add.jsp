<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/16
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
</head>
<body>
    <form id="addForm" action="student" method="post"><br>
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        性别：<input type="radio" name="gender" value="1">男
        <input type="radio" name="gender" value="0">女<br>
        地址：<input type="text" name="address"><br>
        备注：<input type="text" name="remark"><br>
        <span id="msg" style="color: red">${msg}</span><br>
        <input type="hidden" name="method" value="add">
        <input type="hidden" name="id" value="${student.id}">
        <input type="submit" value="保存">
    </form>
</body>
</html>
