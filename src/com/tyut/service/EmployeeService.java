package com.tyut.service;

import com.tyut.common.utils.Page;
import com.tyut.po.Employee;

public interface EmployeeService {
	public Employee findEmpByID(Integer ID);
	public Employee verifyEmployee(String username,String password);
	public int updatePassword(Employee emp);
	public Page<Employee> findAllEmployeeByPage(int page,int rows,Employee emp);
	public int addEmployee(Employee emp);
}
