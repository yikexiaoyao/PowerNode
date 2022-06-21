<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/10/12
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
    <script>
        function del(id) {
            if (window.confirm("确认删除此用户吗？此操作不可撤回！")) {
                window.location.href = "${pageContext.request.contextPath}/user/delete?userId=" + id
            }
        }
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/search" method="post">
        用户名：<input name="userName" value="${param.userName}"><br>
        姓名：<input name="userRealName" value="${param.userRealName}"><br>
        性别：<input type="radio" name="userSex" value="" ? ${empty param.userSex ? "checked='checked'" : ""}>不限
            <input type="radio" name="userSex" value="0" ? ${param.userSex != "" and param.userSex eq 0 ? "checked='checked'" : ""}>男
            <input type="radio" name="userSex" value="1" ? ${param.userSex != "" and param.userSex eq 1 ? "checked='checked'" : ""}>女
            <br>
        年龄：从<input name="userAgeBegin" value="${param.userAgeBegin}"><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            到<input name="userAgeEnd" value="${param.userAgeEnd}"><br>
        <input type="submit" value="搜索"/>
    </form>
    <a href="${pageContext.request.contextPath}/user/add">新增用户</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>密码</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>操作</th>
            </tr>
        <c:forEach var="user" items="${userList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${user.userName}</td>
                <td><%--${user.userPwd}--%></td>
                <td>${user.userRealName}</td>
                <td>${user.userSex eq 0 ? "男":"女"}</td>
                <td>${user.userAge}</td>
                <td>
                    <input type="button" value="修改" onclick="window.location.href='${pageContext.request.contextPath}/user/edit?userId=${user.userId}'">
                    <a href="javascript:del(${user.userId});">删除</a>
                </td>
            </tr>
        </c:forEach>
        </thead>
    </table>
</body>
</html>
