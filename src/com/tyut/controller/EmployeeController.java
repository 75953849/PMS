package com.tyut.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyut.common.utils.Page;
import com.tyut.po.Department;
import com.tyut.po.Employee;
import com.tyut.service.DepartmentService;
import com.tyut.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired 
	DepartmentService departmentService;
	
	/*@RequestMapping("/test1")
	public String test1() {
		int a=1;
		Employee emp = employeeService.findEmpByID(a);
		System.out.println(emp);
		return "succeed";
	}
	*/
	@RequestMapping("/toPersonalPage")
	public String toPersonalPage(HttpServletRequest req) {
		return "personal/personalPage";
	}
	
	
	@RequestMapping("/toChangePassword")
	public String updatePassword() {
		return "personal/changePassword";		
	}
	
	@RequestMapping("/changePassword")
	public String changePassword(String oldPassword,String newPassword,HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		Employee emp = (Employee) session.getAttribute("emp");
		if(emp.getPassword().equals(oldPassword)) {
			//旧密码输入正确，可以修改密码
			emp.setPassword(newPassword);
			employeeService.updatePassword(emp);
			req.setAttribute("msg", "修改密码成功");
		}
		else {
			//旧密码错误，重新输入
			req.setAttribute("msg", "旧密码输入错误，请重新输入");
		}
		return "personal/changePassword";	
	}
	
	@RequestMapping("/toEmpPage")
	public String toEmpPage(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="2") Integer rows,Employee emp,HttpServletRequest req) {
		
		Page<Employee> emps = employeeService.findAllEmployeeByPage(page, rows, emp);
		System.out.println(emps.getRows().get(0));
		req.setAttribute("page", emps);
		return "emp/empPage";
	}
	
	
	@RequestMapping("/toAddEmp")
	public String toAddEmp(HttpServletRequest req) {
		
		List<Department> deps = departmentService.findAllDepartment();
		System.out.println(deps.get(0).getId());
		req.setAttribute("deps", deps);
		
		return "emp/addEmp";
	}
	
	@RequestMapping("/addEmp")
	public String addEmp(Employee emp) {
		emp.setRank(1);
		emp.setImpState(1);
		employeeService.addEmployee(emp);
		return "redirect:/toEmpPage";
	}
	
	@RequestMapping("/testDate")
	public String testDate(Date d) {
		System.out.println(d);
		return "succeed";
	}
	
}
