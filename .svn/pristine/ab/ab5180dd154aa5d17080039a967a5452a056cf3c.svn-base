package com.hs.service;

import java.util.List;

import com.hs.dao.RoleDaoGH;
import com.hs.dao.impl.RoleDaoImplGH;
import com.hs.entity.Role;

public class RoleServiceGH {
	
	private RoleDaoGH dao=new RoleDaoImplGH();
	
	public boolean save(Role role) {
		return dao.save(role);
	}
	public boolean delete(Role role) {
		return dao.delete(role);
	}
	public boolean update(Role role) {
		return dao.update(role);
	}
	
	public Role getRoleById(int roleId) {
		return dao.getRoleById(roleId);
	}
	
	public List<Role> getAllRoles(){
		return dao.getAllRoles();
	}
	
}
