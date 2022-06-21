<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/15
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎回来</title>
</head>
<body>
    <form id="loginForm" method="post" action="user">
        账号：<input type="text" id="user" name="user" placeholder="请输入账号"><br>
        密码：<input type="password" id="pwd" name="pwd" placeholder="请输入密码"><br>
        <span id="msg" style="color: red">${msg}</span><br>
        <input type="hidden" name="method" value="login">
        <input type="submit" value="登录">
    </form>
</body>
</html>
