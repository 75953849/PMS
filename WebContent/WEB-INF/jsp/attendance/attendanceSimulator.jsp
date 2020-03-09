<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance Simulator</title>
</head>
<body>
	${msg }
	<h3>上午上班打卡</h3>
	<form action="signIn1" method="post">
		emp_id:<input type="text" name="empId" /><br/>
		dep_id:<input type="text" name="depId" /><br/>
		AttendanceDate:<input type="text" name="attDate" /><br/>
		<input type="submit" value="提交" /><br/>
	</form>
	<h3>上午下班打卡</h3>
	<form action="signIn2" method="post">
		emp_id:<input type="text" name="empId" /><br/>
		dep_id:<input type="text" name="depId" /><br/>
		AttendanceDate:<input type="text" name="attDate" /><br/>
		<input type="submit" value="提交" /><br/>
	</form>
	<h3>下午上班打卡</h3>
	<form action="signIn3" method="post">
		emp_id:<input type="text" name="empId" /><br/>
		dep_id:<input type="text" name="depId" /><br/>
		AttendanceDate:<input type="text" name="attDate" /><br/>
		<input type="submit" value="提交" /><br/>
	</form>
	<h3>下午下班打卡</h3>
	<form action="signIn4" method="post">
		emp_id:<input type="text" name="empId" /><br/>
		dep_id:<input type="text" name="depId" /><br/>
		AttendanceDate:<input type="text" name="attDate" /><br/>
		<input type="submit" value="提交" /><br/>
	</form>
	
</body>
</html>