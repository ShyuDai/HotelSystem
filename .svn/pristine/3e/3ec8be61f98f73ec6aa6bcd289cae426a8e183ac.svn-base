package com.hs.service;

import java.util.List;

import com.hs.dao.DepartmentDaoGH;
import com.hs.dao.impl.DepartmentDaoImplGH;
import com.hs.entity.Department;

public class DepartmentServiceGH {
	private DepartmentDaoGH dao=new DepartmentDaoImplGH();
	
	
    public boolean save(Department department) {
    	return dao.save(department);
    }
	
	public boolean delete(Department department) {
		return dao.delete(department);
	}
	
	public boolean update(Department department) {
		return dao.update(department);
	}
	
	public Department getDepartmentById(int depId) {
		return dao.getDepartmentById(depId);
	}
	
	public List<Department> getAllDepartments(){
		return dao.getAllDepartments();
	}
}
