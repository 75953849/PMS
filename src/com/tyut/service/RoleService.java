package com.tyut.service;

import java.util.List;

import com.tyut.common.utils.Page;
import com.tyut.po.Role;

public interface RoleService {
	public int addRole(Role role);
	public Page<Role> findRoleWithMapping(int page,int rows,Role role);
	public List<Role> findRoleByDepId(Integer depId);
}
