<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/10/12
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/save" method="post">
        用户名：<input name="userName"><br>
        密码：<input type="password" name="userPwd"><br>
        真实姓名：<input name="userRealName"><br>
        性别：<input type="radio" value="0" name="userSex">男
            <input type="radio" value="1" name="userSex">女<br>
        年龄：<input name="userAge"><br>
        <input type="submit" value="保存">
    </form>
</body>
</html>
