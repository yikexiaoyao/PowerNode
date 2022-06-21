<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <link href="${pageContext.request.contextPath}/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
          rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bootstrap_3.3.0/js/bootstrap.min.js"></script>

    <script type="text/javascript">

        //默认情况下取消和保存按钮是隐藏的
        var cancelAndSaveBtnDefault = true;

        $(function () {
            $("#remark").focus(function () {
                if (cancelAndSaveBtnDefault) {
                    //设置remarkDiv的高度为130px
                    $("#remarkDiv").css("height", "130px");
                    //显示
                    $("#cancelAndSaveBtn").show("2000");
                    cancelAndSaveBtnDefault = false;
                }
            });

            $("#cancelBtn").click(function () {
                //显示
                $("#cancelAndSaveBtn").hide();
                //设置remarkDiv的高度为130px
                $("#remarkDiv").css("height", "90px");
                cancelAndSaveBtnDefault = true;
            });

            $(".remarkDiv").mouseover(function () {
                $(this).children("div").children("div").show();
            });

            $(".remarkDiv").mouseout(function () {
                $(this).children("div").children("div").hide();
            });

            $(".myHref").mouseover(function () {
                $(this).children("span").css("color", "red");
            });

            $(".myHref").mouseout(function () {
                $(this).children("span").css("color", "#E6E6E6");
            });
        });

    </script>

</head>
<body>

<!-- 修改市场活动备注的模态窗口 -->
<div class="modal fade" id="editRemarkModal" role="dialog">
    <%-- 备注的id --%>
    <input type="hidden" id="remarkId">
    <div class="modal-dialog" role="document" style="width: 40%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">修改备注</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form">
                    <input type="hidden" id="id">
                    <div class="form-group">
                        <label for="edit-describe" class="col-sm-2 control-label">内容</label>
                        <div class="col-sm-10" style="width: 81%;">
                            <textarea class="form-control" rows="3" id="noteContent"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="updateRemarkBtn">更新</button>
            </div>
        </div>
    </div>
</div>

<!-- 修改市场活动的模态窗口 -->
<div class="modal fade" id="editActivityModal" role="dialog">
    <div class="modal-dialog" role="document" style="width: 85%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel1">修改市场活动</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" role="form">

                    <div class="form-group">
                        <label for="edit-owner" class="col-sm-2 control-label">所有者<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <select class="form-control" id="edit-owner">
                                <option id="edit-owner1"></option>
                            </select>
                        </div>
                        <label for="edit-name" class="col-sm-2 control-label">名称<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-startTime" class="col-sm-2 control-label">开始日期</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-startTime">
                        </div>
                        <label for="edit-endTime" class="col-sm-2 control-label">结束日期</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-endTime">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-cost" class="col-sm-2 control-label">成本</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-cost">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-describe" class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-10" style="width: 81%;">
                            <textarea class="form-control" rows="3" id="edit-describe"></textarea>
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="updateBtn">更新</button>
            </div>
        </div>
    </div>
</div>

<!-- 返回按钮 -->
<div style="position: relative; top: 35px; left: 10px;">
    <a href="javascript:void(0);" onclick="window.history.back();"><span class="glyphicon glyphicon-arrow-left"
                                                                         style="font-size: 20px; color: #DDDDDD"></span></a>
</div>

<!-- 大标题 -->
<div style="position: relative; left: 40px; top: -30px;">
    <div class="page-header">
        <h3>市场活动-发传单 <small>2020-10-10 ~ 2020-10-20</small></h3>
    </div>
    <div style="position: relative; height: 50px; width: 250px;  top: -72px; left: 700px;">
        <button type="button" class="btn btn-default" data-toggle="modal" onclick="editBtn()"><span
                class="glyphicon glyphicon-edit"></span> 编辑
        </button>
        <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-minus"></span> 删除</button>
    </div>
</div>

<!-- 详细信息 -->
<div style="position: relative; top: -70px;">
    <div style="position: relative; left: 40px; height: 30px;">
        <div style="width: 300px; color: gray;">所有者</div>
        <div style="width: 300px;position: relative; left: 200px; top: -20px;"><b id="owner"></b></div>
        <div style="width: 300px;position: relative; left: 450px; top: -40px; color: gray;">名称</div>
        <div style="width: 300px;position: relative; left: 650px; top: -60px;"><b id="name"></b></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px;"></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px; left: 450px;"></div>
    </div>

    <div style="position: relative; left: 40px; height: 30px; top: 10px;">
        <div style="width: 300px; color: gray;">开始日期</div>
        <div style="width: 300px;position: relative; left: 200px; top: -20px;"><b id="startTime"></b></div>
        <div style="width: 300px;position: relative; left: 450px; top: -40px; color: gray;">结束日期</div>
        <div style="width: 300px;position: relative; left: 650px; top: -60px;"><b id="endTime"></b></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px;"></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px; left: 450px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 20px;">
        <div style="width: 300px; color: gray;">成本</div>
        <div style="width: 300px;position: relative; left: 200px; top: -20px;"><b id="cost"></b></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -20px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 30px;">
        <div style="width: 300px; color: gray;">创建者</div>
        <div style="width: 500px;position: relative; left: 200px; top: -20px;"><b id="createBy"></b><small
                style="font-size: 10px; color: gray;" id="createTime"></small></div>
        <div style="height: 1px; width: 550px; background: #D5D5D5; position: relative; top: -20px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 40px;">
        <div style="width: 300px; color: gray;">修改者</div>
        <div style="width: 500px;position: relative; left: 200px; top: -20px;"><b id="editBy"></b><small
                style="font-size: 10px; color: gray;" id="editTime"></small></div>
        <div style="height: 1px; width: 550px; background: #D5D5D5; position: relative; top: -20px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 50px;">
        <div style="width: 300px; color: gray;">描述</div>
        <div style="width: 630px;position: relative; left: 200px; top: -20px;"><b id="describe"></b></div>
        <div style="height: 1px; width: 850px; background: #D5D5D5; position: relative; top: -20px;"></div>
    </div>
</div>

<!-- 备注 -->
<div style="position: relative; top: 30px; left: 40px;">
    <div class="page-header">
        <h4>备注</h4>
    </div>

    <!-- 备注1 -->
    <%--<div class="remarkDiv" style="height: 60px;">
        <img title="zhangsan" src="../../image/user-thumbnail.png" style="width: 30px; height:30px;">
        <div style="position: relative; top: -40px; left: 40px;" >
            <h5>哎呦！</h5>
            <font color="gray">市场活动</font> <font color="gray">-</font> <b>发传单</b> <small style="color: gray;"> 2017-01-22 10:10:10 由zhangsan</small>
            <div style="position: relative; left: 500px; top: -30px; height: 30px; width: 100px; display: none;">
                <a class="myHref" href="javascript:void(0);"><span class="glyphicon glyphicon-edit" style="font-size: 20px; color: #E6E6E6;"></span></a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a class="myHref" href="javascript:void(0);"><span class="glyphicon glyphicon-remove" style="font-size: 20px; color: #E6E6E6;"></span></a>
            </div>
        </div>
    </div>--%>

    <div id="remarkDiv" style="background-color: #E6E6E6; width: 870px; height: 90px;">
        <form role="form" style="position: relative;top: 10px; left: 10px;">
            <textarea id="remark" class="form-control" style="width: 850px; resize : none;" rows="2"
                      placeholder="添加备注..."></textarea>
            <p id="cancelAndSaveBtn" style="position: relative;left: 737px; top: 10px; display: none;">
                <button id="cancelBtn" type="button" class="btn btn-default">取消</button>
                <button type="button" class="btn btn-primary" onclick="saveRemark()">保存</button>
            </p>
        </form>
    </div>
</div>
<div style="height: 200px;"></div>
<script>
    //伪脚本
    //刷新备注
    function refresh(activityRemark) {
        $('#remarkDiv').before("<div class=\"remarkDiv\" id=" + activityRemark.id + " style=\"height: 60px;\">\n" +
            "\t\t\t<img title=\"zhangsan\" src=" + activityRemark.img + " style=\"width: 30px; height:30px;\">\n" +
            "\t\t\t<div style=\"position: relative; top: -40px; left: 40px;\" >\n" +
            "\t\t\t\t<h5 id=h5" + activityRemark.id + ">" + activityRemark.noteContent + "</h5>\n" +
            "\t\t\t\t<font color=\"gray\">市场活动</font> <font color=\"gray\">-</font> <b>" + activityRemark.activityId + "</b> <small style=\"color: gray;\"> " + activityRemark.createTime + " 由" + activityRemark.createBy + "</small>\n" +
            "\t\t\t\t<div style=\"position: relative; left: 500px; top: -30px; height: 30px; width: 100px; display: none;\">\n" +
            "\t\t\t\t\t<a class=\"myHref\" onclick=\"openEditRemarkModal('" + activityRemark.id + "','" + activityRemark.noteContent + "')\" href=\"javascript:void(0);\"><span class=\"glyphicon glyphicon-edit\" style=\"font-size: 20px; color: #E6E6E6;\"></span></a>\n" +
            "\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n" +
            "\t\t\t\t\t<a class=\"myHref\" onclick=\"deleteRemark('" + activityRemark.id + "')\" href=\"javascript:void(0);\"><span class=\"glyphicon glyphicon-remove\" style=\"font-size: 20px; color: #E6E6E6;\"></span></a>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t</div>\n" +
            "\t\t</div>");

        //js脚本中嵌套的,和""比较多，函数传参数是字符串，必须要加''
        $(".remarkDiv").mouseover(function () {
            $(this).children("div").children("div").show();
        });

        $(".remarkDiv").mouseout(function () {
            $(this).children("div").children("div").hide();
        });

        $(".myHref").mouseover(function () {
            $(this).children("span").css("color", "red");
        });

        $(".myHref").mouseout(function () {
            $(this).children("span").css("color", "#E6E6E6");
        });
    }

    //异步查询详情页数据
    $.get('${pageContext.request.contextPath}/workbench/activity/toDetail', {'id': '${id}'}, function (data) {
        //data:Activity
        // 先设置市场活动数据
        var activity = data;
        $('#owner').text(activity.owner);
        $('#name').text(activity.name);
        $('#startTime').text(activity.startTime);
        $('#endTime').text(activity.endTime);
        $('#cost').text(activity.cost);
        $('#createBy').text(activity.createBy);
        $('#createTime').text(activity.createTime);
        $('#editBy').text(activity.editBy);
        $('#editTime').text(activity.editTime);
        $('#describe').text(activity.description);

        // 取出市场活动的备注数据
        var activityRemarks = activity.activityRemarks;
        for (var i in activityRemarks) {
            var activityRemark = activityRemarks[i];
            refresh(activityRemark);
        }
    }, 'json');

    //保存市场活动备注
    function saveRemark() {
        // 获取输入的备注内容
        var noteContent = $('#remark').val();
        $.post("${pageContext.request.contextPath}/workbench/activity/saveRemark", {
            'noteContent': noteContent, //备注内容
            'activityId': '${id}'   //市场活动主键
        }, function (data) {
            //data:resultVo
            if (data.ok) {
                var activityRemark = data.t;
                alert(data.message);
                //刷新备注
                refresh(activityRemark);
                //文本域内容设置为空
                $('#remark').val("");
            }
        }, 'json');
    }

    // 删除备注
    function deleteRemark(id) {
        $.get("${pageContext.request.contextPath}/workbench/activity/deleteRemark", {'id': id}, function (data) {
            //data:resultVo
            if (data.ok) {
                alert(data.message);
                //删除备注对应的div元素 jquery获取的dom元素可以自己删自己
                $('#' + id).remove();
            }
        }, 'json');
    }

    // 弹出模态窗口
    function openEditRemarkModal(id, noteContent) {
        // 显示模态窗口
        $('#editRemarkModal').modal('show');
        // 把备注的内容设置到模态窗口的文本域中
        $('#noteContent').val(noteContent);
        // 备注主键设置到隐藏域中
        $('#id').val(id);
    }

    // 修改备注
    $('#updateRemarkBtn').click(function () {
        $.get("${pageContext.request.contextPath}/workbench/activity/updateRemark", {
            'id': $('#id').val(),    //备注主键
            'noteContent': $('#noteContent').val()  //  用户修改的备注内容
        }, function (data) {
            // data:resultVo
            if (data.ok) {
                alert(data.message);
                // 关闭模态窗口
                $('#editRemarkModal').modal('hide');
                // 更新页面元素内容
                var noteContent = $('#noteContent').val();
                $('#h5' + $('#id').val()).text(noteContent);
            }
        }, 'json')
    });

    //修改表单
    $('#updateBtn').click(function () {

    });

    function editBtn() {
        $("#editActivityModal").modal('show');
        $.get("${pageContext.request.contextPath}/workbench/activity/queryById", {'id': '${id}'}, function (data) {
            // 先设置市场活动数据
            var activity = data;
            console.log(data)
            $('#edit-owner1').text(activity.owner);
            $('#edit-name').val(activity.name);
            $('#edit-startTime').val(activity.startTime);
            $('#edit-endTime').val(activity.endTime);
            $('#edit-cost').val(activity.cost);
            $('#edit-createBy').val(activity.createBy);
            $('#edit-createTime').val(activity.createTime);
            $('#edit-editBy').val(activity.editBy);
            $('#edit-editTime').val(activity.editTime);
            $('#edit-describe').val(activity.description);
        }, 'json')
    }
</script>
</body>
</html>