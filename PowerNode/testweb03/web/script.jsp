<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/14
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        1. java脚本
           语法：<%脚本%>
           注意：
               1.脚本可以写多个
               2.脚本中声明的变量是局部变量
               3.脚本中不能声明方法，但是可以调用方法

        2. 输出表达式
           语法：<%=表达式%>
           注意：
               1.表达式可以是变量，字符串，算数表达式等等
               2.表达式后面不要写;

        3. java的声明
           语法：<%!声明代码%>
           作用：声明成员变量和成员方法
    --%>

    <%
        String name = "admin";
    %>
    <%
        if (name.equals("admin")) {
            out.write("输出正确");
        } else {
            out.write("输出错误");
        }
    %>
    <br>
    <%=1+1%><br>
    <%="hello"%><br>
    <%=name%><br>
    <%!
        private int age = 20;
        private String gender = "man";
    %>
    <%!
        public void setAge() {
            this.age = age;
        }
        public int getAge() {
            return this.age;
        }
    %>
</body>
</html>
