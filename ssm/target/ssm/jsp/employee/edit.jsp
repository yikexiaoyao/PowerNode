<%--
  Created by IntelliJ IDEA.
  User: cty
  Date: 2021/10/13
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>${not empty employee.emplId  ? "修改":"新增" }员工</title>
</head>
<body>
    <f:form action="save" modelAttribute="employee">
        <f:hidden path="emplId"></f:hidden>
        员工姓名：<f:input path="emplName"/><br/>
        员工年龄：<f:input path="emplAge"/><br/>
        员工性别：<f:radiobutton path="emplSex" value="0"/>男
                <f:radiobutton path="emplSex" value="1"/>女<br/>
        员工电话：<f:input path="emplPhone"/><br/>
        <input type="submit"/>
    </f:form>
</body>
</html>
