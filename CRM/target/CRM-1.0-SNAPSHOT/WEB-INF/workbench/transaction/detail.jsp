<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <link href="${pageContext.request.contextPath}/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css"
          rel="stylesheet"/>

    <style type="text/css">
        .mystage {
            font-size: 20px;
            vertical-align: middle;
            cursor: pointer;
        }

        .closingDate {
            font-size: 15px;
            cursor: pointer;
            vertical-align: middle;
        }
    </style>

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


            //阶段提示框
            $(".mystage").popover({
                trigger: 'manual',
                placement: 'bottom',
                html: 'true',
                animation: false
            }).on("mouseenter", function () {
                var _this = this;
                $(this).popover("show");
                $(this).siblings(".popover").on("mouseleave", function () {
                    $(_this).popover('hide');
                });
            }).on("mouseleave", function () {
                var _this = this;
                setTimeout(function () {
                    if (!$(".popover:hover").length) {
                        $(_this).popover("hide")
                    }
                }, 100);
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
                <h4 class="modal-title" id="myModalLabel1">修改备注</h4>
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

<!-- 返回按钮 -->
<div style="position: relative; top: 35px; left: 10px;">
    <a href="javascript:void(0);" onclick="window.history.back();"><span class="glyphicon glyphicon-arrow-left"
                                                                         style="font-size: 20px; color: #DDDDDD"></span></a>
</div>

<!-- 大标题 -->
<div style="position: relative; left: 40px; top: -30px;">
    <div class="page-header">
        <h3>动力节点-交易01 <small>￥5,000</small></h3>
    </div>
    <div style="position: relative; height: 50px; width: 250px;  top: -72px; left: 700px;">
        <button type="button" class="btn btn-default" data-target="#editTranModal"><span
                class="glyphicon glyphicon-edit"></span> 编辑
        </button>
        <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-minus"></span> 删除</button>
    </div>
</div>

<!-- 阶段状态 -->
<div id="stages" style="position: relative; left: 40px; top: -50px;">

</div>

<!-- 详细信息 -->
<div style="position: relative; top: 0px;">
    <div style="position: relative; left: 40px; height: 30px;">
        <div style="width: 300px; color: gray;">所有者</div>
        <div style="width: 300px;position: relative; left: 200px; top: -20px;"><b id="owner"></b></div>
        <div style="width: 300px;position: relative; left: 450px; top: -40px; color: gray;">金额</div>
        <div style="width: 300px;position: relative; left: 650px; top: -60px;"><b id="money"></b></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px;"></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px; left: 450px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 10px;">
        <div style="width: 300px; color: gray;">名称</div>
        <div style="width: 300px;position: relative; left: 200px; top: -20px;"><b id="name"></b></div>
        <div style="width: 300px;position: relative; left: 450px; top: -40px; color: gray;">预计成交日期</div>
        <div style="width: 300px;position: relative; left: 650px; top: -60px;"><b id="expectedTime"></b></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px;"></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px; left: 450px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 20px;">
        <div style="width: 300px; color: gray;">客户名称</div>
        <div style="width: 300px;position: relative; left: 200px; top: -20px;"><b id="customerId"></b></div>
        <div style="width: 300px;position: relative; left: 450px; top: -40px; color: gray;">阶段</div>
        <div style="width: 300px;position: relative; left: 650px; top: -60px;"><b id="stage"></b></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px;"></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px; left: 450px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 30px;">
        <div style="width: 300px; color: gray;">类型</div>
        <div style="width: 300px;position: relative; left: 200px; top: -20px;"><b id="type"></b></div>
        <div style="width: 300px;position: relative; left: 450px; top: -40px; color: gray;">可能性</div>
        <div style="width: 300px;position: relative; left: 650px; top: -60px;"><b id="possibility"></b></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px;"></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px; left: 450px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 40px;">
        <div style="width: 300px; color: gray;">来源</div>
        <div style="width: 300px;position: relative; left: 200px; top: -20px;"><b id="source"></b></div>
        <div style="width: 300px;position: relative; left: 450px; top: -40px; color: gray;">市场活动源</div>
        <div style="width: 300px;position: relative; left: 650px; top: -60px;"><b id="activityId"></b></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px;"></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -60px; left: 450px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 50px;">
        <div style="width: 300px; color: gray;">联系人名称</div>
        <div style="width: 500px;position: relative; left: 200px; top: -20px;"><b id="contactId"></b></div>
        <div style="height: 1px; width: 550px; background: #D5D5D5; position: relative; top: -20px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 60px;">
        <div style="width: 300px; color: gray;">创建者</div>
        <div style="width: 500px;position: relative; left: 200px; top: -20px;"><b id="createBy"></b><small
                id="createTime" style="font-size: 10px; color: gray;"></small></div>
        <div style="height: 1px; width: 550px; background: #D5D5D5; position: relative; top: -20px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 70px;">
        <div style="width: 300px; color: gray;">修改者</div>
        <div style="width: 500px;position: relative; left: 200px; top: -20px;"><b id="editBy"></b><small id="editTime"
                                                                                                         style="font-size: 10px; color: gray;"></small>
        </div>
        <div style="height: 1px; width: 550px; background: #D5D5D5; position: relative; top: -20px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 80px;">
        <div style="width: 300px; color: gray;">描述</div>
        <div style="width: 630px;position: relative; left: 200px; top: -20px;"><b id="describe"></b></div>
        <div style="height: 1px; width: 850px; background: #D5D5D5; position: relative; top: -20px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 90px;">
        <div style="width: 300px; color: gray;">联系纪要</div>
        <div style="width: 630px;position: relative; left: 200px; top: -20px;"><b id="contactSummary"></b></div>
        <div style="height: 1px; width: 850px; background: #D5D5D5; position: relative; top: -20px;"></div>
    </div>
    <div style="position: relative; left: 40px; height: 30px; top: 100px;">
        <div style="width: 300px; color: gray;">下次联系时间</div>
        <div style="width: 500px;position: relative; left: 200px; top: -20px;"><b id="nextContactTime"></b></div>
        <div style="height: 1px; width: 400px; background: #D5D5D5; position: relative; top: -20px;"></div>
    </div>
</div>

<!-- 备注 -->
<div style="position: relative; top: 100px; left: 40px;">
    <div class="page-header">
        <h4>备注</h4>
    </div>

    <!-- 备注1 -->
    <%--<div class="remarkDiv" style="height: 60px;">
        <img title="zhangsan" src="../../image/user-thumbnail.png" style="width: 30px; height:30px;">
        <div style="position: relative; top: -40px; left: 40px;" >
            <h5>哎呦！</h5>
            <font color="gray">交易</font> <font color="gray">-</font> <b>动力节点-交易01</b> <small style="color: gray;"> 2017-01-22 10:10:10 由zhangsan</small>
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

<!-- 阶段历史 -->
<div>
    <div style="position: relative; top: 100px; left: 40px;">
        <div class="page-header">
            <h4>阶段历史</h4>
            <div style="position: relative; width: 500px;  top: -35px; left: 750px;">
                <button type="button" class="btn btn-default" onclick="clearHistory()">清空历史</button>
            </div>
        </div>
        <div style="position: relative;top: 0px;">
            <table id="activityTable" class="table table-hover" style="width: 900px;">
                <thead>
                <tr style="color: #B3B3B3;">
                    <td>阶段</td>
                    <td>金额</td>
                    <td>可能性</td>
                    <td>预计成交日期</td>
                    <td>创建时间</td>
                    <td>创建人</td>
                </tr>
                </thead>
                <tbody id="tranHistoryBody">
               <%-- <tr>
                    <td>资质审查</td>
                    <td>5,000</td>
                    <td>10</td>
                    <td>2017-02-07</td>
                    <td>2016-10-10 10:10:10</td>
                    <td>zhangsan</td>
                </tr>--%>
                </tbody>
            </table>
        </div>

    </div>
</div>

<div style="height: 200px;"></div>

<script>

    //刷新备注
    function refresh1(tranRemark) {
        $('#remarkDiv').before("<div class=\"remarkDiv\" id=" + tranRemark.id + " style=\"height: 60px;\">\n" +
            "\t\t\t<img title=\"zhangsan\" src=" + tranRemark.img + " style=\"width: 30px; height:30px;\">\n" +
            "\t\t\t<div style=\"position: relative; top: -40px; left: 40px;\" >\n" +
            "\t\t\t\t<h5 id=h5" + tranRemark.id + ">" + tranRemark.noteContent + "</h5>\n" +
            "\t\t\t\t<font color=\"gray\">交易</font> <font color=\"gray\">-</font> <b>" + tranRemark.tranId + "</b> <small style=\"color: gray;\"> " + tranRemark.createTime + " 由" + tranRemark.createBy + "</small>\n" +
            "\t\t\t\t<div style=\"position: relative; left: 500px; top: -30px; height: 30px; width: 100px; display: none;\">\n" +
            "\t\t\t\t\t<a class=\"myHref\" onclick=\"openEditRemarkModal('" + tranRemark.id + "','" + tranRemark.noteContent + "')\" href=\"javascript:void(0);\"><span class=\"glyphicon glyphicon-edit\" style=\"font-size: 20px; color: #E6E6E6;\"></span></a>\n" +
            "\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n" +
            "\t\t\t\t\t<a class=\"myHref\" onclick=\"deleteRemark('" + tranRemark.id + "')\" href=\"javascript:void(0);\"><span class=\"glyphicon glyphicon-remove\" style=\"font-size: 20px; color: #E6E6E6;\"></span></a>\n" +
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

    //异步查询交易详情页数据
    $.get('${pageContext.request.contextPath}/workbench/tran/toDetail', {'id': '${id}'}, function (data) {
        //data:Tran
        // 先设置交易数据
        var tran = data;
        $('#owner').text(tran.owner);
        $('#money').text(tran.money);
        $('#name').text(tran.name);
        $('#expectedTime').text(tran.expectedTime);
        $('#customerId').text(tran.customerId);
        $('#stage').text(tran.stage);
        $('#type').text(tran.type);
        $('#possibility').text(tran.possibility);
        $('#source').text(tran.source);
        $('#activityId').text(tran.activityId);
        $('#contactId').text(tran.contactId);
        $('#createBy').text(tran.createBy);
        $('#createTime').text(tran.createTime);
        $('#editBy').text(tran.editBy);
        $('#editTime').text(tran.editTime);
        $('#describe').text(tran.description);
        $('#contactSummary').text(tran.contactSummary);
        $('#nextContactTime').text(tran.nextContactTime);

        // 取出市场活动的备注数据
        var tranRemarks = tran.tranRemarks;
        for (var i in tranRemarks) {
            var tranRemark = tranRemarks[i];
            refresh1(tranRemark);
        }

    }, 'json');

    //保存交易备注
    function saveRemark() {
        // 获取输入的备注内容
        var noteContent = $('#remark').val();
        $.post("${pageContext.request.contextPath}/workbench/tran/saveRemark", {
            'noteContent': noteContent, //备注内容
            'tranId': '${id}'   //交易主键
        }, function (data) {
            //data:resultVo
            if (data.ok) {
                var tranRemark = data.t;
                alert(data.message);
                //刷新备注
                refresh1(tranRemark);
                //文本域内容设置为空
                $('#remark').val("");
            }
        }, 'json');
    }

    // 删除备注
    function deleteRemark(id) {
        $.get("${pageContext.request.contextPath}/workbench/tran/deleteRemark", {'id': id}, function (data) {
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

    //js用于判断真假 true/false 1/0 null undefined
    refresh();

    //刷新阶段图标数据
    function refresh(index) {
        //发送异步请求，查询交易对应的阶段图标
        $.get('${pageContext.request.contextPath}/workbench/tran/queryStages', {
            'id': '${id}',
            'index': index
        }, function (data) {
            //List<StageVo>
            $('#stages').html("");
            $('#stages').append("阶段&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
            var stageVos = data.stageVos;
            for (var i = 0; i < stageVos.length; i++) {
                var stageVo = stageVos[i];
                if (stageVo.type == "绿圈") {
                    $('#stages').append("<span onclick=\"changeStage(" + i + ",'" + stageVo.content + "','" + stageVo.possibility + "')\" class=\"glyphicon glyphicon-ok-circle mystage\"" +
                        " data-toggle=\"popover\" data-placement=\"bottom\"" +
                        " data-content=" + stageVo.content + ":" + stageVo.possibility + " style=\"color: #90F790;\"></span>");
                } else if (stageVo.type == "锚点") {
                    $('#stages').append("<span onclick=\"changeStage(" + i + ",'" + stageVo.content + "','" + stageVo.possibility + "')\" class=\"glyphicon glyphicon-map-marker mystage\"" +
                        " data-toggle=\"popover\" data-placement=\"bottom\"" +
                        " data-content=" + stageVo.content + ":" + stageVo.possibility + " style=\"color: #90F790;\"></span>");
                } else if (stageVo.type == "黑圈") {
                    $('#stages').append("<span onclick=\"changeStage(" + i + ",'" + stageVo.content + "','" + stageVo.possibility + "')\" class=\"glyphicon glyphicon-record mystage\"" +
                        " data-toggle=\"popover\" data-placement=\"bottom\"" +
                        " data-content=" + stageVo.content + ":" + stageVo.possibility + "></span>");
                } else if (stageVo.type == "红x") {
                    $('#stages').append("<span onclick=\"changeStage(" + i + ",'" + stageVo.content + "','" + stageVo.possibility + "')\" class=\"glyphicon glyphicon-remove mystage\"" +
                        " data-toggle=\"popover\" data-placement=\"bottom\"" +
                        " data-content=" + stageVo.content + ":" + stageVo.possibility + " style=\"color: red;\"></span>");
                } else {
                    $('#stages').append("<span onclick=\"changeStage(" + i + ",'" + stageVo.content + "','" + stageVo.possibility + "')\" class=\"glyphicon glyphicon-remove mystage\"" +
                        " data-toggle=\"popover\" data-placement=\"bottom\"" +
                        " data-content=" + stageVo.content + ":" + stageVo.possibility + "></span>");
                }
                $('#stages').append("-----------");
            }
            $('#stages').append("\t<span class=\"closingDate\">" + new Date().toLocaleDateString() + "</span>");
            //阶段提示框
            $(".mystage").popover({
                trigger: 'manual',
                placement: 'bottom',
                html: 'true',
                animation: false
            }).on("mouseenter", function () {
                var _this = this;
                $(this).popover("show");
                $(this).siblings(".popover").on("mouseleave", function () {
                    $(_this).popover('hide');
                });
            }).on("mouseleave", function () {
                var _this = this;
                setTimeout(function () {
                    if (!$(".popover:hover").length) {
                        $(_this).popover("hide")
                    }
                }, 100);
            });
            // 显示交易历史
            var histories = data.tranHistories;
            $('#tranHistoryBody').html("");
            for (var i = 0; i < histories.length; i ++) {
                var tranHistory = histories[i];
                //点击交易图标的，添加一条交易历史
                $('#tranHistoryBody').append("<tr>\n" +
                    "\t\t\t\t\t\t\t<td>" + tranHistory.stage + "</td>\n" +
                    "\t\t\t\t\t\t\t<td>" + tranHistory.money + "</td>\n" +
                    "\t\t\t\t\t\t\t<td>" + tranHistory.possibility + "</td>\n" +
                    "\t\t\t\t\t\t\t<td>" + tranHistory.expectedTime + "</td>\n" +
                    "\t\t\t\t\t\t\t<td>" + tranHistory.createTime + "</td>\n" +
                    "\t\t\t\t\t\t\t<td>" + tranHistory.createBy + "</td>\n" +
                    "\t\t\t\t\t\t</tr>");
            }
            if (index) {
                var histories = data.tranHistories;
                $('#tranHistoryBody').html("");
                for (var i = 0; i < histories.length; i ++) {
                    var tranHistory = histories[i];
                    //点击交易图标的，添加一条交易历史
                    $('#tranHistoryBody').append("<tr>\n" +
                        "\t\t\t\t\t\t\t<td>" + tranHistory.stage + "</td>\n" +
                        "\t\t\t\t\t\t\t<td>" + tranHistory.money + "</td>\n" +
                        "\t\t\t\t\t\t\t<td>" + tranHistory.possibility + "</td>\n" +
                        "\t\t\t\t\t\t\t<td>" + tranHistory.expectedTime + "</td>\n" +
                        "\t\t\t\t\t\t\t<td>" + tranHistory.createTime + "</td>\n" +
                        "\t\t\t\t\t\t\t<td>" + tranHistory.createBy + "</td>\n" +
                        "\t\t\t\t\t\t</tr>");
                }
            }
        }, 'json');
    }

    //点击修改交易图标
    function changeStage(index, stage, possibility) {
        //更改页面的阶段和可能性
        $('#stage').text(stage);
        $('#possibility').text(possibility);
        refresh(index);
    }

    // 清空历史
    function clearHistory() {
        //异步删除
        $.get('${pageContext.request.contextPath}/workbench/tran/clearHistory', {'id': '${id}'}, function (data) {
            //data:resultVo
            if (data.ok) {
                alert(data.message);
                //刷新页面
                window.location.reload();
            }
        }, 'json');
    }

</script>
</body>
</html>