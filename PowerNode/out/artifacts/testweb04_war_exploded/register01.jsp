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
</head>
<body>
    账号：<input type="text" name="user" id="user"/><span id="msg" style="color: red"></span>
    <script>
        function createAjax() {
            var ajax = null
            try {
                // 默认创建谷歌的ajax对象
                ajax = new XMLHttpRequest()
            } catch (e) {
                // 微软旧版本浏览器使用这个对象
                ajax = new ActiveXObject("microsoft.xmlhttp")
            }
            return ajax
        }
        document.getElementById("user").onblur = function (ev) {
            var msg = document.getElementById("msg")
            // 判断账号是否为空
            if (this.value = "") {
                msg.innerText = "账号不能为空"
                this.focus()
            } else {
                // 创建ajax对象
                var ajax = createAjax()
                // 打开ajax对象
                var method = "GET"
                var url = "http://localhost:8080/testweb04/checkUserAjax?user=" + this.value
                ajax.open(method, url);
                // 发送ajax对象
                var data = null
                ajax.send(data)
                // 解析响应
                ajax.onreadystatechange = function () {
                    if (ajax.readyState == 4 && ajax.status == 200){
                        var backData = ajax.responseText;
                        msg.innerText = backData;
                    }
                }
            }
        }
    </script>
</body>
</html>
