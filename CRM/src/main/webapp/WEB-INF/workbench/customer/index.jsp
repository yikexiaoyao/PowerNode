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

			//定制字段
			$("#definedColumns > li").click(function(e) {
				//防止下拉菜单消失
				e.stopPropagation();
			});

		});

	</script>
</head>
<body>

	<!-- 创建客户的模态窗口 -->
	<div class="modal fade" id="createCustomerModal" role="dialog">
		<div class="modal-dialog" role="document" style="width: 85%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel1">创建客户</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="createForm" role="form">
					
						<div class="form-group">
							<label for="create-customerOwner" class="col-sm-2 control-label">所有者<span style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<select class="form-control" id="create-customerOwner" name="owner">

								</select>
							</div>
							<label for="create-customerName" class="col-sm-2 control-label">名称<span style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-customerName" name="name">
							</div>
						</div>
						
						<div class="form-group">
                            <label for="create-website" class="col-sm-2 control-label">公司网站</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="create-website" name="website">
                            </div>
							<label for="create-phone" class="col-sm-2 control-label">公司座机</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="create-phone" name="phone">
							</div>
						</div>
						<div class="form-group">
							<label for="create-describe" class="col-sm-2 control-label">描述</label>
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
                                <label for="create-address1" class="col-sm-2 control-label">详细地址</label>
                                <div class="col-sm-10" style="width: 81%;">
                                    <textarea class="form-control" rows="1" id="create-address1" name="address"></textarea>
                                </div>
                            </div>
                        </div>
					</form>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="saveCustomer()">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 修改客户的模态窗口 -->
	<div class="modal fade" id="editCustomerModal" role="dialog">
		<div class="modal-dialog" role="document" style="width: 85%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改客户</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="updateForm" role="form">
						<input type="hidden" name="id" id="id">
						<div class="form-group">
							<label for="edit-customerOwner" class="col-sm-2 control-label">所有者<span style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<select class="form-control" id="edit-customerOwner" name="owner">

								</select>
							</div>
							<label for="edit-customerName" class="col-sm-2 control-label">名称<span style="font-size: 15px; color: red;">*</span></label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-customerName" name="name">
							</div>
						</div>
						
						<div class="form-group">
                            <label for="edit-website" class="col-sm-2 control-label">公司网站</label>
                            <div class="col-sm-10" style="width: 300px;">
                                <input type="text" class="form-control" id="edit-website" name="website">
                            </div>
							<label for="edit-phone" class="col-sm-2 control-label">公司座机</label>
							<div class="col-sm-10" style="width: 300px;">
								<input type="text" class="form-control" id="edit-phone" name="phone">
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
                                <label for="create-contactSummary1" class="col-sm-2 control-label">联系纪要</label>
                                <div class="col-sm-10" style="width: 81%;">
                                    <textarea class="form-control" rows="3" id="create-contactSummary1" name="contactSummary"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="create-nextContactTime2" class="col-sm-2 control-label">下次联系时间</label>
                                <div class="col-sm-10" style="width: 300px;">
                                    <input type="text" class="form-control" id="create-nextContactTime2" name="nextContactTime">
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
					<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="updateCustomer()">更新</button>
				</div>
			</div>
		</div>
	</div>

	<div>
		<div style="position: relative; left: 10px; top: -10px;">
			<div class="page-header">
				<h3>客户列表</h3>
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
				      <div class="input-group-addon">公司座机</div>
				      <input class="form-control" id="phone" type="text">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon">公司网站</div>
				      <input class="form-control" id="website" type="text">
				    </div>
				  </div>
				  
				  <button type="button" class="btn btn-default" onclick="queryCustomers()">查询</button>
				  
				</form>
			</div>
			<div class="btn-toolbar" role="toolbar" style="background-color: #F7F7F7; height: 50px; position: relative;top: 5px;">
				<div class="btn-group" style="position: relative; top: 18%;">
				  <button type="button" class="btn btn-primary" data-toggle="modal" onclick="openCreateModal()"><span class="glyphicon glyphicon-plus"></span> 创建</button>
				  <button type="button" class="btn btn-default" data-toggle="modal" onclick="openEditModal()"><span class="glyphicon glyphicon-pencil"></span> 修改</button>
				  <button type="button" class="btn btn-danger" onclick="deleteBatch()"><span class="glyphicon glyphicon-minus"></span> 删除</button>
				</div>
				
			</div>
			<div style="position: relative;top: 10px;">
				<table class="table table-hover">
					<thead>
						<tr style="color: #B3B3B3;">
							<td><input id="father" type="checkbox" /></td>
							<td>名称</td>
							<td>所有者</td>
							<td>公司座机</td>
							<td>公司网站</td>
						</tr>
					</thead>
					<tbody id="customerBody">
						<%--<tr>
							<td><input type="checkbox" /></td>
							<td><a style="text-decoration: none; cursor: pointer;" onclick="window.location.href='detail.jsp';">动力节点</a></td>
							<td>zhangsan</td>
							<td>010-84846003</td>
							<td>http://www.bjpowernode.com</td>
						</tr>--%>
					</tbody>
				</table>
			</div>
			
			<div style="height: 50px; position: relative;top: 30px;">
				<div id="customerPage"></div>
			</div>
			
		</div>
		
	</div>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/bs_pagination/jquery.bs_pagination.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/bs_pagination/en.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bs_pagination/jquery.bs_pagination.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js"></script>
	<script>

		(function($){
			$.fn.datetimepicker.dates['zh-CN'] = {
				days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
				daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
				daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
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
		function refresh(pageNum,pageSize) {
			$.get("${pageContext.request.contextPath}/workbench/customer/list",{
				'pageNum' : pageNum,//当前页码
				'pageSize' : pageSize,//每页记录数
				'name' : $('#name').val(),//客户名称
				'owner' : $('#owner').val(),//所有者
				'phone' : $('#phone').val(),//开始时间
				'website' : $('#website').val(),//结束时间
			},function (data) {
				//data:PageInfo
				//清空数据
				$('#customerBody').html("");
				var customers = data.list;
				for(var i = 0; i < customers.length; i++){
					var customer = customers[i];
					$('#customerBody').append("<tr class=\"active\">\n" +
							"\t\t\t\t\t\t\t<td><input class='son' onclick='check()' value="+customer.id+" type=\"checkbox\" /></td>\n" +
							"\t\t\t\t\t\t\t<td><a style=\"text-decoration: none; cursor: pointer;\" onclick=\"javascript:window.location.href='${pageContext.request.contextPath}/toView/workbench/customer/detail?id="+customer.id+"';\">"+customer.name+"</a></td>\n" +
							"                            <td>"+customer.owner+"</td>\n" +
							"\t\t\t\t\t\t\t<td>"+customer.phone+"</td>\n" +
							"\t\t\t\t\t\t\t<td>"+customer.website+"</td>\n" +
							"\t\t\t\t\t\t</tr>");

				}
				//count % pageSize == 0 ? count / pageSize : count / pageSize + 1
				$("#customerPage").bs_pagination({
					currentPage: data.pageNum, // 页码
					rowsPerPage: data.pageSize, // 每页显示的记录条数 pageSize
					maxRowsPerPage: 50, // 每页最多显示的记录条数
					totalPages: data.pages, // 总页数
					totalRows: data.total, // 总记录条数
					visiblePageLinks: 5, // 显示几个卡片
					showGoToPage: true,
					showRowsPerPage: true,
					showRowsInfo: true,
					showRowsDefaultInfo: true,
					/*onChangePage:每次操作分页插件，都会出发该函数*/
					onChangePage : function(event, obj){
						refresh(obj.currentPage,obj.rowsPerPage);
					}
				});
			},'json');

		}

		refresh(1,5);

		//点击查询按钮，异步查询
		function queryCustomers() {
			refresh(1,5);
		}

		//点击创建按钮，异步查询所有者信息
		function openCreateModal() {
			//手动弹出模态窗口 show hide
			$('#createCustomerModal').modal('show');

			$.get('${pageContext.request.contextPath}/workbench/customer/queryUsers',function (data) {
				//data:List<User>
				for(var i = 0; i < data.length; i++){
					var user = data[i];
					$('#create-customerOwner').append("<option value="+user.id+">"+user.name+"</option>");
				}
			},'json');
		}

		//异步保存客户
		function saveCustomer() {
			//表单序列化  name=zhangsan&age=100 弊端:只能操作单个表(实体类)
			var form = $('#createForm').serialize();
			$.post("${pageContext.request.contextPath}/workbench/customer/saveOrUpdate",form,function (data) {
				//data:resultVo
				if(data.ok){
					alert(data.message);
					//刷新页面
					refresh(1,5);
					//重置表单
					document.querySelector("#createForm").reset();
				}
			},'json');
		}

		//全选和反选
		$('#father').click(function () {
			$('.son').prop('checked',$(this).prop('checked'));
		})

		//son勾中决定father是否勾中
		function check() {
			//获取勾中的son的个数
			var checkedLength = $('.son:checked').length;
			//获取所有son的个数
			var length = $('.son').length;
			if(checkedLength == length){
				$('#father').prop('checked',true);
			}else{
				$('#father').prop('checked',false);
			}
		}

		//异步修改
		function openEditModal() {
			var checkedLength = $('.son:checked').length;
			if(checkedLength == 0){
				alert("至少操作数据")
			}else if(checkedLength > 1){
				alert("只能操作一条数据")
			}else{
				//发送请求，根据主键查询出当前客户数据
				$('#editCustomerModal').modal('show');

				//获取勾中的son元素
				var id = $($('.son:checked')[0]).val();
				//根据主键查询客户
				$.get('${pageContext.request.contextPath}/workbench/customer/queryById',{'id':id},function (data) {
					//data:Customer
					var customer = data;
					//把查询出来的客户的数据设置到页面上
					$('#edit-customerName').val(customer.name);
					$('#edit-website').val(customer.website);
					$('#edit-phone').val(customer.phone);
					$('#edit-describe').val(customer.description);
					$('#edit-contactSummary').val(customer.contactSummary);
					$('#edit-nextContactTime').val(customer.nextContactTime);
					//把客户主键设置到隐藏域中，不设置就会更新所有数据了
					$('#id').val(customer.id);
					//异步查询所有者数据
					$.get('${pageContext.request.contextPath}/workbench/customer/queryUsers',function (data) {
						//data:List<User>
						for(var i = 0; i < data.length; i++){
							var user = data[i];
							$('#edit-customerOwner').append("<option value="+user.id+">"+user.name+"</option>");
						}
						//给定的值如果等于其中某个option的value值，就会自动的让该option选中
						$('#edit-customerOwner').val(customer.owner);
					},'json')
				},'json');
			}
		}

		function updateCustomer() {
			$.get('${pageContext.request.contextPath}/workbench/customer/saveOrUpdate',$('#updateForm').serialize(),function (data) {
				//data:resultVo
				if(data.ok){
					alert(data.message);
					//刷新页面数据
					refresh(1,5);
				}
			},'json');
		}

		//批量删除
		function deleteBatch() {
			//获取勾中的son的个数
			var checkedLength = $('.son:checked').length;
			if(checkedLength == 0){
				alert("至少选中一条记录")
			}else{
				layer.alert("确定删除勾中的"+checkedLength+"条数据吗？", {
					time: 0 //不自动关闭
					,btn: ['确定', '取消']
					,yes: function(index){
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
						$.get('${pageContext.request.contextPath}/workbench/customer/deleteBatch',{'ids':ids.join()},function (data) {
							//data:resultVo
							if(data.ok){
								alert(data.message);
								//刷新页面
								refresh(1,5);
							}
						},'json');
					}
				});
			}
		}
	</script>
</body>
</html>