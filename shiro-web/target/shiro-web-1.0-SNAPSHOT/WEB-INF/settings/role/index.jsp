<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
          rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bootstrap_3.3.0/js/bootstrap.min.js"></script>
</head>
<body>

<div>
    <div style="position: relative; left: 30px; top: -10px;">
        <div class="page-header">
            <h3>角色列表</h3>
        </div>
    </div>
</div>

<div class="btn-toolbar" role="toolbar"
     style="background-color: #F7F7F7; height: 50px; position: relative;left: 30px; width: 110%; top: 20px;">
    <div class="btn-group" style="position: relative; top: 18%;">
        <button type="button" onclick="toAdd()" class="btn btn-primary" data-toggle="modal">
            <span class="glyphicon glyphicon-plus"></span> 创建
        </button>
        <button type="button" onclick="toDelete()" class="btn btn-danger">
            <span class="glyphicon glyphicon-minus"></span> 删除
        </button>
    </div>

</div>

<div style="position: relative; left: 30px; top: 40px; width: 110%">
    <table class="table table-hover">
        <thead>
        <tr style="color: #B3B3B3;">
            <td><input id="father" type="checkbox"/></td>
            <td>序号</td>
            <td>角色名称</td>
        </tr>
        </thead>
        <tbody id="roleBody">
        <%--<tr class="active">
            <td><input type="checkbox"/></td>
            <td>1</td>
            <td><a href="${pageContext.request.contextPath}/toView/settings/role/authorize?id=1">管理员</a></td>
        </tr>--%>
        </tbody>
    </table>
</div>

<div style="height: 50px; position: relative;top: 30px;">
    <div id="rolePage"></div>
</div>

<script>
    function refresh() {
        $.get("${pageContext.request.contextPath}/settings/role/list", function (data) {
            var roles = data;
            console.log(roles)
            for (var i = 0; i < roles.length; i++) {
                var role = roles[i];
                $('#roleBody').append("<tr class=\"active\">\n" +
                    "\t\t\t\t\t<td><input class='son' onclick='check()' value=" + role.roleId + " type=\"checkbox\" /></td>\n" +
                    "\t\t\t\t\t<td>" + role.roleId + "</td>\n" +
                    "\t\t\t\t\t<td><a  href=\"${pageContext.request.contextPath}/toView/settings/role/authorize?id=" + role.roleId + "\">" + role.roleName + "</a></td>\n" +
                    "\t\t\t\t</tr>");
            }
        }, 'json')
    }

    refresh();

    // 全选与反选
    $('#father').click(function () {
        $('.son').prop('checked', $(this).prop('checked'));
    })

    //son勾中决定father是否勾中
    /**
     * 动态生成的元素的js会失效
     * 1、事件委托（委托给第一个不是动态生成的父元素）
     * 2、直接给动态生成的元素拼接的时候添加事件
     */
    function check() {
        //获取勾中的son的个数
        var checkedLength = $('.son:checked').length;
        //获取所有son的个数
        var length = $('.son').length;
        if (checkedLength == length) {
            $('#father').prop('checked', true);
        } else {
            $('#father').prop('checked', false);
        }
    }

    // 增加角色
    function toAdd() {
        location.href = "${pageContext.request.contextPath}/settings/role/toAdd";
    }

    // 删除角色
    function toDelete() {
        var son = $(".son:checked")
        if (son.length < 1) {
            alert("请至少选择一个角色进行删除")
        }else{
            if (window.confirm("删除后将无法复原，请问是否继续")) {
                var ids = [];
                //遍历这个元素数组 然后把这个数组内的每个元素的值 添加到我们新定义的变量中
                son.each(function () {
                    if ($(this).val() == 1) {
                        alert("您无法对删除管理员角色")
                        return;
                    }
                    ids.push($(this).val())
                })
                $.get("${pageContext.request.contextPath}/settings/role/toDelete",
                    //把一个数组通过join（）方法 拼接成一个字符窜 传到服务端
                    {'ids': ids.join()},
                    function(data){
                        alert(data.message)
                        window.location.href = '${pageContext.request.contextPath}/toView/settings/role/index';
                    }, 'json')
            }
        }
    }

</script>

</body>
</html>