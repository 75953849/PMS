<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<div id="ftdiv">
				<!-- <form class="form-horizontal" action="addEmp" method="post" enctype="multipart/form-data"> -->
				<form class="form-horizontal" action="addEmp" method="post"
					enctype="application/x-www-form-urlencoded">
					<fieldset>
						<legend>注册新员工</legend>
						<div class="form-group has-feedback">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">职工姓名:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<input type="text" name="empName" class="form-control">
								<span class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
						<input type="hidden" name="password" value="123456" />
						</div>
						<div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">性别:</label>
							<div class="col-md-4 col-xs-4 col-sm-4 radio">
								<label> <input type="radio" name="gender" value="男">男
								</label> <label> <input type="radio" name="gender" value="女">女
								</label>
							</div>
						</div>
						<div class="form-group has-feedback">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">出生日期:</label>
							<div class="col-md-4 col-xs-4 col-sm-4 input-append date"
								id="datetimepicker1" data-date-format="yyyy-mm-dd">
								<input class="form-control" size="16" type="text"
									name="birthday"> <span
									class="add-on form-control-feedback"><i
									class="icon-th glyphicon glyphicon-calendar"></i></span>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">个人邮箱:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<input type="text" name="email" class="form-control">
							</div>

						</div>
						<div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">个人电话:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<input type="text" name="tel" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">所属部门:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<select id="depId" name="depId" class="form-control" onchange="roleJson()">
									<option value="-1">请选择</option>
								<c:forEach items="${deps }" var="dep">
									<option value="${dep.id }">${dep.depName }</option>
								</c:forEach>
									
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">职
								位:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<select class="form-control" id="role" name="impRoleId">
									<option value="-1">请选择</option>
								</select>
							</div>
						</div>
						
						<!-- <div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">头     像:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<input type="file" name="icon">
							</div>
					</div> -->
					</fieldset>
					<fieldset>
						<legend>个人简历</legend>
						<div class="form-group">
							<label class="control-label col-md-1 col-xs-1 col-sm-1"></label>
							<div class="col-md-5 col-xs-5 col-sm-5">
								<textarea class="form-control" rows="5" cols="68" name="info"></textarea>
							</div>
						</div>
					</fieldset>
					<div class="form-group col-md-7 col-xs-7 col-sm-7"
						style="text-align: center;">
						<input type="submit" class="btn btn-success" value="提 交" />
					</div>
				</form>
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
		
	<!-- 联动 -->
	<script type="text/javascript">
	function roleJson(){
			var depId=$("#depId").val();
			$("#role option").remove();
			
	
			 $.ajax({
				url:"${pageContext.request.contextPath}/roleJson",
				type:"post",
				data:JSON.stringify({depId:depId}),
				contentType:"application/json;charset=UTF-8",
				dataType:"json",
				success:function(data){
					
					for(i in data){
					/* 	var a={"signDay":data[i].signDay,"status":data[i].status};
						signList.push(a); */
					
						
						$("#role").append("<option value='"+data[i].id+"'>"+data[i].roleName+"</option>");
						
					}
				},
				error:function(){
				alert("error");
				}
			}); 
			
	}
	
	</script>
	
</body>

</html>

