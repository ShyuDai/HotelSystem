package com.hs.entity;

import java.util.Date;

public class Employee {//员工表
	private int    empId;//序号
	private String empNo;//员工号
	private String empName;//员工姓名
	private String empSex;//员工性别
	private int    empAge;//员工年龄
	private String empEntryDate;//入职日期
	private int    empWorkingYears;//工龄
	private String empRemark;//备注
	
	
	private int roleId;//角色id
	private String roleName;//角色名称
	private int level;//角色等级
	private int monthPay;//月薪
	
	private int    depId;//部门id
	private String depNo;//部门号
    private String depName;//部门名称
    private String depManager;//部门经理
    
    
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	
	public String getEmpEntryDate() {
		return empEntryDate;
	}
	public void setEmpEntryDate(String empEntryDate) {
		this.empEntryDate = empEntryDate;
	}
	public int getEmpWorkingYears() {
		return empWorkingYears;
	}
	public void setEmpWorkingYears(int empWorkingYears) {
		this.empWorkingYears = empWorkingYears;
	}
	public String getEmpRemark() {
		return empRemark;
	}
	public void setEmpRemark(String empRemark) {
		this.empRemark = empRemark;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMonthPay() {
		return monthPay;
	}
	public void setMonthPay(int monthPay) {
		this.monthPay = monthPay;
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int depId) {
		this.depId = depId;
	}
	public String getDepNo() {
		return depNo;
	}
	public void setDepNo(String depNo) {
		this.depNo = depNo;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepManager() {
		return depManager;
	}
	public void setDepManager(String depManager) {
		this.depManager = depManager;
	}

	public String toString() {
		return "Employee [empId=" + empId + ", empNo=" + empNo + ", empName=" + empName + ", empSex=" + empSex
				+ ", empAge=" + empAge + ", empEntryDate=" + empEntryDate + ", empWorkingYears=" + empWorkingYears
				+ ", empRemark=" + empRemark + ", roleId=" + roleId + ", roleName=" + roleName + ", level=" + level
				+ ", monthPay=" + monthPay + ", depId=" + depId + ", depNo=" + depNo + ", depName=" + depName
				+ ", depManager=" + depManager + "]";
	}
    
    
    
	

}
