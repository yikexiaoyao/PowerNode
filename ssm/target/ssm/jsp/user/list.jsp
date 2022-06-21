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
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <script>
        function del(id) {
            if (window.confirm("确认删除此用户吗？此操作不可撤回！")) {
                window.location.href = "${pageContext.request.contextPath}/user/delete?userId=" + id
            }
        }

        $(function () {
            $("#selectAll").click(function () {
                //修改用户的id的复选框的状态为全选复选框的状态
                $("[name=\"userIds\"]").prop("checked", this.checked);
            });
            $("#delBatchBtn").click(function () {
                if (window.confirm("确认删除此用户吗？此操作不可撤回！")) {
                    delBatch();
                }
            });
        });

        function delBatch() {
            //判断用户是否至少选择了一项
            if ($("input[name=\"userIds\"]:checked").length == 0) {
                alert("请至少选择一项进行操作");
                return;//中断此函数的运行
            }
            $("#userForm").submit();
        }
    </script>
</head>
<body>
    <a href="${pageContext.request.contextPath}/user/add">新增用户</a>
    <input id="delBatchBtn" type="button" value="批量删除"/>
    <table>
        <thead>
            <tr>
                <th><input id="selectAll" type="checkbox"/>全选/取消</th>
                <th>ID</th>
                <th>用户名</th>
                <th>密码</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>操作</th>
            </tr>
            <form id="userForm" action="${pageContext.request.contextPath}/user/delBatch" method="post"/>
                <c:forEach var="user" items="${userList}" varStatus="status">
                    <tr>
                        <td><input name="userIds" type="checkbox" value="${user.userId}"/></td>
                        <td>${status.count}</td>
                        <td>${user.userName}</td>
                        <td><%--${user.userPwd}--%></td>
                        <td>${user.userRealName}</td>
                        <td>${user.userSex eq 0 ? "男":"女"}</td>
                        <td>${user.userAge}</td>
                        <td>
                            <input type="button" value="修改"
                                   onclick="window.location.href='${pageContext.request.contextPath}/user/edit?userId=${user.userId}'">
                            <a href="javascript:del(${user.userId});">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </form>
        </thead>
    </table>
</body>
</html>
