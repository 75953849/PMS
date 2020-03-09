package com.tyut.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyut.common.utils.Page;
import com.tyut.po.Department;
import com.tyut.po.Mainatt;
import com.tyut.po.Subatt;
import com.tyut.po.SubattSearchItem;
import com.tyut.service.AttendanceService;
import com.tyut.service.DepartmentService;

@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	@Autowired
	private DepartmentService departmentService; 

	@RequestMapping("/toSubattList")
	public String toSubattList(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="2") Integer rows,SubattSearchItem ssi,HttpServletRequest req) {
	
		
		
		Page<Subatt> subatts = attendanceService.findAllSubattWithMappingPage(page, rows, ssi);
		
		List<Department> deps = departmentService.findAllDepartment();
		System.out.println(deps);
		req.setAttribute("page", subatts);
		req.setAttribute("deps", deps);
		
		return "attendance/subattList";
	}
	
	
	
	@RequestMapping("/toMainattList")
	public String toMainattList(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="2") Integer rows,HttpServletRequest req) {
		
		
		Page<Mainatt> mainatts = attendanceService.findAllMainattWithMappingPage(page, rows);
		req.setAttribute("page", mainatts);
		
		
		
		return "attendance/mainattList";
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping("/toAttendanceSimulator")
	public String toAttendanceSimulator() {
		return "attendance/attendanceSimulator";
	}

	@RequestMapping("/signIn1")
	public String signIn1(Subatt subatt,Model model) {
			
				int flag = attendanceService.addAttendanceItemWithWorkInTheMorning(subatt);
				if(flag==10) {
					model.addAttribute("msg","超过了签到时间7：30到8：30");
				}else if(flag==100) {
					model.addAttribute("msg","今天上午已经签到过了");
				}else {
					model.addAttribute("msg","sign succeed");
				}
				
			
	
		
		return "attendance/attendanceSimulator";
	}
	@RequestMapping("/signIn2")
	public String signIn2(Subatt subatt,Model model) {
		
		int flag = attendanceService.addAttendanceItemWithoutWorkInTheMorning(subatt);
		if(flag==0) {
			model.addAttribute("msg","sign succeed");
		}else if(flag==20){
			model.addAttribute("msg","超过了签到时间11：30到12：30");
		}else if(flag==200){
			model.addAttribute("msg","上午已经签退过了");
		}else{
			model.addAttribute("msg","上午下班签退失败");
		}
	
		
		return "attendance/attendanceSimulator";
	}
	@RequestMapping("/signIn3")
	public String signIn3(Subatt subatt,Model model) {
		
		int flag = attendanceService.addAttendanceItemWithWorkInTheAfternoon(subatt);
		if(flag==30){
			model.addAttribute("msg","超过了签到时间13：30到14：30");
		}else if(flag==300){
			model.addAttribute("msg","下午已经签到过了");
		}else {
		model.addAttribute("msg","sign succeed");
		}
		return "attendance/attendanceSimulator";
	}
	@RequestMapping("/signIn4")
	public String signIn4(Subatt subatt,Model model) {
		
		int flag = attendanceService.addAttendanceItemWithoutWorkInTheAfternoon(subatt);
		if(flag==0) {
		model.addAttribute("msg","sign succeed");
		}else if(flag==40){
			model.addAttribute("msg","超过了签到时间17：30到18：30");
		}else if(flag==400){
			model.addAttribute("msg","下午已经签退过了");
		}else{
		model.addAttribute("msg","下午未签到，签退失败");
		}
			
		return "attendance/attendanceSimulator";
	}
}
