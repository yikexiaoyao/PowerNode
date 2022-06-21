<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/18
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
</head>
<body>
    <span id="showtime"></span><button id="btn">获取服务器时间</button>

    <script>

        $("#btn").click(function () {
            // 定义url
            var url = "http://localhost:8080/testweb04/showTimeAjax";
            // 发送请求并将返回的字符串直接填充到span中
            $("#showtime").load(url);
        });
    </script>
</body>
</html>
