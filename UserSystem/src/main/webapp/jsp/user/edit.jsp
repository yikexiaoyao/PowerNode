<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/10/21
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>${not empty user.id  ? "修改":"新增" }员工</title>
</head>
<body>
    <f:form action="save" modelAttribute="user">
        <f:hidden path="id"></f:hidden>
        用户名：<f:input path="userName"/><br/>
        密码：<f:input path="userPwd"/><br/>
        <input type="submit"/>
    </f:form>
</body>
</html>
