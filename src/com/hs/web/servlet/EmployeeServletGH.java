package com.hs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.hs.entity.Department;
import com.hs.entity.Employee;
import com.hs.entity.Role;
import com.hs.service.DepartmentServiceGH;
import com.hs.service.EmployeeServiceGH;
import com.hs.service.RoleServiceGH;
import com.hs.utils.DateFormatDefinition;
import com.hs.utils.PageCount;
import com.hs.utils.PageResult;


@WebServlet(name="/EmployeeServletGH",urlPatterns="/employeeServlet")
public class EmployeeServletGH extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeServiceGH empService=new EmployeeServiceGH();
	
	private DepartmentServiceGH depService=new DepartmentServiceGH();
	
	private RoleServiceGH roleService=new RoleServiceGH();
	
	private static int pageSize=12;
	
       
    public EmployeeServletGH() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");
	        String flagStr=request.getParameter("flag");
	        int flag=Integer.parseInt(flagStr);
	        switch (flag) {
			case 1://分页显示员工信息
				doQueryEmployeeListByPage(request,response);
				break;

           case 2://删除员工
        	   deleteEmployeeById(request,response);
				break;
				
				
           case 3://添加员工
        	   saveEmployeeById(request,response);
				break;
				
           case 4://修改员工信息
        	   updateEmployeeById(request,response);
				break;
				
				
				
           case 5://加载所有职位信息
        	   doQueryRoleList(request,response);
        	   break;
        	   
           case 6://加载所有的部门信息
        	   doQueryDepartmentList(request,response);
        	   break;
        	   
           case 7:
        		//根据属性区间段查询员工表员工信息
        	   doQueryEmployeeListByInterval(request,response);
        	   break;
        	   
           case 8://根据日期区间查询员工表
        	   doQueryEmployeeByEntryDateInterval(request,response);
        	   break;
        	   
           case 9://根据id查询dep
        	   getDepById(request,response);
        	   break;
        	  
       	   
			}
	        
	}
	
	//分页显示员工信息
	private void doQueryEmployeeListByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pageNoStr=request.getParameter("pageNo");
		int pageNo=Integer.parseInt(pageNoStr);
		
		String attruCodeStr=request.getParameter("attruCode");
		int attruCode=Integer.parseInt(attruCodeStr);
		
		String value=request.getParameter("value");
		
		PageResult pr=new PageResult();
		pr.setPageSize(pageSize);
		pr.setToatalCount(empService.getEmployeeCountByAttru(attruCode, value));
		pr.setPageCount(PageCount.getPageCount(pr.getToatalCount(), pageSize));
		
		if(pageNo<1) {
			pageNo=1;
		}
		
		if(pageNo>pr.getPageCount()) {
			pageNo=pr.getPageCount();
		}
		pr.setPageNo(pageNo);
		
		if(pageNo>0&&pageNo<=pr.getPageCount()) {
			//System.out.println("页面传过来页码："+pageNo);
			List<Employee> list=empService.getEmployeesByAttru(pageNo, pageSize, attruCode, value);
			pr.setList(list);
		}
			
		
		PrintWriter out=response.getWriter();
		out.print(new GsonBuilder().create().toJson(pr));
		out.flush();
		out.close();
		//System.out.println(new GsonBuilder().create().toJson(pr));
		
	}
	
	
	//删除员工信息
	private void deleteEmployeeById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String empIdStr=request.getParameter("empId");
		int empId=Integer.parseInt(empIdStr);
		Employee employee=empService.getEmployeeById(empId);
		//System.out.println(employee.toString());
		PrintWriter out=response.getWriter();
		if(empService.delete(employee)) {
		   out.write("ok");
		}else {
		   out.write("no");
		}
		out.flush();
		out.close();
	}
	
	//获取所有角色信息
	private void doQueryRoleList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		out.print(new GsonBuilder().create().toJson(roleService.getAllRoles()));
		out.flush();
		out.close();
	}
	
    //获取所有部门信息
	private void doQueryDepartmentList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		out.print(new GsonBuilder().create().toJson(depService.getAllDepartments()));
		out.flush();
		out.close();
	}
	
	
	
	
	
	
	//根据属性区间查询员工表员工信息
	private void doQueryEmployeeListByInterval(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String pageNoStr=request.getParameter("pageNo");
		int pageNo=Integer.parseInt(pageNoStr);
		
		String attruCodeStr=request.getParameter("attruCode");
		int attruCode=Integer.parseInt(attruCodeStr);
		
	
		String start=request.getParameter("start");
		String end=request.getParameter("end");
	

		PageResult pr=new PageResult();
		pr.setPageSize(pageSize);
		pr.setToatalCount(empService.getEmployeeCountByInterval(attruCode, start, end));
		pr.setPageCount(PageCount.getPageCount(pr.getToatalCount(), pageSize));
		
		if(pageNo<1) {
			pageNo=1;
		}
		
		if(pageNo>pr.getPageCount()) {
			pageNo=pr.getPageCount();
		}
		
		pr.setPageNo(pageNo);
		
		if(pageNo>0&&pageNo<=pr.getPageCount()) {
			//System.out.println("页面传过来页码："+pageNo);
			List<Employee> list=empService.getEmployeesByInterval(pageNo, pageSize, attruCode, start, end);
			pr.setList(list);
			
			}
			
		
		PrintWriter out=response.getWriter();
		out.print(new GsonBuilder().create().toJson(pr));
		out.flush();
		out.close();
		//System.out.println(new GsonBuilder().create().toJson(pr));
		
	}
	
	
	private void doQueryEmployeeByEntryDateInterval(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pageNoStr=request.getParameter("pageNo");
		int pageNo=Integer.parseInt(pageNoStr);
		
		
		String start=request.getParameter("start");
		String end=request.getParameter("end");
	
		//System.out.println(start+"-->"+end);
		
		PageResult pr=new PageResult();
		pr.setPageSize(pageSize);
		pr.setToatalCount(empService.getEmployeeCountByEntryDateInterval(start, end));
		pr.setPageCount(PageCount.getPageCount(pr.getToatalCount(), pageSize));
		
		if(pageNo<1) {
			pageNo=1;
		}
		
		
		
		if(pageNo>pr.getPageCount()) {
			pageNo=pr.getPageCount();
		}
		
		
		pr.setPageNo(pageNo);

		if(pageNo>0&&pageNo<=pr.getPageCount()) {
		 List<Employee> list=empService.getEmployeesByEntryDateInterval(pageNo, pageSize, start, end);
		 pr.setList(list);
		}
		
		PrintWriter out=response.getWriter();
		out.print(new GsonBuilder().create().toJson(pr));
		out.flush();
		out.close();
		//System.out.println(new GsonBuilder().create().toJson(pr));
		
	}
	
	
	private void saveEmployeeById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String  roleIdStr=request.getParameter("roleId");
		String  depIdStr=request.getParameter("depId");
		
		String empName=request.getParameter("empName");
		String empSex=request.getParameter("empSex");
		String empAgeStr=request.getParameter("empAge");
		int empAge=0;
		if(!empAgeStr.equals("")) {
			    empAge=Integer.parseInt(empAgeStr);
		}
		
		String empNo=request.getParameter("empNo");
		String empRemark=request.getParameter("empRemark");
		String empEntryDate=DateFormatDefinition.getDate();
		
		int empWorkingYears=0;
		
		int roleId=1;
		if(!roleIdStr.equals("")) {
			roleId=Integer.parseInt(roleIdStr);
		}
		
		
		int depId=1;
		if(!depIdStr.equals("")) {
			depId=Integer.parseInt(depIdStr);
		}
		
		Role role=roleService.getRoleById(roleId);
		Department dep=depService.getDepartmentById(depId);
		
		Employee employee=new Employee();
		employee.setDepId(dep.getDepId());
		employee.setDepManager(dep.getDepManager());
		employee.setDepName(dep.getDepName());
		employee.setDepNo(dep.getDepNo());
		employee.setEmpAge(empAge);
		employee.setEmpEntryDate(empEntryDate);
		employee.setEmpName(empName);
		employee.setEmpNo(empNo);
		employee.setEmpRemark(empRemark);
		employee.setEmpSex(empSex);
		employee.setEmpWorkingYears(empWorkingYears);
		employee.setLevel(role.getLevel());
		employee.setMonthPay(role.getMonthPay());
		employee.setRoleId(role.getRoleId());
		employee.setRoleName(role.getRoleName());
		
		PrintWriter out=response.getWriter();
		 if(empService.save(employee)) {
			 out.write("ok");
		 }else {
			 out.write("no");
		 }
		out.flush();
		out.close();
		
	}
	
	
   private void updateEmployeeById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String  empIdStr=request.getParameter("empId");
		String  roleIdStr=request.getParameter("roleId");
		String  depIdStr=request.getParameter("depId");
		
		String empName=request.getParameter("empName");
		String empSex=request.getParameter("empSex");
		String empAgeStr=request.getParameter("empAge");
		int    empAge=Integer.parseInt(empAgeStr);
		String empNo=request.getParameter("empNo");
		String empRemark=request.getParameter("empRemark");
		
		
		
		
		int empId=Integer.parseInt(empIdStr);
		int roleId=Integer.parseInt(roleIdStr);
		int depId=Integer.parseInt(depIdStr);
		
		Employee employee=empService.getEmployeeById(empId);
		Role role=roleService.getRoleById(roleId);
		Department dep=depService.getDepartmentById(depId);
		
		employee.setDepId(dep.getDepId());
		employee.setDepManager(dep.getDepManager());
		employee.setDepName(dep.getDepName());
		employee.setDepNo(dep.getDepNo());
		employee.setEmpAge(empAge);
		employee.setEmpName(empName);
		employee.setEmpNo(empNo);
		employee.setEmpRemark(empRemark);
		employee.setEmpSex(empSex);
		int empWorkingYears=DateFormatDefinition.getYearByDays(DateFormatDefinition.statydays(employee.getEmpEntryDate(), DateFormatDefinition.getDate()));
		employee.setEmpWorkingYears(empWorkingYears);
		employee.setLevel(role.getLevel());
		employee.setMonthPay(role.getMonthPay());
		employee.setRoleId(role.getRoleId());
		employee.setRoleName(role.getRoleName());
		
		PrintWriter out=response.getWriter();
		 if(empService.update(employee)) {
			 out.write("ok");
		 }else {
			 out.write("no");
		 }
		out.flush();
		out.close();
		
		
		
	}
   
   public void getDepById(HttpServletRequest request, HttpServletResponse response) throws IOException {
	   String  depIdStr=request.getParameter("depId");
		int depId=Integer.parseInt(depIdStr);
		Department dep=depService.getDepartmentById(depId);
		PrintWriter out=response.getWriter();
	    out.write(new GsonBuilder().create().toJson(dep));
		out.flush();
		out.close();
   }
	

}
