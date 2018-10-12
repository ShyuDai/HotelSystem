package com.hs.test;

import java.util.List;

import com.hs.entity.Employee;
import com.hs.service.EmployeeServiceGH;
import com.hs.utils.DateFormatDefinition;
import com.hs.utils.SQL;

public class TestEmployee {

	public static void main(String[] args) {
		EmployeeServiceGH service=new EmployeeServiceGH();
		
		Employee emp=new Employee();
		emp.setEmpId(1);
		emp.setDepManager("Smith");
		emp.setDepName("前厅部");
		emp.setDepNo("101001");
		emp.setEmpAge(25);
		emp.setEmpEntryDate("2015-09-01");
		emp.setEmpName("梅超风");
		emp.setEmpNo("201510930111");
		emp.setEmpRemark("大学本科文凭");
		emp.setEmpSex("男");
		emp.setEmpWorkingYears(3);
		emp.setLevel(3);
		emp.setMonthPay(12000);
		emp.setRoleId(2);
		emp.setRoleName("服务员");
		emp.setDepId(2);
		
		System.out.println("--------------------增加employee----------------------------");
		for(int i=0;i<99;i++) {
		System.out.println(service.save(emp)?"员工添加成功":"员工添加失败");
		}
		//System.out.println(service.delete(emp)?"员工删除成功":"员工删除失败");
		
		System.out.println("--------------------单条件查询employee----------------------------");
		int pageNo=1;
		int pageSize=12;
		int attruCode=16;
		String value="Smith";
		System.out.println("单条件查询employee数量-->SQL:语句："+SQL.getEmployeeQueryByCount(attruCode, value));
		System.out.println("单条件查询employee数量-->"+service.getEmployeeCountByAttru(attruCode, value));
		
		System.out.println("单条件查询employee集合-->SQL:语句："+SQL.getEmployeeQuerySqlByPage(pageNo, pageSize,attruCode, value));
		List<Employee> list=service.getEmployeesByAttru(pageNo, pageSize, attruCode, value);
		for(Employee e:list) {
			System.out.println(e.toString());
		}
		
		for(Employee e:service.getEmployeesByEntryDateInterval(pageNo,pageSize,"2015-09-02", "2015-09-04")) {
			System.out.println(e.toString());
		}
		
		int attrCode=6;
		String start="2015-09-01";
		String end="2015-08-06";
		
		
		System.out.println("--------------------组合区间查询----------------------------");
		System.out.println("区间查询employee数量的SQL语句："+SQL.getEmployeeQueryByInterval(attrCode, start, end));
		System.out.println("区间查询employee数量："+service.getEmployeeCountByInterval(attrCode, start, end));
		System.out.println("区间查询employee集合的SQL语句："+SQL.getEmployeeListByInterval(pageNo, pageSize, attrCode, start, end));
		for(Employee empI:service.getEmployeesByInterval(pageNo, pageSize, attruCode, start, end)) {
			System.out.println(empI.toString());
		}
		
		System.out.println("--------------------入职日期单区间查询----------------------------");
		for(Employee e:service.getEmployeesByEntryDateInterval(pageNo, pageSize,start, end)) {
			System.out.println(e.toString());
		}
		
		System.out.println("--------------------年龄单区间查询----------------------------");
		for(Employee e:service.getEmployeesByAgeInterval(pageNo, pageSize,18, 25)) {
			System.out.println(e.toString());
		}
		
		System.out.println("--------------------工龄单区间查询----------------------------");
		for(Employee e:service.getEmployeesByEmpWorkingYeasInterval(pageNo, pageSize,3, 5)) {
			System.out.println(e.toString());
		}
		
		
		/*System.out.println("--------------------月薪单区间查询----------------------------");
		for(Employee e:service.getEmployeesByMonthPayInterval(pageNo, pageSize,3, 5)) {
			System.out.println(e.toString());
		}*/
		
		System.out.println(DateFormatDefinition.getYearByDays(DateFormatDefinition.statydays(start, end)));
		

	}
	
	
}
