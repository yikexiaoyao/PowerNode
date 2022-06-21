<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%--仅游客可见--%>
    <c:if test="${empty LoginUser}">
        <a href="${pageContext.request.contextPath}/login">登录</a><br>
        <a href="${pageContext.request.contextPath}/register">注册</a><br>
    </c:if>
    <%--仅登录可见--%>
    <c:if test="${not empty LoginUser}">
        <h1>欢迎${LoginUser.userName}来到王者峡谷!</h1>
        <a href="${pageContext.request.contextPath}/logout">退出</a><br>
        <%-- http://localhost:8080/usersys/user/list --%>
        <a href="${pageContext.request.contextPath}/user/list">用户管理</a><br>
    </c:if>
</body>
</html>
