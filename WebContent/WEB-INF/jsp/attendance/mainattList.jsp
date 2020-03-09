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
				注：mainatt表中可以加一个日期项 ，记录日期（年月日即可）,用于根据日期的检索操作
				<br/>
				State栏可以使用Varchar类型来实现，直接计入迟到早退等msg信息
				<br/>
				检索与subatt类似，因为未加入日期，根据日期检索较困难，暂不实现
				
				<table
					class="table table-condensed table-hover table-bordered  table-striped"
					style="margin-top: 20px;">
					<thead>
						<tr>
							<th>职工编号</th>
							<th>职工姓名</th>
							<th>所属部门</th>
							<th>上午上班</th>
							<th>上午下班</th>
							<th>上午状态</th>
							<th>下午上班</th>
							<th>下午下班</th>
							<th>下午状态</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.rows }" var="att">
						<tr>
							<td>${att.empId }</td>
							<td>${att.emp.empName }</td>
							<td>${att.dep.depName }</td>
							<td><fmt:formatDate value="${att.subatt1.attDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							
							<td><fmt:formatDate value="${att.subatt2.attDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${att.amState }</td>
							<td><fmt:formatDate value="${att.subatt3.attDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td><fmt:formatDate value="${att.subatt4.attDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${att.pmState }</td>
						</tr>
					</c:forEach>
						
					</tbody>
					<tfoot>
						<tr>
							<td colspan="9" style="text-align:right;">
								<!-- 分页插件 -->
								<itheima:page url="${pageContext.request.contextPath }/toMainattList" />
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

