<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/15
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>你好，萌新</title>
</head>
<body>
    <form id="registerForm" method="post" action="user">
        账号：<input type="text" id="user" name="user" placeholder="请输入账号"><br>
        密码：<input type="password" id="pwd" name="pwd" placeholder="请输入密码"><br>
        再次输入密码：<input type="password" id="repwd" placeholder="请再次输入密码"><br>
        <span id="msg" style="color: red">${msg}</span><br>
        <input type="hidden" name="method" value="register">
        <input type="submit" value="注册">
    </form>
    <script>
        // 账号失去焦点验证账号不能为空
        document.getElementById("user").onblur = function (ev) {
            if (this.value == "") {
                document.getElementById("msg").innerText = "账号不能为空"
                this.focus()
            }
        }
        // 密码失去焦点验证密码不能为空
        document.getElementById("pwd").onblur = function (ev) {
            if (this.value == "") {
                document.getElementById("msg").innerText = "密码不能为空"
                this.focus()
            }
        }
        // 再次输入密码失去焦点验证再次输入密码不能为空
        document.getElementById("repwd").onblur = function (ev) {
            if (this.value == "") {
                document.getElementById("msg").innerText = "再次输入密码不能为空"
                this.focus()
            } else if (this.value != document.getElementById("pwd").value) {
                document.getElementById("msg").innerText = "两次输入密码必须一致"
                this.focus()
            }
        }
        // 对表单进行提交验证
        document.getElementById("registerForm").onsubmit = function (ev) {
            // 账号不能为空
            if (document.getElementById("user" == "").value == null) {
                document.getElementById("msg").innerText = "账号不能为空|"
                document.getElementById("user").focus()
                return false
            }
            // 密码不能为空
            if (document.getElementById("pwd" == "").value == null) {
                document.getElementById("msg").innerText = "密码不能为空|"
                document.getElementById("pwd").focus()
                return false
            }
            // 再次输入密码不能为空
            if (document.getElementById("repwd" == "").value == null) {
                document.getElementById("msg").innerText = "再次输入密码不能为空|"
                document.getElementById("repwd").focus()
                return false
            }
            return true
        }
    </script>
</body>
</html>
