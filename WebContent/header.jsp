<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header col-md-12 col-xs-12 col-sm-12">
	    		<img alt="" src="image/2020.png" style="height:85px; ">
	    	</div>
            <div class="col-md-2 col-xs-2 col-sm-2">
                <div class="panel-group table-responsive" role="tablist">
                
                <%-- <c:if test="${role=='admin' }"> --%>
                 <div class="panel panel-primary leftMenu">
                        <!-- 利用data-target指定要折叠的分组列表 -->
                        <div class="panel-heading" id="collapseListGroupHeading7" data-toggle="collapse" data-target="#collapseListGroup7" role="tab" >
                            <h4 class="panel-title">
                               个人信息中心
                                <span class="glyphicon glyphicon-menu-down right"></span>
                            </h4>
                        </div>
                        <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                        <div id="collapseListGroup7" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading7">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <!-- 利用data-target指定URL -->
                                <button class="menu-item-left" data-target="toPersonalPage">
                                    <span class="glyphicon glyphicon-triangle-right"></span>个人页面
                                </button>
                              </li>
                              <li class="list-group-item">
                                <!-- 利用data-target指定URL -->
                                <button class="menu-item-left" data-target="toChangePassword">
                                    <span class="glyphicon glyphicon-triangle-right"></span>修改密码
                                </button>
                              </li>
                              <li class="list-group-item">
                                <!-- 利用data-target指定URL -->
                                <button class="menu-item-left" data-target="logout">
                                    <span class="glyphicon glyphicon-triangle-right"></span>退出系统
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div>
                    
             <!-- ***************************************************************** -->       
                    
                
                    <div class="panel panel-primary leftMenu">
                        <!-- 利用data-target指定要折叠的分组列表 -->
                        <div class="panel-heading" id="collapseListGroupHeading1" data-toggle="collapse" data-target="#collapseListGroup1" role="tab" >
                            <h4 class="panel-title">
                               员工资料管理
                                <span class="glyphicon glyphicon-menu-up right"></span>
                            </h4>
                        </div>
                        <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                        <div id="collapseListGroup1" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading1">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <!-- 利用data-target指定URL    emp/empList.html -->
                                <button class="menu-item-left" data-target="toEmpPage">
                                    <span class="glyphicon glyphicon-triangle-right"></span>职工列表
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" data-target="${pageContext.request.contextPath }/toAddEmp">
                                    <span class="glyphicon glyphicon-triangle-right"></span>添加职工
                                </button> 
                              </li>
                            </ul>
                        </div>
                    </div><!--panel end-->
                    
                   
                    
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading2" data-toggle="collapse" data-target="#collapseListGroup2" role="tab" >
                            <h4 class="panel-title">
                                公司部门管理
                                <span class="glyphicon glyphicon-menu-up right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading2">
                            <ul class="list-group">
							  <li class="list-group-item">
                                <!-- 利用data-target指定URL -->
                                <button class="menu-item-left" data-target="toDepPage">
                                    <span class="glyphicon glyphicon-triangle-right"></span>部门列表
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" data-target="toAddDepPage">
                                    <span class="glyphicon glyphicon-triangle-right"></span>添加部门
                                </button> 
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" data-target="toRolePage">
                                    <span class="glyphicon glyphicon-triangle-right"></span>职位列表
                                </button> 
                              </li>
                                <li class="list-group-item">
                                <button class="menu-item-left" data-target="toAddRolePage">
                                    <span class="glyphicon glyphicon-triangle-right"></span>添加职位
                                </button> 
                              </li>
                            </ul>
                        </div>
                    </div>  
                    
                  <%--   </c:if> --%>
                	<div class="panel panel-primary leftMenu">
                        <!-- 利用data-target指定要折叠的分组列表 -->
                        <div class="panel-heading" id="collapseListGroupHeading3" data-toggle="collapse" data-target="#collapseListGroup3" role="tab" >
                            <h4 class="panel-title">
                               员工考勤管理
                                <span class="glyphicon glyphicon-menu-up right"></span>
                            </h4>
                        </div>
                        <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                        <div id="collapseListGroup3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading3">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <!-- 利用data-target指定URL -->
                              	<button class="menu-item-left" data-target="toAttendanceSimulator">
                                    <span class="glyphicon glyphicon-triangle-right"></span>考勤模拟器
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" data-target="toMainattList">
                                    <span class="glyphicon glyphicon-triangle-right"></span>考勤查询
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" data-target="toSubattList">
                                    <span class="glyphicon glyphicon-triangle-right"></span>考勤记录
                                </button>
                              </li>
                         
                            </ul>
                        </div>
                    </div>
               		
                   
                </div>
            </div>