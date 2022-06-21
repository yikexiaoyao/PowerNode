<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/10/21
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
    <script>
        //页面加载完成事件
        $(function () {
            //为用户名绑定change事件
            $("input[name=\"userName\"]").change(function () {
                //1.取到用户名文本框中的值
                var userName = this.value;
                //2.发送ajax请求询问用户是否可以使用（是否被占用）
                $.getJSON("${pageContext.request.contextPath}/ajax/getUser", {"userName": userName}, function (json) {
                    var msgSpan = $("#msg");
                    var msg;
                    var color;
                    if (json.result) {
                        // 可用
                        msg = "用户可用"
                        color = "green"
                    } else {
                        // 不可用
                        msg = "用户不可用"
                        color = "red"
                    }
                    msgSpan.text(msg);
                    msgSpan.css("color", color);
                    //设置按钮是否禁用
                    //如果一个属性只有两种状态的时候，例如：disabled,readonly,checked,selected，jquery的attribute表示它们的初始状态，property表示它们的当前状态
                    $("#submitBtn").prop("disabled", json.result == 0);
                });
            });
            $("#regForm").submit(function () {
                var userName = $("input[name=\"userName\"]").val();
                if (!(userName && userName.length >= 6 && userName.length <= 18)) {
                    alert("用户名格式不正确，用户名的长度介于6-18位之间")
                    return false;
                }
                var pwd = $("input[name=\"userPwd\"]").val();
                if (!(pwd && pwd.length >= 6 && pwd.length <= 18)) {
                    alert("密码格式不正确，用户名的长度介于6-18位之间");
                    return false;
                }
                var rePwd = $("#rePwd").val();
                if (rePwd != pwd) {
                    alert("两次输入的密码不一致");
                    return false;
                }
                return true;
            });
        });
    </script>
</head>
<body>
    <h1>用户注册</h1>
    <form id="regForm" action="${pageContext.request.contextPath}/saveRegister" method="post">
        用户名：<input name="userName"><span id="msg"></span><br>
        密码：<input name="userPwd" type="password"><br>
        确认密码：<input id="rePwd" type="password"><br>
        <input id="submitBtn" type="submit" value="注册">
    </form>
</body>
</html>
