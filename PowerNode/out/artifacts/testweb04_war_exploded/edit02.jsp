<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/23
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
</head>
<body>
<form action="student" id="editForm" method="post">
  姓名：<input type="text" name="sname" id="sname"><span id="msg" style="color: red">${msg}</span><br>
  年龄：<input type="text" name="age" id="age"><br>
  性别：<input type="radio" name="gender" id="man" value="1">男<input type="radio" name="gender" id="women" value="0">女<br>
  地址：<input type="text" name="address" id="address"><br>
  备注：<input type="text" name="remark" id="remark"><br>
  <input type="hidden" name="method" value="edit">
  <input type="submit" value="保存">
</form>

  <script>
    // 页面加载完成后，使用ready函数加载用户信息
    $(function () {
      var url = "http://localhost:8080/testweb04/getStudentById";
      var data = "id=1";
      $.get(url,data,function (student) {
        // 填充页面元素
        $("#sname").val(student.sname);
        $("#age").val(student.age);
        $("#address").val(student.address);
        $("#remark").val(student.remark);
        if (student.gender == '1'){
          $("#man").attr("checked","checked");
        }
        if (student.gender == '0'){
          $("#women").attr("checked","checked");
        }
      },"json");

      $("#editForm").submit(function () {
        // serialize调用者必须是表单元素
        var sendData = $("#editForm").serialize();
        console.log(sendData)
        return false;
      });
    })

  </script>
</body>
</html>
