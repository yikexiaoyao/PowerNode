<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/11/27
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap_3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    点我登录
</button>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">欢迎登录</h4>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/user/login" method="post">
                    <div class="form-group">
                        <label for="exampleInputEmail1">用户名</label>
                        <input type="text" class="form-control" name="username" autofocus id="exampleInputEmail1" placeholder="请输入用户名">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">密码</label>
                        <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="请输入密码">
                    </div>
                    <button type="submit" style="width: 100%" class="btn btn-lg btn-primary">点我登录</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
