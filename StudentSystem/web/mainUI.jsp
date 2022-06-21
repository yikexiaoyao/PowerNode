<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/15
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息管理</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        table {
            width: 600px;
            border: 1px solid black;
            margin: 100px auto;
        }
        td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td colspan="6">
                <form action="student" method="post">
                    姓名：<input type="text" name="username" value="${username}">
                    年龄：<input type="text" name="sage" value="${sage}">
                    <input type="hidden" name="method" value="mainUI">
                    <input type="hidden" id="no" name="no" value="1">
                    <input type="submit" value="查询">
                </form>
            </td>
            <td>
                <button id="btn-add">添加学生</button>
                <button id="btn-logout">登出</button>
            </td>
        </tr>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>地址</td>
            <td>备注</td>
            <td>操作</td>
        </tr>
        <c:forEach var="student" items="${page.list}" varStatus="status">
            <tr <c:if test="${sta.count % 2 == 1}">style="background-color: aliceblue;"</c:if>>
                <td>${status.count}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>
                    <c:if test="${student.gender == '1'}">男</c:if>
                    <c:if test="${student.gender == '0'}">女</c:if>
                </td>
                <td>${student.address}</td>
                <td>${student.remark}</td>
                <td>
                    <a href="http://localhost:8080/StudentSystem/student?method=editUI&id=${student.id}">修改</a>
                    &nbsp;&nbsp;
                    <a href="http://localhost:8080/StudentSystem/student?method=delete&id=${student.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="7">
                总记录数${page.totalRecords}
                &nbsp;&nbsp;&nbsp;
                总页数${page.totalPages}
                &nbsp;&nbsp;&nbsp;
                每页显示记录数${page.pageSize}
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:goPage(1)">首页</a>
                &nbsp;&nbsp;&nbsp;
                <c:if test="${page.currentPage > 1}">
                    <a href="javascript:goPage(${page.currentPage - 1})">上一页</a>
                </c:if>
                &nbsp;&nbsp;&nbsp;
                当前页${page.currentPage}
                &nbsp;&nbsp;&nbsp;
                <c:if test="${page.currentPage < page.totalPages}">
                    <a href="javascript:goPage(${page.currentPage + 1})">下一页</a>
                </c:if>
                &nbsp;&nbsp;&nbsp;
                <a href="javascript:goPage(${page.totalPages})">末页</a>
            </td>
        </tr>
    </table>
<script>
    document.getElementById("btn-add").onclick = function (ev) {
        window.location.href = "http://localhost:8080/StudentSystem/student?method=addUI"
    }
    document.getElementById("btn-logout").onclick = function (ev) {
        window.location.href = "http://localhost:8080/StudentSystem/student?method=logout"
    }
    function goPage(no) {
        // 修改表单中当前页码的值
        document.getElementById("no").value = no
        // 提交表单实现查询并翻页
        document.getElementsByTagName("form")[0].submit()
    }
</script>
</body>
</html>
