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
</head>
<body>
  <form action="student" id="editForm" method="post">
    姓名：<input type="text" name="sname"><span id="msg" style="color: red">${msg}</span><br>
    年龄：<input type="text" name="age"><br>
    性别：<input type="radio" name="gender" value="1">男<input type="radio" name="gender" value="0">女<br>
    地址：<input type="text" name="address"><br>
    备注：<input type="text" name="remark"><br>
    <input type="hidden" name="method" value="edit">
    <input type="submit" value="保存">
  </form>

  <script>
    function createAjax(){
      var ajax = null;
      try {
        // 默认创建谷歌的ajax对象
        ajax = new XMLHttpRequest();
      }catch (e) {
        // 微软旧版本浏览器使用这个对象
        ajax = new ActiveXObject("microsoft.xmlhttp");
      }
      return ajax;
    }

    window.onload = function (ev) {
      // 创建ajax对象
      var ajax = createAjax();
      // 打开ajax对象
      var method = "GET";
      var url = "http://localhost:8080/testweb04/getStudentById?id=1";
      ajax.open(method,url);
      // 发送ajax请求
      ajax.send(null);

      // 解析响应
      ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200){
          var backData = ajax.responseText;
          // 上面接收的数据只是json字符串，如果想按照对象的形式操作，需要将字符串格式化成对象
          var student = eval('(' + backData + ')');
          document.getElementsByName("sname")[0].value = student.sname;
          document.getElementsByName("age")[0].value = student.age;
          document.getElementsByName("address")[0].value = student.address;
          document.getElementsByName("remark")[0].value = student.remark;
          if (student.gender == '1'){
            document.getElementsByName("gender")[0].setAttribute("checked","checked");
          }
          if (student.gender == '0'){
            document.getElementsByName("gender")[1].setAttribute("checked","checked");
          }
        }
      }
    }
  </script>
</body>
</html>
