package com.hs.service;

import java.util.List;

import com.hs.dao.EmployeeDaoGH;
import com.hs.dao.impl.EmployeeDaoImplGH;
import com.hs.entity.Employee;

public class EmployeeServiceGH {
	
	private EmployeeDaoGH dao=new EmployeeDaoImplGH();
	
    public boolean save(Employee employee) {
    	return dao.save(employee);
    }
	
	public boolean delete(Employee employee) {
		return dao.delete(employee);
	}
	
	
	public boolean update(Employee employee) {
		return dao.update(employee);
	}
	
	public Employee getEmployeeById(int empId) {
		return dao.getEmployeeById(empId);
	}
	

	public int getEmployeeCountByAttru(int attruCode,String value) {
		return dao.getEmployeeCountByAttru(attruCode,value);
	}
	
	public List<Employee> getEmployeesByAttru(int pageNo,int pageSize,int attruCode, String value){
		return dao.getEmployeesByAttru(pageNo,pageSize,attruCode,value);
	}
	
	//根据年龄段查找员工表总数量
	public int getEmployeeCountByAgeInterval(int startAge,int endAge) {
		return dao.getEmployeeCountByAgeInterval(startAge, endAge);
	}

	//根据年龄段查找员工表员工信息
	public List<Employee> getEmployeesByAgeInterval(int pageNo,int pageSize,int startAge,int endAge){
		return dao.getEmployeesByAgeInterval(pageNo, pageSize, startAge, endAge);
	}
		
		
		
		
	//根据工龄段查找员工表总数量
	public int getEmployeeCountByEmpWorkingYeasInterval(int startEmpWorkingYeas,int endEmpWorkingYeas) {
		return dao.getEmployeeCountByEmpWorkingYeasInterval(startEmpWorkingYeas, endEmpWorkingYeas);
	}

	//根据工龄段查找员工表员工信息
	public List<Employee> getEmployeesByEmpWorkingYeasInterval(int pageNo,int pageSize,int startEmpWorkingYeas,int endEmpWorkingYeas){
		return dao.getEmployeesByEmpWorkingYeasInterval(pageNo, pageSize, startEmpWorkingYeas, endEmpWorkingYeas);
	}
		
		
		
	//根据入职日期区间查找员工表数量
	public int getEmployeeCountByEntryDateInterval(String startDate,String endDate) {
		return dao.getEmployeeCountByEntryDateInterval(startDate, endDate);
	}
		
	//根据入职日期区间查找员工表员工信息
	public List<Employee> getEmployeesByEntryDateInterval(int pageNo,int pageSize,String startDate,String endDate){
		return dao.getEmployeesByEntryDateInterval(pageNo, pageSize, startDate, endDate);
	}
	
	
		
	//根据属性区间查询员工表数量
	public int getEmployeeCountByInterval(int attrCode,String start,String end) {
		return dao.getEmployeeCountByInterval(attrCode,start,end);	
	}
		
		
	//根据属性区间查询员工表员工信息
	public List<Employee> getEmployeesByInterval(int pageNo,int pageSize,int attruCode,String start,String end){
			return dao.getEmployeesByInterval(pageNo,pageSize,attruCode,start,end);
	}

	 
	
}
