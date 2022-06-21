<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/10/21
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <script>
        function del(id) {
            if (window.confirm("确认删除此用户吗？此操作不可撤回！")) {
                window.location.href = "${pageContext.request.contextPath}/user/delete?id=" + id;
            }
        }
        
        $(function () {
            $("#selectAll").click(function () {
                //修改用户的id的复选框的状态为全选复选框的状态
                $("[name=\"ids\"]").prop("checked", this.checked);
            });
            $("#delBatchBtn").click(function () {
                if (window.confirm("确认删除此用户吗？此操作不可撤回！")) {
                    delBatch();
                }
            });
        });

        function delBatch() {
            //判断用户是否至少选择了一项
            if ($("input[name=\"ids\"]:checked").length == 0) {
                alert("请至少选择一项进行操作");
                return;//中断此函数的运行
            }
            $("#userForm").submit();
        }
    </script>
</head>
<body>
    <a href="${pageContext.request.contextPath}/user/edit">新增用户</a>
    <input id="delBatchBtn" type="button" value="批量删除"/>
    <table>
        <thead>
            <tr>
                <th><input id="selectAll" type="checkbox"/>全选/取消</th>
                <th>ID</th>
                <th>用户名</th>
                <th>密码</th>
                <th>操作</th>
            </tr>
            <form id="userForm" action="${pageContext.request.contextPath}/user/delBatch" method="post">
                <c:forEach items="${userList}" var="user" varStatus="status" >
                    <tr>
                        <td><input name="ids" type="checkbox" value="${user.id}"/></td>
                        <td>${status.count}</td>
                        <td>${user.userName}</td>
                        <td>${user.userPwd}</td>
                        <td>
                            <input type="button" value="修改"
                                   onclick="window.location.href='${pageContext.request.contextPath}/user/edit?id=${user.id}'">
                            <a href="javascript:del(${user.id});">删除</a>
                        </td>
                    </tr>
                    <br>
                </c:forEach>
            </form>
        </thead>
    </table>
</body>
</html>