<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/10/21
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<span style="color: red">${user.msg}</span>
    <form action="${pageContext.request.contextPath}/saveLogin" method="post">
        用户名：<input name="userName" value="${user.userName}"><br>
        密码：<input name="userPwd" type="password"><br>
        <input id="submitBtn" type="submit" value="登录">
    </form>
</body>
</html>
