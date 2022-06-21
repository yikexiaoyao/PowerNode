<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/14
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    账号：<input type="text"><br>
    <jsp:include page="index.jsp">
        <jsp:param name="user" value="admin"/>
        <jsp:param name="pwd" value="123"/>
    </jsp:include>
    密码：<input type="password"><br>
</body>
</html>
