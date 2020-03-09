package com.tyut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tyut.common.utils.Page;
import com.tyut.mapper.RoleMapper;
import com.tyut.po.Role;
import com.tyut.po.RoleExample;
import com.tyut.po.RoleExample.Criteria;
import com.tyut.po.vo.RoleVo;
import com.tyut.service.RoleService;

@Service
@Transactional
public class roleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapping;
	@Override
	public int addRole(Role role) {
		// TODO Auto-generated method stub
		return roleMapping.insertSelective(role);	
	}
	@Override
	public Page<Role> findRoleWithMapping(int page, int rows, Role role) {
		// TODO Auto-generated method stub
		RoleVo vo = new RoleVo();
		vo.setJump((page-1)*rows);
		vo.setRows(rows);
		Integer a =role.getDepId();
		
		if(a!=null&&a!=0) {
			
				Criteria where = vo.createCriteria();
				where.andDepIdEqualTo(role.getDepId());

		}
		List<Role> list = roleMapping.selectByExampleMappingPage(vo);
		int total = roleMapping.countByExample(vo);
		Page<Role> roles = new Page<>();
		roles.setPage(page);
		roles.setSize(rows);
		roles.setTotal(total);
		roles.setRows(list);
		return roles;
	}
	@Override
	public List<Role> findRoleByDepId(Integer depId) {
		// TODO Auto-generated method stub
		RoleExample example = new RoleExample();
		Criteria where = example.createCriteria();
		where.andDepIdEqualTo(depId);
		return roleMapping.selectByExample(example);
	}

}
