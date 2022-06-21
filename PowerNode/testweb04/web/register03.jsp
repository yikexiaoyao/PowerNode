<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/23
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
</head>
<body>
    账号：<input type="text" name="user" id="user"><span id="msg" style="color: red"></span>

    <script>

        // 给输入框添加失去焦点事件
        $("#user").blur(function () {
            // 判断输入值是否是空
            if (this.value == ""){
                // 输入框获取焦点
                this.focus();
                // 提示信息
                $("#msg").html("账号不能为空！");
            }else {
                // 发送get请求
                var url = "http://localhost:8080/testweb04/checkUserAjax";
                // var data = {"user": this.value};
                var data = "user="+this.value;
                $.get(url,data,function (backData,textStatus,ajax) {
                    if (textStatus == "success"){
                        $("#msg").html(backData);
                    }
                });
            }
        });
    </script>
</body>
</html>
