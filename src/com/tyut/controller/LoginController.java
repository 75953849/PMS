package com.tyut.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tyut.po.Employee;
import com.tyut.service.EmployeeService;

@Controller
public class LoginController {
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(String username , String password,HttpServletRequest req) {
		
		Employee employee = employeeService.verifyEmployee(username, password);
		HttpSession session = req.getSession();
		//完整
		
		
		if(employee==null) {
			//登录失败，重新登录
			req.setAttribute("msg", "用户名或密码错误，请重新输入");
			return "login";
		}
		else {
			//登录成功
			Employee emp = employeeService.findEmpByID(employee.getId());
			session.setAttribute("emp", emp);
			return "main";	
		}
	
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session,HttpServletRequest req) {
		session.removeAttribute("emp");
		req.setAttribute("msg", "退出系统成功");
		return "login";
	}
	
}
