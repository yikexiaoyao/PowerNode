<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/9/14
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        out.write("hello");
        String hello = "hello";
    %>
    <%="hello"%>
    <%
        //向pageContext域对象中添加属性
        pageContext.setAttribute("user", "admin");
        //向指定域对象中添加属性
        pageContext.setAttribute("pwd", "123", PageContext.SESSION_SCOPE);
    %>
    <%=pageContext.getAttribute("user")%><br>
    <%=session.getAttribute("pwd")%><br>
    <%=pageContext.getAttribute("pwd", PageContext.SESSION_SCOPE)%><br>
    <%--使用pageContext简便方式获取域对象中的属性,不用指定域对象，会默认按照从小到大的顺序从4个域对象中挨个查询，找到后停止查询--%>
    <%=pageContext.findAttribute("pwd")%>
</body>
</html>
