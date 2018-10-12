package com.hs.dao;

import java.util.List;

import com.hs.entity.Employee;

public interface EmployeeDaoGH {
	
	public boolean save(Employee employee);
	
	public boolean delete(Employee employee);
	
	public boolean update(Employee employee);
	
	public Employee getEmployeeById(int empId);
	
	
	
	public int getEmployeeCountByAttru(int attruCode,String value);
	
	public List<Employee> getEmployeesByAttru(int pageNo,int pageSize,int attruCode, String value);
	
	
	
	
	
	//根据年龄段查找员工表总数量
	public int getEmployeeCountByAgeInterval(int startAge,int endAge);

	//根据年龄段查找员工表员工信息
	public List<Employee> getEmployeesByAgeInterval(int pageNo,int pageSize,int startAge,int endAge);
	
	
	
	
	//根据工龄段查找员工表总数量
	public int getEmployeeCountByEmpWorkingYeasInterval(int startEmpWorkingYeas,int endEmpWorkingYeas);

	//根据工龄段查找员工表员工信息
	public List<Employee> getEmployeesByEmpWorkingYeasInterval(int pageNo,int pageSize,int startEmpWorkingYeas,int endEmpWorkingYeas);
	
	
	
	//根据入职日期区间查找员工表数量
	public int getEmployeeCountByEntryDateInterval(String startDate,String endDate);
	//根据入职日期区间查找员工表员工信息
	public List<Employee> getEmployeesByEntryDateInterval(int pageNo,int pageSize,String startDate,String endDate);
	
	
	//根据属性区间查询员工表数量
	public int getEmployeeCountByInterval(int attrCode,String start,String end);
	//根据属性区间查询员工表员工信息
	public List<Employee> getEmployeesByInterval(int pageNo,int pageSize,int attruCode,String start,String end);
	
	

}
