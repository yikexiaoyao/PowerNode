<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/10/12
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/saveUpdate" method="post">
        <input type="hidden" name="userId" value="${user.userId}" />
        用户名：<input name="userName" value="${user.userName}"><br>
        <%--密码：<input type="password" name="userPwd" value="${user.userPwd}"><br>--%>
        真实姓名：<input name="userRealName" value="${user.userRealName}"><br>
        性别：<input type="radio" value="0" name="userSex" ${user.userSex eq 0 ? "checked='checked'" : ""} />男
            <input type="radio" value="1" name="userSex" ${user.userSex eq 1 ? "checked='checked'" : ""} />女<br>
        年龄：<input name="userAge" value="${user.userAge}"><br>
        <input type="submit" value="保存">
    </form>
</body>
</html>
