<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/zTree_v3/css/zTreeStyle/zTreeStyle.css" />
    <link href="${pageContext.request.contextPath}/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/zTree_v3/js/jquery.ztree.all.min.js"></script>
</head>
<body>
<button class="btn btn-success" onclick="authrize()">点我授权</button>
<hr />
<ul id="treeDemo" class="ztree"></ul>
<script>
    let treeObj;
    $.get("${pageContext.request.contextPath}/settings/role/queryPermissionTrees",{'id':'${id}'},function (data) {
        let setting = {
            check: {
                enable: true,
                chkStyle: 'checkbox'
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };

        let zNodes =data;

        //init:初始化一个ztree对象 参数1:tree容器 setting:设置树的样式 zNodes:
        treeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);

    },'json');

    function authrize() {
        var nodes = treeObj.getCheckedNodes(true);
        var ids = [];
        for(var i = 0; i < nodes.length; i++){
            ids.push(nodes[i].id);
        }
        $.post("${pageContext.request.contextPath}/settings/role/authorize",{
            'ids' : ids.join(),
            'id' : '${id}'
        },function (data) {
            alert(data);
        },'json');
    }
</script>
</body>
</html>
