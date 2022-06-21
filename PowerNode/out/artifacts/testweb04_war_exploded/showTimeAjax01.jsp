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
</head>
<body>
    <span id="showTime"></span><button id="btn">获取服务器时间</button>
    <script>
        function createAjax() {
            var ajax = null
            try {
                // 默认创建谷歌ajax对象
                ajax = new XMLHttpRequest()
            } catch (e) {
                // 微软旧版本浏览器使用对象
                ajax = new ActiveXObject("microsoft.xmlhttp")
            }
            return ajax
        }
        document.getElementById("btn").onclick = function (ev) {
            // 创建ajax对象
            var ajax = createAjax()
            // 打开ajax对象
            var method = "GET"
            var url = "http://localhost:8080/testweb04/showTimeAjax"
            ajax.open(method, url)
            // 发送ajax请求
            // data表示请求参数，只有post请求才在这个方法中传入请求参数
            // 请求参数的格式：key1=value&key2=value2.....
            var data = null
            ajax.send(data)
            // -------------上面代码执行完毕后，表示请求已经发送，等待响应的返回，下面的代码将在响应返回后执行---------------
            // 监控ajax对象的状态，如果状态是4的话，表示响应返回
            ajax.onreadystatechange = function () {
                // 只有ajax对象的状态为4的时候，我们才需要解析响应
                if (ajax.readyState == 4) {
                    // 只有响应状态码是正常的情况下我们再解析响应
                    if (ajax.status == 200) {
                        var  backdata = ajax.responseText
                        document.getElementById("showTime").innerText = backdata
                    }
                }
            }
        }
    </script>
</body>
</html>
