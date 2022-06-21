<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>

    <script type="text/javascript">

        $(function () {


        });

    </script>
</head>
<body>

<!-- 创建市场活动的模态窗口 -->
<div class="modal fade" id="createActivityModal" role="dialog">
    <div class="modal-dialog" role="document" style="width: 85%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel1">创建市场活动</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" id="createForm" role="form">

                    <div class="form-group">
                        <label for="create-marketActivityOwner" class="col-sm-2 control-label">所有者<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <select class="form-control" id="create-marketActivityOwner" name="owner">
                                <%--<option>zhangsan</option>
                                <option>lisi</option>
                                <option>wangwu</option>
                                <option>zhaoliu</option>--%>
                            </select>
                        </div>
                        <label for="create-marketActivityName" class="col-sm-2 control-label">名称<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-marketActivityName" name="name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="create-startTime" class="col-sm-2 control-label">开始日期</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-startTime" name="startTime">
                        </div>
                        <label for="create-endTime" class="col-sm-2 control-label">结束日期</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-endTime" name="endTime">
                        </div>
                    </div>
                    <div class="form-group">

                        <label for="create-cost" class="col-sm-2 control-label">成本</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="create-cost" name="cost">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="create-describe" class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-10" style="width: 81%;">
                            <textarea class="form-control" rows="3" id="create-describe" name="description"></textarea>
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="saveActivity()" data-dismiss="modal">保存</button>
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
                <h4 class="modal-title" id="myModalLabel2">修改市场活动</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" id="updateForm" role="form">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="edit-marketActivityOwner" class="col-sm-2 control-label">所有者<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <select class="form-control" id="edit-marketActivityOwner" name="owner">
                                <%--<option>zhangsan</option>
                                <option>lisi</option>
                                <option>wangwu</option>
                                <option>zhaoliu</option>--%>
                            </select>
                        </div>
                        <label for="edit-marketActivityName" class="col-sm-2 control-label">名称<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-marketActivityName" name="name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-startTime" class="col-sm-2 control-label">开始日期</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-startTime" name="startTime">
                        </div>
                        <label for="edit-endTime" class="col-sm-2 control-label">结束日期</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-endTime" name="endTime">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-cost" class="col-sm-2 control-label">成本</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="edit-cost" name="cost">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-describe" class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-10" style="width: 81%;">
								<textarea class="form-control" rows="3" id="edit-describe" name="description">

								</textarea>
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updateActivity()" data-dismiss="modal">更新
                </button>
            </div>
        </div>
    </div>
</div>

<div>
    <div style="position: relative; left: 10px; top: -10px;">
        <div class="page-header">
            <h3>市场活动列表</h3>
        </div>
    </div>
</div>
<div style="position: relative; top: -20px; left: 0px; width: 100%; height: 100%;">
    <div style="width: 100%; position: absolute;top: 5px; left: 10px;">

        <div class="btn-toolbar" role="toolbar" style="height: 80px;">
            <form class="form-inline" role="form" style="position: relative;top: 8%; left: 5px;">

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">名称</div>
                        <input class="form-control" id="name" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">所有者</div>
                        <input class="form-control" id="owner" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">开始日期</div>
                        <input class="form-control" type="text" id="startTime"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">结束日期</div>
                        <input class="form-control" type="text" id="endTime">
                    </div>
                </div>

                <button type="button" onclick="queryActivities()" class="btn btn-default">查询</button>

            </form>
        </div>
        <div class="btn-toolbar" role="toolbar"
             style="background-color: #F7F7F7; height: 50px; position: relative;top: 5px;">
            <div class="btn-group" style="position: relative; top: 18%;">
                <button type="button" class="btn btn-primary" data-toggle="modal" onclick="openCreateModal()">
                    <span class="glyphicon glyphicon-plus"></span>创建
                </button>
                <button type="button" class="btn btn-default" data-toggle="modal" onclick="openEditModal()">
                    <span class="glyphicon glyphicon-pencil"></span>修改
                </button>
                <button type="button" class="btn btn-danger" onclick="deleteBatch()">
                    <span class="glyphicon glyphicon-minus"></span>删除
                </button>
                <button type="button" class="btn btn-success" onclick="exportExcel()">
                    <span class="glyphicon glyphicon-cloud-download"></span>导出报表
                </button>
            </div>

        </div>
        <div style="position: relative;top: 10px;">
            <table class="table table-hover">
                <thead>
                <tr style="color: #B3B3B3;">
                    <td><input id="father" type="checkbox"/></td>
                    <td>名称</td>
                    <td>所有者</td>
                    <td>开始日期</td>
                    <td>结束日期</td>
                </tr>
                </thead>
                <tbody id="activityBody">
                <%--<tr class="active">
                    <td><input type="checkbox" /></td>
                    <td><a style="text-decoration: none; cursor: pointer;" onclick="window.location.href='detail.jsp';">发传单</a></td>
                    <td>zhangsan</td>
                    <td>2020-10-10</td>
                    <td>2020-10-20</td>
                </tr>--%>
                </tbody>
            </table>
        </div>

        <div style="height: 50px; position: relative;top: 30px;">
            <div id="activityPage"></div>
        </div>

    </div>

</div>

<link rel="stylesheet" href="${pageContext.request.contextPath}/bs_pagination/jquery.bs_pagination.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/bs_pagination/en.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bs_pagination/jquery.bs_pagination.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
<script>
    (function ($) {
        $.fn.datetimepicker.dates['zh-CN'] = {
            days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
            daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
            daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            today: "今天",
            suffix: [],
            meridiem: ["上午", "下午"]
        };
    }(jQuery));

    var rsc_bs_pag = {
        go_to_page_title: 'Go to page',
        rows_per_page_title: 'Rows per page',
        current_page_label: 'Page',
        current_page_abbr_label: 'p.',
        total_pages_label: 'of',
        total_pages_abbr_label: '/',
        total_rows_label: 'of',
        rows_info_records: 'records',
        go_top_text: '首页',
        go_prev_text: '上一页',
        go_next_text: '下一页',
        go_last_text: '末页'
    };

    //刷新列表数据
    function refresh(pageNum, pageSize) {
        $.get("${pageContext.request.contextPath}/workbench/activity/list", {
            'pageNum': pageNum,//当前页码
            'pageSize': pageSize,//每页记录数
            'name': $('#name').val(),//市场活动名称
            'owner': $('#owner').val(),//所有者
            'startTime': $('#startTime').val(),//开始时间
            'endTime': $('#endTime').val()//结束时间
        }, function (data) {
            //data:PageInfo
            //清空数据
            $('#activityBody').html("");
            var activities = data.list;
            for (var i = 0; i < activities.length; i++) {
                var activity = activities[i];
                $('#activityBody').append("<tr class=\"active\">\n" +
                    "\t\t\t\t\t\t\t<td><input class='son' onclick='check()' value=" + activity.id + " type=\"checkbox\" /></td>\n" +
                    "\t\t\t\t\t\t\t<td><a style=\"text-decoration: none; cursor: pointer;\" onclick=\"javascript:window.location.href='${pageContext.request.contextPath}/toView/workbench/activity/detail?id=" + activity.id + "';\">" + activity.name + "</a></td>\n" +
                    "\t\t\t\t\t\t\t<td>" + activity.owner + "</td>\n" +
                    "\t\t\t\t\t\t\t<td>" + activity.startTime + "</td>\n" +
                    "\t\t\t\t\t\t\t<td>" + activity.endTime + "</td>\n" +
                    "\t\t\t\t\t\t\t</tr>");

            }
            //count % pageSize == 0 ? count / pageSize : count / pageSize + 1
            $("#activityPage").bs_pagination({
                currentPage: data.pageNum, //	页码
                rowsPerPage: data.pageSize, //	每页显示的记录条数 pageSize
                maxRowsPerPage: 50, //	每页最多显示的记录条数
                totalPages: data.pages, //	总页数
                totalRows: data.total, //	总记录条数
                visiblePageLinks: 5, //	显示几个卡片
                showGoToPage: true,
                showRowsPerPage: true,
                showRowsInfo: true,
                showRowsDefaultInfo: true,
                // onChangePage:	每次操作分页插件，都会出发该函数
                onChangePage: function (event, obj) {
                    refresh(obj.currentPage, obj.rowsPerPage);
                }
            });
        }, 'json');

    }

    refresh(1, 5);

    $("#startTime").datetimepicker({
        language: "zh-CN",
        format: "yyyy-mm-dd",	//显示格式
        minView: "month",	//设置只显示到月份
        initialDate: new Date(),	//初始化当前日期
        autoclose: true,	//选中自动关闭
        todayBtn: true,	//显示今日按钮
        clearBtn: true,
        pickerPosition: "bottom-left"
    });

    $("#endTime").datetimepicker({
        language: "zh-CN",
        format: "yyyy-mm-dd",	//显示格式
        minView: "month",	//设置只显示到月份
        initialDate: new Date(),	//初始化当前日期
        autoclose: true,	//选中自动关闭
        todayBtn: true,	//显示今日按钮
        clearBtn: true,
        pickerPosition: "bottom-left"
    });

    //补充:js函数，只要函数名称相同，就可以调用，参数是封装在函数内部的一个内置数组，这个数组叫做:arguments

    //点击查询按钮，异步查询
    function queryActivities() {
        refresh(1, 5);
    }

    //点击创建按钮，异步查询所有者信息
    function openCreateModal() {
        //手动弹出模态窗口 show hide
        $('#createActivityModal').modal('show');
        $.get('${pageContext.request.contextPath}/workbench/activity/queryUsers', function (data) {
            //data:List<User>
            for (var i = 0; i < data.length; i++) {
                var user = data[i];
                $('#create-marketActivityOwner').append("<option value=" + user.id + ">" + user.name + "</option>");
            }
        }, 'json');
    }

    //异步保存市场活动
    function saveActivity() {
        //表单序列化 name=zhangsan&age=100 弊端:只能操作单个表(实体类)
        var form = $('#createForm').serialize();
        $.post("${pageContext.request.contextPath}/workbench/activity/saveOrUpdate", form, function (data) {
            //data:resultVo
            if (data.ok) {
                alert(data.message);
                // 刷新页面
                refresh(1, 5);
                // 重置表单
                document.querySelector("#createForm").reset();
            }
        }, 'json');
    }

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

    // 异步修改
    function openEditModal() {
        var checkedLength = $('.son:checked').length;
        if (checkedLength == 0) {
            alert("至少操作数据");
        } else if (checkedLength > 1) {
            alert("只能操作一条数据");
        } else {
            //发送请求，根据主键查询出当前市场活动数据
            $('#editActivityModal').modal('show');
            //获取勾中的son元素
            var id = $($('.son:checked')[0]).val();
            //根据主键查询市场活动
            $.get('${pageContext.request.contextPath}/workbench/activity/queryById', {'id': id}, function (data) {
                //data:Activity
                var activity = data;
                //把查询出来的市场活动的数据设置到页面上
                $('#edit-marketActivityName').val(activity.name);
                $('#edit-startTime').val(activity.startTime);
                $('#edit-endTime').val(activity.endTime);
                $('#edit-cost').val(activity.cost);
                $('#edit-describe').val(activity.description);
                //把市场活动主键设置到隐藏域中，不设置就会更新所有数据了
                $('#id').val(activity.id);
                //异步查询所有者数据
                $.get('${pageContext.request.contextPath}/workbench/activity/queryUsers',function (data) {
                    //data:List<User>
                    for(var i = 0; i < data.length; i++){
                        var user = data[i];
                        $('#edit-marketActivityOwner').append("<option value=" + user.id + ">" + user.name + "</option>");
                    }
                    //给定的值如果等于其中某个option的value值，就会自动的让该option选中
                    $('#edit-marketActivityOwner').val(activity.owner);
                },'json');
            }, 'json');
        }
    }

    function updateActivity() {
        $.get('${pageContext.request.contextPath}/workbench/activity/saveOrUpdate', $('#updateForm').serialize(), function (data) {
            //data:resultVo
            if (data.ok) {
                alert(data.message)
                //刷新页面数据
                refresh(1, 5);
            }
        }, 'json');
    }

    // 批量删除
    function deleteBatch() {
        //获取勾中的son的个数
        var checkedLength = $('.son:checked').length;
        if (checkedLength == 0) {
            alert("至少选中一条记录");
        } else {
            layer.alert("确定删除选中的" + checkedLength + "条数据吗？", {
                time: 0 //不自动关闭
                , btn: ['确定', '取消']
                , yes: function (index) {
                    //点击确定按钮后，关闭弹窗
                    layer.close(index);
                    var ids = [];
                    //获取勾中数据的主键拼接成字符串
                    $('.son:checked').each(function () {
                        ids.push($(this).val());
                    });
                    /**
                     * join:数组调用该方法，默认会把数组中的内容以指定分隔符拼接成字符串 [1,2,3]
                     * 默认的分隔符就是,，也可以指定分隔符
                     */
                    //异步删除
                    $.get('${pageContext.request.contextPath}/workbench/activity/deleteBatch', {'ids': ids.join()}, function (data) {
                        //data:resultVo
                        if (data.ok) {
                            alert(data.message);
                            //刷新页面
                            refresh(1, 3);
                        }
                    }, 'json');
                }
            });
        }
    }

    //导出报表
    function exportExcel() {
        location.href = "${pageContext.request.contextPath}/workbench/activity/exportExcel";
    }

</script>
</body>
</html>