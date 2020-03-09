<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="itheima" uri="http://itheima.com/common/" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>表格</title>
<base href="<%= request.getServletContext().getContextPath()%>/">
<link rel="shortcut icon" href="img/favicon.ico">
<!-- Bootstrap3.3.5 CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- datatime -->
<link href="bootstrap/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
</head>

<body>
	<div class="row">
		<jsp:include page="/header.jsp"></jsp:include>
		<div id="content" class="col-md-10 col-xs-10 col-sm-10"
			style="padding-top: 0; margin: 0;">
			<div style="padding-top: 20px;">
				<form action="toSubattList" class="form-inline">
					<label class="control-label">请选择部门：</label> 
					<select name="depId"
						class="form-control">
						<option	value="0" selected="selected">全部</option>
						<c:forEach items="${deps }" var="dep">		
						<option	value="${dep.id }">${dep.depName }</option>
						</c:forEach>
					</select> 
					<input type="search" name="empId" value="${param.empId }" class="form-control" placeholder="请输入职工ID">
					<label class="control-label">开始时间：</label> <span
						class="form-group has-feedback input-append date"
						id="datetimepicker1" data-date-format='yyyy-mm-dd'> <input
						class="form-control" name="beginTime" size="16" type="text">
						<span class="add-on form-control-feedback"><i
							class="icon-th glyphicon glyphicon-calendar"></i></span>
					</span> <label class="control-label">结束时间：</label> <span
						class="form-group has-feedback input-append date"
						id="datetimepicker2" data-date-format='yyyy-mm-dd'> <input
						class="form-control" name="endTime" size="16" type="text">
						<span class="add-on form-control-feedback"><i
							class="icon-th glyphicon glyphicon-calendar"></i></span>
					</span>
					<button type="submit" class="btn btn-primary">Search</button>
				</form>
				<table
					class="table table-condensed table-hover table-bordered  table-striped"
					style="margin-top: 20px;">
					<thead>
						<tr>
							<th>签到编号</th>
							<th>职工编号</th>
							<th>职工姓名</th>
							<th>部门编号</th>
							<th>所属部门</th>
							<th>打卡时间</th>
							<th>打卡状态</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.rows }" var="att">
						<tr>
							<td>${att.id }</td>
							<td>${att.empId }</td>
							<td>${att.emp.empName }</td>
							<td>${att.depId }</td>
							<td>${att.dep.depName }</td>
							<td><fmt:formatDate value="${att.attDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${att.attState }</td>
						</tr>
					</c:forEach>
						
					</tbody>
					<tfoot>
						<tr>
							<td colspan="7" style="text-align:right;">
								<!-- 分页插件 -->
								<itheima:page url="${pageContext.request.contextPath }/toSubattList" />
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
	<script src="js/jquery-3.2.1.min.js "></script>
	<script src="bootstrap/js/bootstrap.min.js "></script>
	<script type="text/javascript" src="js/date.js"></script>
	<script type="text/javascript"
		src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script>
		$(function() {
			$('#datetimepicker1').datetimepicker({
				format : 'yyyy-mm-dd',
				autoclose : true,
				minView : 2
			});
			$('#datetimepicker2').datetimepicker({
				format : 'yyyy-mm-dd',
				autoclose : true,
				minView : 2
			});
			var d = new Date();
			$("span>input[type='text']").val(d.toDefineString());
		});
	</script>
</body>

</html>

