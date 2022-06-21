<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/18
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
          rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bootstrap_3.3.0/js/bootstrap.min.js"></script>
</head>
<body>

<div id="createUserModal" role="dialog">
    <div class="modal-dialog" role="document" style="width: 90%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">新增用户</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" id="createForm" role="form">

                    <%-- <div class="form-group">
                         <label for="create-loginActNo" class="col-sm-2 control-label">登录帐号<span style="font-size: 15px; color: red;">*</span></label>
                         <div class="col-sm-10" style="width: 300px;">
                             <input type="text" class="form-control" id="create-loginActNo">
                         </div>
                         <label for="create-username" class="col-sm-2 control-label">用户姓名</label>
                         <div class="col-sm-10" style="width: 300px;">
                             <input type="text" class="form-control" id="create-username">
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="create-loginPwd" class="col-sm-2 control-label">登录密码<span style="font-size: 15px; color: red;">*</span></label>
                         <div class="col-sm-10" style="width: 300px;">
                             <input type="password" class="form-control" id="create-loginPwd">
                         </div>
                         <label for="create-confirmPwd" class="col-sm-2 control-label">确认密码<span style="font-size: 15px; color: red;">*</span></label>
                         <div class="col-sm-10" style="width: 300px;">
                             <input type="password" class="form-control" id="create-confirmPwd">
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="create-email" class="col-sm-2 control-label">邮箱</label>
                         <div class="col-sm-10" style="width: 300px;">
                             <input type="text" class="form-control" id="create-email">
                         </div>
                         <label for="create-expireTime" class="col-sm-2 control-label">失效时间</label>
                         <div class="col-sm-10" style="width: 300px;">
                             <input type="text" class="form-control" id="create-expireTime">
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="create-lockStatus" class="col-sm-2 control-label">锁定状态</label>
                         <div class="col-sm-10" style="width: 300px;">
                             <select class="form-control" id="create-lockStatus">
                                 <option></option>
                                 <option>启用</option>
                                 <option>锁定</option>
                             </select>
                         </div>
                         <label for="create-dept" class="col-sm-2 control-label">部门<span style="font-size: 15px; color: red;">*</span></label>
                         <div class="col-sm-10" style="width: 300px;">
                             <select class="form-control" id="create-dept">
                                 <option></option>
                                 <option>市场部</option>
                                 <option>策划部</option>
                             </select>
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="create-allowIps" class="col-sm-2 control-label">允许访问的IP</label>
                         <div class="col-sm-10" style="width: 300px;">
                             <input type="text" class="form-control" id="create-allowIps" style="width: 280%" placeholder="多个用逗号隔开">
                         </div>
                     </div>--%>
                    <div class="form-group">
                        <label for="create-roleId" class="col-sm-2 control-label">序号<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-roleId" name="roleId">
                        </div>
                        <label for="create-roleName" class="col-sm-2 control-label">角色名称<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-roleName" name="roleName">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"
                        onclick="window.location.href='${pageContext.request.contextPath}/toView/settings/role/index'">
                    关闭
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="addRole()">保存</button>
            </div>
        </div>
    </div>
</div>

<script>
    //点击创建按钮，异步查询角色信息
    function addRole() {
        $.get('${pageContext.request.contextPath}/settings/role/addRole',
            {
                'roleId': $('#create-roleId').val(),
                'roleName': $('#create-roleName').val()
            }, function (data) {
                window.location.href = '${pageContext.request.contextPath}/toView/settings/role/index';
        }, 'json');
    }
</script>
</body>
</html>
