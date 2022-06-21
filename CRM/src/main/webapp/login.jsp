<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/10/23
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
</head>
<body>
    <div style="position: absolute; top: 0px; left: 0px; width: 60%;">
        <img src="${pageContext.request.contextPath}/img/IMG_7114.JPG" style="width: 100%; position: relative; top: 50px;">
    </div>
    <div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
        <div style="position: absolute; top: 5px; left: 15px; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman'">CRM &nbsp;<span style="font-size: 12px;">&copy;2020&nbsp;动力节点</span></div>
    </div>
    <div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
        <div style="position: absolute; top: 0px; right: 60px;">
            <div class="page-header">
                <h1>登录</h1>
            </div>
            <form class="form-horizontal" role="form">
                <div class="form-group form-group-lg">
                    <div style="width: 350px;">
                        <input class="form-control" id="loginAct" type="text" placeholder="用户名">
                    </div>
                    <div style="width: 350px; position: relative;top: 20px;">
                        <input class="form-control" id="loginPwd" type="password" placeholder="密码">
                    </div>
                    <div style="width: 350px; position: relative;top: 40px;">
                        <input class="form-control" style="width: 200px;" id="img" type="text" placeholder="验证码">
                        <img id="code" src="${pageContext.request.contextPath}/settings/user/code" style="position: absolute;right: 0;top:0;cursor:pointer" />
                    </div>
                    <div class="checkbox"  style="position: relative;top: 30px; left: 10px;">
                        <span id="msg"></span>
                    </div>
                    <button type="button" class="btn btn-primary btn-lg btn-block" id="loginBtn"  style="width: 350px; position: relative;top: 45px;">登录</button>
                </div>
            </form>
        </div>
    </div>
    <script>
        // 点击换验证码
        $('#code').click(function() {
            $(this).prop("src", "${pageContext.request.contextPath}/settings/user/code?date=" + new Date());
        });
        // 触发回车键登录
        $('body').keypress(function (event) {
            if (event.keyCode == 13) {
                $.post("${pageContext.request.contextPath}/settings/user/login", {
                    'loginAct': $('#loginAct').val(),
                    'loginPwd': $('#loginPwd').val(),
                    'code': $('#img').val()
                }, function (data) {
                    if (!data.ok) {
                        layer.alert(data.message, {'icon': 5});
                    } else {
                        layer.alert(data.message, {'icon': 6});
                        // 跳转到后台首页
                        location.href = "${pageContext.request.contextPath}/settings/user/toIndex";
                    }
                }, 'json')
            }
        });
        // 点击登录
        $('#loginBtn').click(function () {
            $.post("${pageContext.request.contextPath}/settings/user/login", {
                'loginAct': $('#loginAct').val(),
                'loginPwd': $('#loginPwd').val(),
                'code': $('#img').val()
            }, function (data) {
                if (!data.ok) {
                    layer.alert(data.message, {'icon': 5});
                } else {
                    layer.alert(data.message, {'icon': 6});
                    // 跳转到后台首页
                    location.href = "${pageContext.request.contextPath}/settings/user/toIndex";
                }
            }, 'json');
        });
    </script>
</body>
</html>
