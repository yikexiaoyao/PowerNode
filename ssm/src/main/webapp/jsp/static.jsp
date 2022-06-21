<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/10/14
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>静态资源的访问</title>
  <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"/>
  <script>
    $(function () {
      alert("jquery已生效")
    })
  </script>
</head>
<body>
  <div id="div">
    这是div的内容
  </div>
  <img src="${pageContext.request.contextPath}/imgs/logo.jpg">
</body>
</html>
