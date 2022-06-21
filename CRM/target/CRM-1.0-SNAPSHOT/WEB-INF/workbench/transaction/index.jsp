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

	<!-- 创建交易的模态窗口 -->
	<div class="modal fade" id="createTranModal" role="dialog">
		<div class="modal-dialog" role="document" style="width: 85%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel1">创建交易</h4>
				</div>
				<div class="modal-body">
	
					<form class="form-horizontal" id="createForm" role="form">

						<div class="form-group">
							<label for="create-tranOwner" class="col-sm-2 control-label">所有者<span
									style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<select class="form-control" id="create-tranOwner" name="owner">
									<%--<option>zhangsan</option>
									<option>lisi</option>
									<option>wangwu</option>
									<option>zhaoliu</option>--%>
								</select>
							</div>
							<label for="create-tranName" class="col-sm-2 control-label">名称<span
									style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-tranName" name="name">
							</div>
						</div>

						<div class="form-group">
							<label for="create-money" class="col-sm-2 control-label">金额</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-money" name="money">
							</div>
							<label for="create-expectedTime" class="col-sm-2 control-label">预计时间</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-expectedTime" name="expectedTime">
							</div>
						</div>

						<div class="form-group">
							<label for="create-customerName" class="col-sm-2 control-label">客户名称</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-customerName" name="customerId">
							</div>
							<label for="create-stage" class="col-sm-2 control-label">阶段</label>
							<div class="col-sm-10" style="width: 300px;">
								<select class="form-control" id="create-stage" name="appellation">
									<option>---请选择---</option>
									<c:forEach items="${map['stage']}" var="stage">
										<option value="${stage.value}">${stage.text}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="create-possibility" class="col-sm-2 control-label">可能性</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-possibility" name="possibility">
							</div>
						</div>

						<div class="form-group">
							<label for="create-type" class="col-sm-2 control-label">类型</label>
							<div class="col-sm-10" style="width: 300px;">
								<select class="form-control" id="create-type" name="type">
									<option>---请选择---</option>
									<c:forEach items="${map['transactionType']}" var="type">
										<option value="${type.value}">${type.text}</option>
									</c:forEach>
								</select>
							</div>
							<label for="create-source" class="col-sm-2 control-label">来源</label>
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
							<label for="create-activityName" class="col-sm-2 control-label">市场活动名称</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-activityName" name="activityId">
							</div>
							<label for="create-contactName" class="col-sm-2 control-label">联系人名称</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-contactName" name="contactId">
							</div>
						</div>

						<div class="form-group">
							<label for="create-describe" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10" style="width: 81%;">
									<textarea class="form-control" rows="3" id="create-describe" name="description">

									</textarea>
							</div>
						</div>

						<div class="form-group">
							<label for="create-contactSummary" class="col-sm-2 control-label">联系纪要</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-contactSummary" name="contactSummary">
							</div>
							<label for="create-nextContactTime" class="col-sm-2 control-label">下次联系时间</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-nextContactTime" name="nextContactTime">
							</div>
						</div>
	
					</form>
	
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="saveTran()" data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 修改交易的模态窗口 -->
	<div class="modal fade" id="editTranModal" role="dialog">
		<div class="modal-dialog" role="document" style="width: 85%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel2">修改交易</h4>
				</div>
				<div class="modal-body">
	
					<form class="form-horizontal" id="updateForm" role="form">
						<input type="hidden" id="id" name="id">
						<div class="form-group">
							<label for="edit-tranOwner" class="col-sm-2 control-label">所有者<span
									style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<select class="form-control" id="edit-tranOwner" name="owner">
									<%--<option>zhangsan</option>
									<option>lisi</option>
									<option>wangwu</option>
									<option>zhaoliu</option>--%>
								</select>
							</div>
							<label for="edit-tranName" class="col-sm-2 control-label">名称<span
									style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-tranName" name="name">
							</div>
						</div>

						<div class="form-group">
							<label for="edit-money" class="col-sm-2 control-label">金额</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-money" name="money">
							</div>
							<label for="edit-expectedTime" class="col-sm-2 control-label">预计时间</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-expectedTime" name="expectedTime">
							</div>
						</div>

						<div class="form-group">
							<label for="edit-customerName" class="col-sm-2 control-label">客户名称</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-customerName" name="customerId">
							</div>
							<label for="edit-stage" class="col-sm-2 control-label">阶段</label>
							<div class="col-sm-10" style="width: 300px;">
								<select class="form-control" id="edit-stage" name="appellation">
									<option>---请选择---</option>
									<c:forEach items="${map['stage']}" var="stage">
										<option value="${stage.value}">${stage.text}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="edit-possibility" class="col-sm-2 control-label">可能性</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-possibility" name="possibility">
							</div>
						</div>
	
						<div class="form-group">
							<label for="edit-type" class="col-sm-2 control-label">类型</label>
							<div class="col-sm-10" style="width: 300px;">
								<select class="form-control" id="edit-type" name="type">
									<option>---请选择---</option>
									<c:forEach items="${map['transactionType']}" var="type">
										<option value="${type.value}">${type.text}</option>
									</c:forEach>
								</select>
							</div>
							<label for="edit-source" class="col-sm-2 control-label">来源</label>
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
							<label for="edit-activityName" class="col-sm-2 control-label">市场活动名称</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-activityName" name="activityId">
							</div>
							<label for="edit-contactName" class="col-sm-2 control-label">联系人名称</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-contactName" name="contactId">
							</div>
						</div>
	
						<div class="form-group">
							<label for="edit-describe" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10" style="width: 81%;">
									<textarea class="form-control" rows="3" id="edit-describe" name="description">
	
									</textarea>
							</div>
						</div>

						<div class="form-group">
							<label for="edit-contactSummary" class="col-sm-2 control-label">联系纪要</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-contactSummary" name="contactSummary">
							</div>
							<label for="edit-nextContactTime" class="col-sm-2 control-label">下次联系时间</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-nextContactTime" name="nextContactTime">
							</div>
						</div>
	
					</form>
	
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="updateTran()" data-dismiss="modal">更新
					</button>
				</div>
			</div>
		</div>
	</div>

	<div>
		<div style="position: relative; left: 10px; top: -10px;">
			<div class="page-header">
				<h3>交易列表</h3>
			</div>
		</div>
	</div>
	
	<div style="position: relative; top: -20px; left: 0px; width: 100%; height: 100%;">
	
		<div style="width: 100%; position: absolute;top: 5px; left: 10px;">
		
			<div class="btn-toolbar" role="toolbar" style="height: 80px;">
				<form class="form-inline" role="form" style="position: relative;top: 8%; left: 5px;">
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">所有者</div>
				      <input class="form-control" id="owner" type="text">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">名称</div>
				      <input class="form-control" id="name" type="text">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">客户名称</div>
				      <input class="form-control" id="customerId" type="text">
				    </div>
				  </div>
				  
				  <br>
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">阶段</div>
					  <select class="form-control" id="stage">
						  <option>---请选择---</option>
						  <c:forEach items="${map['stage']}" var="stage">
							  <option value="${stage.value}">${stage.text}</option>
						  </c:forEach>
					  </select>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">类型</div>
					  <select class="form-control" id="type">
						  <option>---请选择---</option>
						  <c:forEach items="${map['transactionType']}" var="type">
							  <option value="${type.value}">${type.text}</option>
						  </c:forEach>
					  </select>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">来源</div>
				      <select class="form-control" id="source">
						  <option>---请选择---</option>
						  <c:forEach items="${map['source']}" var="source">
							  <option value="${source.value}">${source.text}</option>
						  </c:forEach>
						</select>
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">联系人名称</div>
				      <input class="form-control" id="contactId" type="text">
				    </div>
				  </div>
				  
				  <button type="button" class="btn btn-default" onclick="queryTrans()">查询</button>
				  
				</form>
			</div>
			<div class="btn-toolbar" role="toolbar" style="background-color: #F7F7F7; height: 50px; position: relative;top: 10px;">
				<div class="btn-group" style="position: relative; top: 18%;">
				  <button type="button" class="btn btn-primary" onclick="openCreateModal()"><span class="glyphicon glyphicon-plus"></span> 创建</button>
				  <button type="button" class="btn btn-default" onclick="openEditModal()"><span class="glyphicon glyphicon-pencil"></span> 修改</button>
				  <button type="button" class="btn btn-danger" onclick="deleteBatch()"><span class="glyphicon glyphicon-minus"></span> 删除</button>
				</div>
				
				
			</div>
			<div style="position: relative;top: 10px;">
				<table class="table table-hover">
					<thead>
						<tr style="color: #B3B3B3;">
							<td><input id="father" type="checkbox" /></td>
							<td>名称</td>
							<td>客户名称</td>
							<td>阶段</td>
							<td>类型</td>
							<td>所有者</td>
							<td>来源</td>
							<td>联系人名称</td>
						</tr>
					</thead>
					<tbody id="tranBody">
						<%--<tr>
							<td><input type="checkbox" /></td>
							<td><a style="text-decoration: none; cursor: pointer;" onclick="window.location.href='detail.jsp';">动力节点-交易01</a></td>
							<td>动力节点</td>
							<td>谈判/复审</td>
							<td>新业务</td>
							<td>zhangsan</td>
							<td>广告</td>
							<td>李四</td>
						</tr>--%>
					</tbody>
				</table>
			</div>
			
			<div style="height: 50px; position: relative;top: 20px;">
				<div id="tranPage"></div>
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
			$.get("${pageContext.request.contextPath}/workbench/tran/list", {
				'pageNum': pageNum,//当前页码
				'pageSize': pageSize,//每页记录数
				'name': $('#name').val(),//交易名称
				'customerId': $('#customerId').val(),//开始时间
				'stage': $('#stage').val(),//结束时间
				'type': $('#type').val(),//结束时间
				'owner': $('#owner').val(),//所有者
				'source': $('#source').val(),//结束时间
				'contactId': $('#contactId').val(),//结束时间
			}, function (data) {
				//data:PageInfo
				//清空数据
				$('#tranBody').html("");
				var trans = data.list;
				for (var i = 0; i < trans.length; i++) {
					var tran = trans[i];
					$('#tranBody').append("<tr class=\"active\">\n" +
							"\t\t\t\t\t\t\t<td><input class='son' onclick='check()' value=" + tran.id + " type=\"checkbox\" /></td>\n" +
							"\t\t\t\t\t\t\t<td><a style=\"text-decoration: none; cursor: pointer;\" onclick=\"javascript:window.location.href='${pageContext.request.contextPath}/toView/workbench/transaction/detail?id=" + tran.id + "';\">" + tran.name + "</a></td>\n" +
							"\t\t\t\t\t\t\t<td>" + tran.customerId + "</td>\n" +
							"\t\t\t\t\t\t\t<td>" + tran.stage + "</td>\n" +
							"\t\t\t\t\t\t\t<td>" + tran.type + "</td>\n" +
							"\t\t\t\t\t\t\t<td>" + tran.owner + "</td>\n" +
							"\t\t\t\t\t\t\t<td>" + tran.source + "</td>\n" +
							"\t\t\t\t\t\t\t<td>" + tran.contactId + "</td>\n" +
							"\t\t\t\t\t\t\t</tr>");

				}
				//count % pageSize == 0 ? count / pageSize : count / pageSize + 1
				$("#tranPage").bs_pagination({
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

		$("#create-expectedTime").datetimepicker({
			language: "zh-CN",
			format: "yyyy-mm-dd",	//显示格式
			minView: "month",	//设置只显示到月份
			initialDate: new Date(),	//初始化当前日期
			autoclose: true,	//选中自动关闭
			todayBtn: true,	//显示今日按钮
			clearBtn: true,
			pickerPosition: "bottom-left"
		});

		$("#edit-expectedTime").datetimepicker({
			language: "zh-CN",
			format: "yyyy-mm-dd",	//显示格式
			minView: "month",	//设置只显示到月份
			initialDate: new Date(),	//初始化当前日期
			autoclose: true,	//选中自动关闭
			todayBtn: true,	//显示今日按钮
			clearBtn: true,
			pickerPosition: "bottom-left"
		});

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
		function queryTrans() {
			refresh(1, 5);
		}

		//点击创建按钮，异步查询所有者信息
		function openCreateModal() {
			//手动弹出模态窗口 show hide
			$('#createTranModal').modal('show');
			$.get('${pageContext.request.contextPath}/workbench/tran/queryUsers', function (data) {
				//data:List<User>
				for (var i = 0; i < data.length; i++) {
					var user = data[i];
					$('#create-tranOwner').append("<option value=" + user.id + ">" + user.name + "</option>");
				}
			}, 'json');
		}

		//异步保存交易
		function saveTran() {
			//表单序列化 name=zhangsan&age=100 弊端:只能操作单个表(实体类)
			var form = $('#createForm').serialize();
			$.post("${pageContext.request.contextPath}/workbench/tran/saveOrUpdate", form, function (data) {
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
				//发送请求，根据主键查询出当前交易数据
				$('#editTranModal').modal('show');
				//获取勾中的son元素
				var id = $($('.son:checked')[0]).val();
				//根据主键查询交易
				$.get('${pageContext.request.contextPath}/workbench/tran/queryById', {'id': id}, function (data) {
					//data:Tran
					var tran = data;
					//把查询出来的交易的数据设置到页面上
					$('#edit-tranOwner').val(tran.owner);
					$('#edit-tranName').val(tran.name);
					$('#edit-money').val(tran.money);
					$('#edit-expectedTime').val(tran.expectedTime);
					$('#edit-customerName').val(tran.customerId);
					$('#edit-stage').val(tran.stage);
					$('#edit-possibility').val(tran.possibility);
					$('#edit-type').val(tran.type);
					$('#edit-source').val(tran.source);
					$('#edit-activityName').val(tran.activityId);
					$('#edit-contactName').val(tran.contactId);
					$('#edit-describe').val(tran.description);
					$('#edit-contactSummary').val(tran.contactSummary);
					$('#edit-nextContactTime').val(tran.nextContactTime);
					//把交易主键设置到隐藏域中，不设置就会更新所有数据了
					$('#id').val(tran.id);
					//异步查询所有者数据
					$.get('${pageContext.request.contextPath}/workbench/tran/queryUsers',function (data) {
						//data:List<User>
						for(var i = 0; i < data.length; i++){
							var user = data[i];
							$('#edit-tranOwner').append("<option value=" + user.id + ">" + user.name + "</option>");
						}
						//给定的值如果等于其中某个option的value值，就会自动的让该option选中
						$('#edit-tranOwner').val(tran.owner);
					},'json');
				}, 'json');
			}
		}

		function updateTran() {
			$.get('${pageContext.request.contextPath}/workbench/tran/saveOrUpdate', $('#updateForm').serialize(), function (data) {
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
						$.get('${pageContext.request.contextPath}/workbench/tran/deleteBatch', {'ids': ids.join()}, function (data) {
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

	</script>
</body>
</html>