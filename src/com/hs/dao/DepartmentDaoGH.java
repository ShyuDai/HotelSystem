package com.hs.dao;

import java.util.List;

import com.hs.entity.Department;

public interface DepartmentDaoGH {
	
	public boolean save(Department department);
	
	public boolean delete(Department department);
	
	public boolean update(Department department);
	
	public Department getDepartmentById(int depId);
	
	public List<Department> getAllDepartments();
	

}
