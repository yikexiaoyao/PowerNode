<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/10/11
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表</title>
    <script>
        function del(id) {
            if (window.confirm("确认删除此员工吗？此操作不可撤回！")) {
                window.location.href = "${pageContext.request.contextPath}/employee/delete?emplId=" + id
            }
        }
    </script>
</head>
<body>
    <a href="${pageContext.request.contextPath}/employee/edit">新增员工</a><br>
    <%--for(Employee e : employeeList){}--%>
    <c:forEach items="${employeeList}" var="e" varStatus="status">
        ${status.count}, ${e.emplName},
        <a href="${pageContext.request.contextPath}/employee/edit?emplId=${e.emplId}">修改</a>,
        <a href="javascript:del(${e.emplId});">删除</a>
        <br/>
    </c:forEach>
</body>
</html>
