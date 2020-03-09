package com.tyut.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyut.common.utils.Page;
import com.tyut.po.Department;
import com.tyut.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/toDepPage")
	public String toDepPage(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="2") Integer rows,Department dep,HttpServletRequest req) {
		System.out.println(dep.getDepName()+dep.getId());
		Page<Department> deps = departmentService.findAllDepartmentByPage(page, rows,dep);
		req.setAttribute("page", deps);
		return "depart/depPage";
	}
	
	@RequestMapping("/toAddDepPage")
	public String toAddDepPage() {
		return "depart/addDepPage";
	}
	
	@RequestMapping("/addDepart")
	public void addDepart(Department dep,HttpServletRequest req ,HttpServletResponse res) throws ServletException, IOException {
		dep.setEmpcount(0);	//默认0人
		int a = departmentService.insertDepartment(dep);
		if(a!=0) {
			req.setAttribute("msg", "增加"+dep.getDepName()+"成功");
			req.getRequestDispatcher("/toDepPage").forward(req, res);
		}
		else {
			//error
		}
	}
	
	
	
	@RequestMapping("/toAddRolePage")
	public String toAddRolePage(HttpServletRequest req) {
		List<Department> deps = departmentService.findAllDepartment();
		req.setAttribute("deps", deps);
		return "role/addRolePage";
	}
	
	
	
}
