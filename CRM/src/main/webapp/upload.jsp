<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/10/25
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传头像</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data">
        上传头像：<input type="file" name="img"><br>
        上传头像：<input type="file" name="img"><br>
        上传头像：<input type="file" name="img"><br>
        <button>上传头像</button>
    </form>
</body>
</html>
