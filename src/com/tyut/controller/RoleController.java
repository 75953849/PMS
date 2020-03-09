package com.tyut.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tyut.common.utils.Page;
import com.tyut.po.Department;
import com.tyut.po.Role;
import com.tyut.service.DepartmentService;
import com.tyut.service.RoleService;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/addRole")
	public void addRole(Role role,HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		roleService.addRole(role);
		req.setAttribute("addmsg", "添加"+role.getRoleName()+"成功");
		req.getRequestDispatcher("/toRolePage").forward(req, res);
	}

	@RequestMapping("/toRolePage")
	public String toRolePage(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10") Integer rows,Role role,HttpServletRequest req) {
		Page<Role> roles = roleService.findRoleWithMapping(page, rows, role);
		List<Department> deps = departmentService.findAllDepartment();
		req.setAttribute("page", roles);
		req.setAttribute("deps", deps);
		return "role/rolePage";
	}
	
	@RequestMapping("/roleJson")
	@ResponseBody
	public List<Role> roleJson(@RequestBody Role role) {
		System.out.println("ajax后端正常运行");
		System.out.println(role);
		List<Role> roles = roleService.findRoleByDepId(role.getDepId());
		return roles;
	}
	
}
