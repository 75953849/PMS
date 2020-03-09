package com.tyut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tyut.common.utils.Page;
import com.tyut.mapper.EmployeeMapper;
import com.tyut.po.Employee;
import com.tyut.po.EmployeeExample;
import com.tyut.po.EmployeeExample.Criteria;
import com.tyut.po.vo.EmployeeVo;
import com.tyut.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	

	@Override
	public Employee verifyEmployee(String username, String password) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria where = example.createCriteria();
		where.andEmpNameEqualTo(username);
		where.andPasswordEqualTo(password);
		List<Employee> emps = employeeMapper.selectByExample(example);
		if(emps.isEmpty()) {
			return null;
		}
		else {
			Employee employee = emps.get(0);
			return employee;
		}
		
	}


	@Override
	public int updatePassword(Employee emp) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria where = example.createCriteria();
		where.andIdEqualTo(emp.getId());
		return employeeMapper.updateByExample(emp, example);
	}

	@Override
	public Page<Employee> findAllEmployeeByPage(int page, int rows, Employee emp) {
		//包含emp全部参数
		// TODO Auto-generated method stub
		EmployeeVo vo = new EmployeeVo();
		vo.setJump((page-1)*rows);
		vo.setRows(rows);
		//List<Employee> list = employeeMapper.selectByExamplePage(vo);
		List<Employee> list = employeeMapper.selectByExampleMappingPage(vo);
		int total = employeeMapper.countByExample(vo);
		
		Page<Employee> emps = new Page<>();
		emps.setPage(page);
		emps.setSize(rows);
		emps.setTotal(total);
		emps.setRows(list);
		
		
		return emps;
	}


	@Override
	public Employee findEmpByID(Integer ID) {
		// TODO Auto-generated method stub
		return employeeMapper.findEmpByID(ID);
	}


	@Override
	public int addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeMapper.insertSelective(emp);
	}

}
