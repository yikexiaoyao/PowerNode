<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="enity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/14
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        el表达式：Expression Language表达式语言
        语法：${表达式}
        作用：取代jsp输出表达式  <%=表达式%>
        使用场景：从4个域对象中获取数据
    --%>
    <%
        request.setAttribute("user", "zhangsan");
        session.setAttribute("gender", "man");
        String[] names = {"张三", "李四"};
        session.setAttribute("names", names);

        Map<String, String> student = new HashMap<>();
        student.put("name", "王五");
        student.put("age", "20");

        session.setAttribute("student", student);

        Student s1 = new Student();
        s1.setName("admin");
        s1.setAge(30);

        Student s2 = new Student();
        s2.setName("tomcat");
        s2.setAge(10);

        List<Student> ss = new ArrayList<>();
        ss.add(s1);
        ss.add(s2);

        session.setAttribute("ss", ss);
        session.setAttribute("s1", s1);
    %>
    ${10+10}<br>
    ${"hello"}<br>
    ${requestScope.user}<br>
    ${sessionScope.gender}<br>
    ${user}<br>
    ${gender}<br>
    第一个名字：${names[0]}
    第二个名字：${names[1]}
    姓名：${student.name}<br>
    年龄：${student.gender}<br>
    姓名：${s1.name}<br>
    年龄：${s1.gender}<br>
    <hr>
    第一个名字：${ss[0].name}<br>
    第二个名字：${ss[1].name}<br>
    <hr>
    姓名：<input type="text" value="${ss[0].name}">
</body>
</html>
