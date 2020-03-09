package com.tyut.service;

import java.text.ParseException;

import com.tyut.common.utils.Page;
import com.tyut.po.Attendance;
import com.tyut.po.AttendanceItem;
import com.tyut.po.Mainatt;
import com.tyut.po.Subatt;
import com.tyut.po.SubattSearchItem;

public interface AttendanceService {
	//可分页可搜索且包含全部对象
//	public Page<Attendance> findAllAttendanceByMappingPage(int page, int rows,Attendance att);
	//处理插入AttendanceItem   成功返回1   失败返回0
	
/*	public int insertOrUpdateAttendanceItemWithWorkInTheMorning(Subatt subatt) throws ParseException;
	public int insertOrUpdateAttendanceItemWithWorkInTheAfternoon(Subatt subatt);
	public int insertOrUpdateAttendanceItemWithoutWorkInTheMorning(Subatt subatt);
	public int insertOrUpdateAttendanceItemWithoutWorkInTheAfternoon(Subatt subatt);*/
	
	public int addAttendanceItemWithWorkInTheMorning(Subatt subatt);
	public int addAttendanceItemWithWorkInTheAfternoon(Subatt subatt);
	public int addAttendanceItemWithoutWorkInTheMorning(Subatt subatt);
	public int addAttendanceItemWithoutWorkInTheAfternoon(Subatt subatt);

	public Page<Subatt> findAllSubattWithMappingPage(int page,int rows,SubattSearchItem ssi);
	public Page<Mainatt> findAllMainattWithMappingPage(int page,int rows);
}
