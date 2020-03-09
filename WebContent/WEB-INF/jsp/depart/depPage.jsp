<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style>
<!--
	thead, tbody, th, tr, td{
		text-align: center;
	}
-->
</style>
</head>
<body>
	<input type="hidden" id="msg" value="${msg }">
	
	

	<div class="row divtable">
	    <jsp:include page="/header.jsp"></jsp:include>
		<div id="content" class="col-md-10 col-xs-10 col-sm-10" style="padding-top: 0; margin: 0;">
			<div  style="margin-top: 30px;">
			<form class="form-inline" action="toDepPage">
					<input type="search" name="id" class="form-control" placeholder="请输入部门编号" value="${param.deptId }">
					<input type="search" name="depName" class="form-control" placeholder="请输入部门名称" value="${param.name }">
					<button type="submit" class="btn btn-primary">Search</button>
			</form>
			<div class="table-responsive"  style="margin-top: 20px;">
				<table class="table_list  table-condensed table-hover table-bordered  table-striped">
					<thead>
						<tr>
							<th>部门编号</th>
							<th>部门名称</th>
							<th>职工人数</th>
							<th>部门描述</th>
							<th>操作</th>
						</tr>	
					</thead>
					<tbody>
					<c:forEach items="${page.rows }" var="dep">
						<tr>
							<td>${dep.id }</td>
							<td>${dep.depName }</td>
							<td>${dep.empcount }</td>
							<td>${dep.introduction }</td>
							<td>
							<a href="deleteDep?id=${dep.id }">
							<button class="btn btn-primary">删除</button>　
							</a>
							<a href="toUpdateDep?id=${dep.id }">
							<button class="btn btn-primary">编辑</button>
							</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
					<tfoot>
						<tr >
							<td colspan="8" style="text-align: right;"> 
								<!-- 分页插件 -->
								<itheima:page url="${pageContext.request.contextPath }/toDepPage" />
	      					</td>
						</tr>
					</tfoot>
				</table>
			</div>
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
	
	
	
	
	<c:if test="${msg!=null}">
	<script type="text/javascript">
	var b = $("#msg").val();
	alert(b);
	</script>
	</c:if>
	
</body>

</html>










