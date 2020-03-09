package com.tyut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyut.common.utils.Page;
import com.tyut.mapper.DepartmentMapper;
import com.tyut.po.Department;
import com.tyut.po.DepartmentExample.Criteria;
import com.tyut.po.vo.DepartmentVo;
import com.tyut.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	@Override
	public Page<Department> findAllDepartmentByPage(int page , int rows,Department dep) {
		// TODO Auto-generated method stub
		DepartmentVo vo = new DepartmentVo();
		vo.setJump((page-1)*rows);
		vo.setRows(rows);
		
		Criteria where = vo.createCriteria();
		if(dep.getId() != null) {
			where.andIdEqualTo(dep.getId());
		}
		if(dep.getDepName() != null) {
			where.andDepNameLike("%"+dep.getDepName()+"%");
		}
		
		
		List<Department> list = departmentMapper.selectByExamplePage(vo);
		
		int count = departmentMapper.countByExample(vo);
		
		
		int total = count;
		Page<Department> deps = new Page<>();
		deps.setPage(page);
		deps.setSize(rows);
		deps.setRows(list);
		deps.setTotal(total);
		
		
		return deps;
	}
	@Override
	public int insertDepartment(Department dep) {
		// TODO Auto-generated method stub
		return departmentMapper.insertSelective(dep);
		
	}
	@Override
	public List<Department> findAllDepartment() {
		// TODO Auto-generated method stub
		List<Department> deps = departmentMapper.selectByExample(null);
		return deps;
	}
	
	

}
