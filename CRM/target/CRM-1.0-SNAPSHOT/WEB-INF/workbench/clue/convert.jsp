<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap_3.3.0/css/bootstrap.min.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap_3.3.0/js/bootstrap.min.js"></script>


<link href="${pageContext.request.contextPath}/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}jquery/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>

<script type="text/javascript">
	$(function(){
		$("#isCreateTransaction").click(function(){
			if(this.checked){
				$("#create-transaction2").show(200);
			}else{
				$("#create-transaction2").hide(200);
			}
		});
	});
</script>

</head>
<body>

	<!-- 搜索市场活动的模态窗口 -->
	<div class="modal fade" id="searchActivityModal" role="dialog" >
		<div class="modal-dialog" role="document" style="width: 90%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">搜索市场活动</h4>
				</div>
				<div class="modal-body">
					<div class="btn-group" style="position: relative; top: 18%; left: 8px;">
						<div class="form-group has-feedback">
							<input type="text" class="form-control" id="name" style="width: 300px;" placeholder="请输入市场活动名称，支持模糊查询">
							<span class="glyphicon glyphicon-search form-control-feedback"></span>
						</div>
					</div>
					<table id="activityTable" class="table table-hover" style="width: 900px; position: relative;top: 10px;">
						<thead>
						<tr style="color: #B3B3B3;">
							<td></td>
							<td>名称</td>
							<td>开始日期</td>
							<td>结束日期</td>
							<td>所有者</td>
							<td></td>
						</tr>
						</thead>
						<tbody id="activityBody">
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="relate()" data-dismiss="modal">关联</button>
				</div>
			</div>
		</div>
	</div>

	<div id="title" class="page-header" style="position: relative; left: 20px;">
		<h4>转换线索 <small id="content"></small></h4>
	</div>
	<div id="create-customer" style="position: relative; left: 40px; height: 35px;">
		新建客户：动力节点
	</div>
	<div id="create-contact" style="position: relative; left: 40px; height: 35px;">
		新建联系人：李四先生
	</div>
	<div id="create-transaction1" style="position: relative; left: 40px; height: 35px; top: 25px;">
		<input type="checkbox" id="isCreateTransaction" value="0" />
		为客户创建交易
	</div>
	<div id="create-transaction2" style="position: relative; left: 40px; top: 20px; width: 80%; background-color: #F7F7F7; display: none;" >

		<div class="form-group" style="width: 400px; position: relative; left: 20px;">
			<label for="amountOfMoney">金额</label>
			<input type="text" class="form-control" id="amountOfMoney">
		</div>
		<div class="form-group" style="width: 400px;position: relative; left: 20px;">
			<label for="tradeName">交易名称</label>
			<input type="text" class="form-control" id="tradeName" value="动力节点-">
		</div>
		<div class="form-group" style="width: 400px;position: relative; left: 20px;">
			<label for="expectedClosingDate">预计成交日期</label>
			<input type="text" class="form-control" id="expectedClosingDate">
		</div>
		<div class="form-group" style="width: 400px;position: relative; left: 20px;">
			<label for="stage">阶段</label>
			<select id="stage"  class="form-control">
				<c:forEach items="${map['stage']}" var="stage">
					<option value="${stage.value}">${stage.text}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group" style="width: 400px;position: relative; left: 20px;">
			<label for="activity">市场活动源&nbsp;&nbsp;<a href="javascript:void(0);" data-toggle="modal" data-target="#searchActivityModal" style="text-decoration: none;"><span class="glyphicon glyphicon-search"></span></a></label>
			<input type="hidden" id="id" />
			<%--
				readonly:只读
				disabled:不能提交表单数据
			--%>
			<input type="text" class="form-control" id="activity" placeholder="点击上面搜索" readonly>
		</div>

	</div>

	<div id="owner" style="position: relative; left: 40px; height: 35px; top: 50px;">
		记录的所有者：<br>
		<b>zhangsan</b>
	</div>
	<div id="operation" style="position: relative; left: 40px; height: 35px; top: 100px;">
		<input class="btn btn-primary" onclick="convert()" type="button" value="转换">
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="btn btn-default" type="button" value="取消">
	</div>

	<script>
		//改变是否发生交易状态
		$('#isCreateTransaction').click(function () {
			if($(this).prop('checked')){
				$(this).val("1");
			}else{
				$(this).val("0");
			}
		});

		//异步查询线索数据
		$.get('${pageContext.request.contextPath}/workbench/clue/toConvert',{'id':'${id}'},function (data) {
			//data:Clue text() html()
			$('#content').html(data.fullname + "-" + data.company);
		},'json');

		//转换
		function convert() {
			$.post('${pageContext.request.contextPath}/workbench/clue/convert',{
				'id' : '${id}',	//线索id
				'isCreateTransaction' : $('#isCreateTransaction').val(),	//是否发生交易

				//交易的表单数据
				'money' : $('#amountOfMoney').val(),
				'name' : $('#tradeName').val(),
				'expectedDate' : $('#expectedClosingDate').val(),
				'stage' : $('#stage').val(),
				'activityId' : $('#id').val(),
			},function (data) {
				//data:resultVo
				if(data.ok){
					alert(data.message);
				}
			},'json');
		}

		//异步查询市场活动,只能查询线索已经关联的市场活动
		$('#name').keypress(function (event) {
			if(event.keyCode == 13){
				$.get('${pageContext.request.contextPath}/workbench/clue/queryRelationActivities',{
					'name' : $(this).val(),
					'id' : '${id}'
				},function (data) {
					//data:List<Activity>
					$('#activityBody').html("");
					var activities = data;
					for(var i in activities){
						var activity = activities[i];
						$('#activityBody').append("<tr>\n" +
								"\t\t\t\t\t\t\t\t<td><input class='son' type=\"radio\" value="+activity.id+" /></td>\n" +
								"\t\t\t\t\t\t\t\t<td>"+activity.name+"</td>\n" +
								"\t\t\t\t\t\t\t\t<td>"+activity.startTime+"</td>\n" +
								"\t\t\t\t\t\t\t\t<td>"+activity.endTime+"</td>\n" +
								"\t\t\t\t\t\t\t\t<td>"+activity.owner+"</td>\n" +
								"\t\t\t\t\t\t\t</tr>");
					}
				},'json');
			}
		});

		//异步关联交易指定的市场活动
		function relate() {
			//获取勾中的市场活动
			var $son = $($('.son:checked')[0]);
			var id = $son.val();
			//把id设置到页面表单中的隐藏域中
			$('#id').val(id);

			//找到市场活动名字的那个td next:查找紧邻的兄弟节点
			var name = $son.parent().next().text();
			//把获取的市场活动名字设置文本框中给用户看
			$('#activity').val(name);
		}
	</script>
</body>
</html>