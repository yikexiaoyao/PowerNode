<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
          rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bootstrap_3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<div style="position: absolute; top: 0px; left: 0px; width: 60%;">
    <img src="${pageContext.request.contextPath}/img/IMG_7114.JPG" style="width: 100%; position: relative; top: 50px;">
</div>
<div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
    <div style="position: absolute; top: 5px; left: 0px; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman'">
        shiro &nbsp;<span style="font-size: 12px;">&copy;2020&nbsp;动力节点</span></div>
</div>
<script>
   /* if (top != this) {
        top.location.href = "${pageContext.request.contextPath}/login.jsp";
    }*/
</script>

<div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
    <div style="position: absolute; top: 0px; right: 60px;">
        <div class="page-header">
            <h1>登录</h1>
        </div>
        <form action="${pageContext.request.contextPath}/user/login" class="form-horizontal" method="post" role="form">
            <div class="form-group form-group-lg">
                <div style="width: 350px;">
                    <input class="form-control" name="username" id="loginAct" autofocus type="text" placeholder="用户名">
                </div>
                <div style="width: 350px; position: relative;top: 20px;">
                    <input class="form-control" name="password" id="loginPwd" type="password" placeholder="密码">
                </div>
                <div class="checkbox" style="position: relative;top: 30px; left: 10px;">

                    <span id="msg" style="color: red">${message}</span>

                </div>
                <input type="submit" class="btn btn-primary btn-lg btn-block" id="loginBtn"
                       style="width: 350px; position: relative;top: 45px;" value="登录">
                </input>
            </div>
        </form>
    </div>

</div>

<script src="${pageContext.request.contextPath}/layer/layer.js"></script>
<script>

</script>
</body>
</html>