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
        <%-- http://localhost:8080/ssm/employee/list --%>
        <a href="${pageContext.request.contextPath}/employee/list">员工管理</a><br>
        <a href="${pageContext.request.contextPath}/user/list">用户管理（增删改查）</a><br>
        <a href="${pageContext.request.contextPath}/user/search">用户管理（展示搜索）</a><br>
        <a href="${pageContext.request.contextPath}/static">静态资源的访问</a><br>
    </c:if>

</body>
</html>
