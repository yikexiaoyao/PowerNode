<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<link href="${pageContext.request.contextPath}/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet" />

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap_3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<script type="text/javascript">

	$(function(){
		
		
		
	});
	
</script>
</head>
<body>

    <!-- 创建线索的模态窗口 -->
    <div class="modal fade" id="createClueModal" role="dialog">
        <div class="modal-dialog" role="document" style="width: 90%;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">×</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">创建线索</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="createForm" role="form">

                        <div class="form-group">
                            <label for="create-clueOwner" class="col-sm-2 control-label">所有者<span style="font-size: 15px; color: red;">*</span></label>
                            <div class="col-sm-10" style="width: 300px;">
                                <select class="form-control" id="create-clueOwner" name="owner">

                                </select>
                            </div>
                            <label for="create-company" class="col-sm-2 control-label">公司<span style="font-size: 15px; color: red;">*</span></label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="create-company" name="company">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="create-appellation" class="col-sm-2 control-label">称呼</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <select class="form-control" id="create-appellation" name="appellation">
                                    <option>---请选择---</option>
                                    <c:forEach items="${map['appellation']}" var="appellation">
                                        <option value="${appellation.value}">${appellation.text}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <label for="create-fullname" class="col-sm-2 control-label">姓名<span style="font-size: 15px; color: red;">*</span></label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="create-fullname" name="fullname">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="create-job" class="col-sm-2 control-label">职位</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="create-job" name="job">
                            </div>
                            <label for="create-email" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="create-email" name="email">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="create-phone" class="col-sm-2 control-label">公司座机</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="create-phone" name="phone">
                            </div>
                            <label for="create-website" class="col-sm-2 control-label">公司网站</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="create-website" name="website">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="create-mphone" class="col-sm-2 control-label">手机</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="create-mphone" name="mphone">
                            </div>
                            <label for="create-state" class="col-sm-2 control-label">线索状态</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <select class="form-control" id="create-state" name="state">
                                    <option>---请选择---</option>
                                    <c:forEach items="${map['clueState']}" var="state">
                                        <option value="${state.value}">${state.text}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="create-source" class="col-sm-2 control-label">线索来源</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <select class="form-control" id="create-source" name="source">
                                    <option>---请选择---</option>
                                    <c:forEach items="${map['source']}" var="source">
                                        <option value="${source.value}">${source.text}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="create-describe" class="col-sm-2 control-label">线索描述</label>
                            <div class="col-sm-10" style="width: 81%;">
                                <textarea class="form-control" rows="3" id="create-describe" name="description"></textarea>
                            </div>
                        </div>

                        <div style="height: 1px; width: 103%; background-color: #D5D5D5; left: -13px; position: relative;"></div>

                        <div style="position: relative;top: 15px;">
                            <div class="form-group">
                                <label for="create-contactSummary" class="col-sm-2 control-label">联系纪要</label>
                                <div class="col-sm-10" style="width: 81%;">
                                    <textarea class="form-control" rows="3" id="create-contactSummary" name="contactSummary"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="create-nextContactTime" class="col-sm-2 control-label">下次联系时间</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-nextContactTime" name="nextContactTime">
                                </div>
                            </div>
                        </div>

                        <div style="height: 1px; width: 103%; background-color: #D5D5D5; left: -13px; position: relative; top : 10px;"></div>

                        <div style="position: relative;top: 20px;">
                            <div class="form-group">
                                <label for="create-address" class="col-sm-2 control-label">详细地址</label>
                                <div class="col-sm-10" style="width: 81%;">
                                    <textarea class="form-control" rows="1" id="create-address" name="address"></textarea>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="saveClue()" data-dismiss="modal">保存</button>
                </div>
            </div>
        </div>
    </div>

    <!-- 修改线索的模态窗口 -->
    <div class="modal fade" id="editClueModal" role="dialog">
        <div class="modal-dialog" role="document" style="width: 90%;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">×</span>
                    </button>
                    <h4 class="modal-title">修改线索</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="updateForm" role="form">
                        <input type="hidden" name="id" id="id">
                        <div class="form-group">
                            <label for="edit-clueOwner" class="col-sm-2 control-label">所有者<span style="font-size: 15px; color: red;">*</span></label>
                            <div class="col-sm-10" style="width: 300px;">
                                <select class="form-control" id="edit-clueOwner" name="owner">

                                </select>
                            </div>
                            <label for="edit-company" class="col-sm-2 control-label">公司<span style="font-size: 15px; color: red;">*</span></label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="edit-company" name="company">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="edit-appellation" class="col-sm-2 control-label">称呼</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <select class="form-control" id="edit-appellation" name="appellation">
                                    <option>---请选择---</option>
                                    <c:forEach items="${map['appellation']}" var="appellation">
                                        <option value="${appellation.value}">${appellation.text}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <label for="edit-fullname" class="col-sm-2 control-label">姓名<span style="font-size: 15px; color: red;">*</span></label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="edit-fullname" name="fullname">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="edit-job" class="col-sm-2 control-label">职位</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="edit-job" name="job">
                            </div>
                            <label for="edit-email" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="edit-email" name="email">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="edit-phone" class="col-sm-2 control-label">公司座机</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="edit-phone" name="phone">
                            </div>
                            <label for="edit-website" class="col-sm-2 control-label">公司网站</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="edit-website" name="website">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="edit-mphone" class="col-sm-2 control-label">手机</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="edit-mphone" name="mphone">
                            </div>
                            <label for="edit-state" class="col-sm-2 control-label">线索状态</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <select class="form-control" id="edit-state" name="state">
                                    <option>---请选择---</option>
                                    <c:forEach items="${map['clueState']}" var="state">
                                        <option value="${state.value}">${state.text}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="edit-source" class="col-sm-2 control-label">线索来源</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <select class="form-control" id="edit-source" name="source">
                                    <option>---请选择---</option>
                                    <c:forEach items="${map['source']}" var="source">
                                        <option value="${source.value}">${source.text}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="edit-describe" class="col-sm-2 control-label">描述</label>
                            <div class="col-sm-10" style="width: 81%;">
                                <textarea class="form-control" rows="3" id="edit-describe" name="description"></textarea>
                            </div>
                        </div>

                        <div style="height: 1px; width: 103%; background-color: #D5D5D5; left: -13px; position: relative;"></div>

                        <div style="position: relative;top: 15px;">
                            <div class="form-group">
                                <label for="edit-contactSummary" class="col-sm-2 control-label">联系纪要</label>
                                <div class="col-sm-10" style="width: 81%;">
                                    <textarea class="form-control" rows="3" id="edit-contactSummary" name="contactSummary"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="edit-nextContactTime" class="col-sm-2 control-label">下次联系时间</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="edit-nextContactTime" name="nextContactTime">
                                </div>
                            </div>
                        </div>

                        <div style="height: 1px; width: 103%; background-color: #D5D5D5; left: -13px; position: relative; top : 10px;"></div>

                        <div style="position: relative;top: 20px;">
                            <div class="form-group">
                                <label for="edit-address" class="col-sm-2 control-label">详细地址</label>
                                <div class="col-sm-10" style="width: 81%;">
                                    <textarea class="form-control" rows="1" id="edit-address" name="address"></textarea>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="updateClue()" data-dismiss="modal">更新</button>
                </div>
            </div>
        </div>
    </div>

    <div>
        <div style="position: relative; left: 10px; top: -10px;">
            <div class="page-header">
                <h3>线索列表</h3>
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
                            <input class="form-control" id="fullname" type="text">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">公司</div>
                            <input class="form-control" id="company" type="text">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">公司座机</div>
                            <input class="form-control" id="phone" type="text">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">线索来源</div>
                            <select class="form-control" id="source">
                                <option>---请选择---</option>
                                <c:forEach items="${map['source']}" var="source">
                                    <option value="${source.value}">${source.text}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <br>

                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">所有者</div>
                            <input class="form-control" id="owner" type="text">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">手机</div>
                            <input class="form-control" id="mphone" type="text">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">线索状态</div>
                            <select class="form-control" id="state">
                                <option>---请选择---</option>
                                <c:forEach items="${map['clueState']}" var="state">
                                    <option value="${state.value}">${state.text}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <button type="button" onclick="queryClues()" class="btn btn-default">查询</button>

                </form>
            </div>
            <div class="btn-toolbar" role="toolbar" style="background-color: #F7F7F7; height: 50px; position: relative;top: 40px;">
                <div class="btn-group" style="position: relative; top: 18%;">
                    <button type="button" class="btn btn-primary" data-toggle="modal" onclick="openCreateModal()"><span class="glyphicon glyphicon-plus"></span> 创建</button>
                    <button type="button" class="btn btn-default" data-toggle="modal" onclick="openEditModal()"><span class="glyphicon glyphicon-pencil"></span> 修改</button>
                    <button type="button" class="btn btn-danger" onclick="deleteBatch()"><span class="glyphicon glyphicon-minus"></span> 删除</button>
                </div>

            </div>
            <div style="position: relative;top: 50px;">
                <table class="table table-hover">
                    <thead>
                    <tr style="color: #B3B3B3;">
                        <td><input id="father" type="checkbox" /></td>
                        <td>名称</td>
                        <td>公司</td>
                        <td>公司座机</td>
                        <td>手机</td>
                        <td>线索来源</td>
                        <td>所有者</td>
                        <td>线索状态</td>
                    </tr>
                    </thead>
                    <tbody id="clueBody">
                    </tbody>
                </table>
            </div>

            <div style="height: 50px; position: relative;top: 60px;">
                <div id="cluePage"></div>
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
            $.get("${pageContext.request.contextPath}/workbench/clue/list", {
                'pageNum': pageNum,//当前页码
                'pageSize': pageSize,//每页记录数
                'fullname': $('#fullname').val(),
                'company': $('#company').val(),
                'phone': $('#phone').val(),
                'mphone': $('#mphone').val(),
                'source': $('#source').val(),
                'owner': $('#owner').val(),
                'state': $('#state').val()
            }, function (data) {
                //data:PageInfo
                //清空数据
                console.log(data)
                $('#clueBody').html("");
                var clues = data.list;
                for (var i = 0; i < clues.length; i++) {
                    var clue = clues[i];
                    $('#clueBody').append("<tr class=\"active\">\n" +
                        "\t\t\t\t\t\t\t<td><input class='son' onclick='check()' value=" + clue.id + " type=\"checkbox\" /></td>\n" +
                        "\t\t\t\t\t\t\t<td><a style=\"text-decoration: none; cursor: pointer;\" onclick=\"javascript:window.location.href='${pageContext.request.contextPath}/toView/workbench/clue/detail?id=" + clue.id + "';\">" + clue.fullname + "</a></td>\n" +
                        "\t\t\t\t\t\t\t<td>" + clue.company + "</td>\n" +
                        "\t\t\t\t\t\t\t<td>" + clue.phone + "</td>\n" +
                        "\t\t\t\t\t\t\t<td>" + clue.mphone + "</td>\n" +
                        "\t\t\t\t\t\t\t<td>" + clue.source + "</td>\n" +
                        "\t\t\t\t\t\t\t<td>" + clue.owner + "</td>\n" +
                        "\t\t\t\t\t\t\t<td>" + clue.state + "</td>\n" +
                        "\t\t\t\t\t\t\t</tr>");

                }
                //count % pageSize == 0 ? count / pageSize : count / pageSize + 1
                $("#cluePage").bs_pagination({
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
        function queryClues() {
            refresh(1, 5);
        }

        //点击创建按钮，异步查询所有者信息
        function openCreateModal() {
            //手动弹出模态窗口 show hide
            $('#createClueModal').modal('show');
            $.get('${pageContext.request.contextPath}/workbench/clue/queryUsers', function (data) {
                //data:List<User>
                for (var i = 0; i < data.length; i++) {
                    var user = data[i];
                    $('#create-clueOwner').append("<option value=" + user.id + ">" + user.name + "</option>");
                }
            }, 'json');
        }

        //异步保存市场活动
        function saveClue() {
            //表单序列化 name=zhangsan&age=100 弊端:只能操作单个表(实体类)
            var form = $('#createForm').serialize();
            $.post("${pageContext.request.contextPath}/workbench/clue/saveOrUpdate", form, function (data) {
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
                $('#editClueModal').modal('show');
                //获取勾中的son元素
                var id = $($('.son:checked')[0]).val();
                //根据主键查询市场活动
                $.get('${pageContext.request.contextPath}/workbench/clue/queryById', {'id': id}, function (data) {
                    //data:Clue
                    var clue = data;
                    //把查询出来的市场活动的数据设置到页面上
                    $('#edit-clueOwner').text(clue.owner);
                    $('#edit-company').val(clue.company);
                    $('#edit-appellation').val(clue.appellation);
                    $('#edit-fullname').val(clue.fullname);
                    $('#edit-job').val(clue.job);
                    $('#edit-email').val(clue.email);
                    $('#edit-phone').val(clue.phone);
                    $('#edit-website').val(clue.website);
                    $('#edit-mphone').val(clue.mphone);
                    $('#edit-state').val(clue.state);
                    $('#edit-source').val(clue.source);
                    $('#edit-describe').val(clue.description);
                    $('#edit-contactSummary').val(clue.contactSummary);
                    $('#edit-nextContactTime').val(clue.nextContactTime);
                    $('#edit-address').val(clue.address);
                    //把市场活动主键设置到隐藏域中，不设置就会更新所有数据了
                    $('#id').val(clue.id);
                    //异步查询所有者数据
                    $.get('${pageContext.request.contextPath}/workbench/clue/queryUsers',function (data) {
                        //data:List<User>
                        for(var i = 0; i < data.length; i++){
                            var user = data[i];
                            $('#edit-clueOwner').append("<option value=" + user.id + ">" + user.name + "</option>");
                        }
                        //给定的值如果等于其中某个option的value值，就会自动的让该option选中
                        $('#edit-clueOwner').val(clue.owner);
                    },'json');
                }, 'json');
            }
        }

        function updateClue() {
            $.get('${pageContext.request.contextPath}/workbench/clue/saveOrUpdate', $('#updateForm').serialize(), function (data) {
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
                        $.get('${pageContext.request.contextPath}/workbench/clue/deleteBatch', {'ids': ids.join()}, function (data) {
                            //data:resultVo
                            if (data.ok) {
                                alert(data.message);
                                //刷新页面
                                refresh(1, 5);
                            }
                        }, 'json');
                    }
                });
            }
        }

    </script>
</body>
</html>