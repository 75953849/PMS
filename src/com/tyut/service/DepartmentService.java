package com.tyut.service;


import java.util.List;

import com.tyut.common.utils.Page;
import com.tyut.po.Department;

public interface DepartmentService {
	public Page<Department> findAllDepartmentByPage(int page,int rows,Department dep);
	public int insertDepartment(Department dep);
	public List<Department> findAllDepartment();
}
