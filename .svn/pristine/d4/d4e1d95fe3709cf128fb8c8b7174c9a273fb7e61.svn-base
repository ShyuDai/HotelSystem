package com.hs.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.hs.dao.EmployeeDaoGH;
import com.hs.entity.Employee;
import com.hs.utils.BaseDao;
import com.hs.utils.DBConnectionUtil;
import com.hs.utils.SQL;

public class EmployeeDaoImplGH extends BaseDao implements EmployeeDaoGH {

	private static String table=null;
    //静态初始化块只会在类加载的时候加载一次,加载表名
    static {
        InputStream is=DBConnectionUtil.class.getClassLoader().getResourceAsStream("table.properties");
        Properties p=new Properties();
        try {
            p.load(is);
            table=p.getProperty("table_employee");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    
    
  	public boolean save(Employee employee) {
		boolean flag=false;
		
		String sql="insert into "+table
				+ " (empNo,empName,empSex,"
				+ "empAge,empEntryDate,empWorkingYears,"
				+ "empRemark,roleId,roleName,"
				+ "level,monthPay,depId,"
				+ "depNo,depName,depManager) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int rows;
		rows = this.excuteUpdate(sql,
				employee.getEmpNo(),employee.getEmpName(),employee.getEmpSex(),
				employee.getEmpAge(),employee.getEmpEntryDate(),employee.getEmpWorkingYears(),
				employee.getEmpRemark(),employee.getRoleId(),employee.getRoleName(),
				employee.getLevel(),employee.getMonthPay(),employee.getDepId(),
				employee.getDepNo(),employee.getDepName(),employee.getDepManager()
				);
		
	
		if(rows>0)
			flag=true;
	
		
		return flag;
	}


	public boolean delete(Employee employee) {
        boolean flag=false;
        String sql="delete from "+table+" where empId=?";
		int rows;
		rows = this.excuteUpdate(sql, employee.getEmpId());
		if(rows>0)
			flag=true;
		
		return flag;
	}

	public boolean update(Employee employee) {
        boolean flag=false;
        String sql="update "+table+" set "
		                +" empNo=?,empName=?,empSex=?,"
						+ "empAge=?,empEntryDate=?,empWorkingYears=?,"
						+ "empRemark=?,roleId=?,roleName=?,"
						+ "level=?,monthPay=?,depId=?,"
						+ "depNo=?,depName=?,depManager=?"
						+" where empId=?";
		int rows;
		rows = this.excuteUpdate(sql, 
				employee.getEmpNo(),employee.getEmpName(),employee.getEmpSex(),
				employee.getEmpAge(),employee.getEmpEntryDate(),employee.getEmpWorkingYears(),
				employee.getEmpRemark(),employee.getRoleId(),employee.getRoleName(),
				employee.getLevel(),employee.getMonthPay(),employee.getDepId(),
				employee.getDepNo(),employee.getDepName(),employee.getDepManager(),
				employee.getEmpId());
		if(rows>0)
			flag=true;
		
		return flag;
	}

	
	public Employee getEmployeeById(int empId) {
		   Employee emp=null;
		   Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
		try {
			conn=DBConnectionUtil.getConnection();
			String sql="select *from "+table+" where empId=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, empId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				emp=new Employee();
				emp.setEmpId(rs.getInt("empId"));
				emp.setEmpNo(rs.getString("empNo"));
				emp.setEmpName(rs.getString("empName"));
				emp.setEmpSex(rs.getString("empSex"));
				emp.setEmpAge(rs.getInt("empAge"));
				emp.setEmpEntryDate(rs.getString("empEntryDate"));
				emp.setEmpWorkingYears(rs.getInt("empWorkingYears"));
				emp.setEmpRemark(rs.getString("empRemark"));
				emp.setRoleId(rs.getInt("roleId"));
				emp.setRoleName(rs.getString("roleName"));
				emp.setLevel(rs.getInt("level"));
				emp.setMonthPay(rs.getInt("monthPay"));
				emp.setDepId(rs.getInt("depId"));
				emp.setDepNo(rs.getString("depNo"));
				emp.setDepName(rs.getString("depName"));
				emp.setDepManager(rs.getString("depManager"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, pstmt, conn);
		}
		return emp;
	}

	
	public int getEmployeeCountByAttru(int attruCode, String value) {
	    int count=0;
	    Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	    try {
	    	conn=DBConnectionUtil.getConnection();
	    	pstmt=conn.prepareStatement(SQL.getEmployeeQueryByCount(attruCode, value));
	    	rs=pstmt.executeQuery();
			if(rs.next())
				count=rs.getInt("count");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, pstmt, conn);
		}
		return count;
	}


	public List<Employee> getEmployeesByAttru(int pageNo, int pageSize, int attruCode, String value) {
		List<Employee> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 
		try {
			conn=DBConnectionUtil.getConnection();
			pstmt=conn.prepareStatement(SQL.getEmployeeQuerySqlByPage(pageNo, pageSize, attruCode, value));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setEmpId(rs.getInt("empId"));
				emp.setEmpNo(rs.getString("empNo"));
				emp.setEmpName(rs.getString("empName"));
				emp.setEmpSex(rs.getString("empSex"));
				emp.setEmpAge(rs.getInt("empAge"));
				emp.setEmpEntryDate(rs.getString("empEntryDate"));
				emp.setEmpWorkingYears(rs.getInt("empWorkingYears"));
				emp.setEmpRemark(rs.getString("empRemark"));
				emp.setRoleId(rs.getInt("roleId"));
				emp.setRoleName(rs.getString("roleName"));
				emp.setLevel(rs.getInt("level"));
				emp.setMonthPay(rs.getInt("monthPay"));
				emp.setDepId(rs.getInt("depId"));
				emp.setDepNo(rs.getString("depNo"));
				emp.setDepName(rs.getString("depName"));
				emp.setDepManager(rs.getString("depManager"));
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, pstmt, conn);
		}
		
		return list;
	}


	@Override
	public int getEmployeeCountByAgeInterval(int startAge, int endAge) {
		int count=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	    try {
	    	conn=DBConnectionUtil.getConnection();
	    	String sql="select *from "+table+" where empAge >="+startAge+" and empAge <="+endAge;
	    	pstmt=conn.prepareStatement(sql);
	    	rs=pstmt.executeQuery();
			if(rs.next())
				count=rs.getInt("count");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, pstmt, conn);
		}
		return count;
	}


	@Override
	public List<Employee> getEmployeesByAgeInterval(int pageNo, int pageSize, int startAge, int endAge) {
		List<Employee> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			try {
				conn=DBConnectionUtil.getConnection();
				String sql="select *from "+table+" where empAge >="+startAge+" and empAge <="+endAge+" limit "+(pageNo-1)*pageSize+","+pageSize;
				pstmt=conn.prepareStatement(sql);
		    	rs=pstmt.executeQuery();
				while(rs.next()) {
					Employee emp=new Employee();
					emp.setEmpId(rs.getInt("empId"));
					emp.setEmpNo(rs.getString("empNo"));
					emp.setEmpName(rs.getString("empName"));
					emp.setEmpSex(rs.getString("empSex"));
					emp.setEmpAge(rs.getInt("empAge"));
					emp.setEmpEntryDate(rs.getString("empEntryDate"));
					emp.setEmpWorkingYears(rs.getInt("empWorkingYears"));
					emp.setEmpRemark(rs.getString("empRemark"));
					emp.setRoleId(rs.getInt("roleId"));
					emp.setRoleName(rs.getString("roleName"));
					emp.setLevel(rs.getInt("level"));
					emp.setMonthPay(rs.getInt("monthPay"));
					emp.setDepId(rs.getInt("depId"));
					emp.setDepNo(rs.getString("depNo"));
					emp.setDepName(rs.getString("depName"));
					emp.setDepManager(rs.getString("depManager"));
					list.add(emp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBConnectionUtil.CloseConnection(rs, pstmt, conn);
			}
		return list;
	}


	@Override
	public int getEmployeeCountByEmpWorkingYeasInterval(int startEmpWorkingYeas, int endEmpWorkingYeas) {
		int count=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	    try {
	    	conn=DBConnectionUtil.getConnection();
	    	String sql="select *from "+table+" where empWorkingYears >="+startEmpWorkingYeas+" and empWorkingYears <="+endEmpWorkingYeas;
	    	pstmt=conn.prepareStatement(sql);
	    	rs=pstmt.executeQuery();
			if(rs.next())
				count=rs.getInt("count");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, pstmt, conn);
		}
		return count;
	}


	@Override
	public List<Employee> getEmployeesByEmpWorkingYeasInterval(int pageNo, int pageSize, int startEmpWorkingYeas,
			int endEmpWorkingYeas) {
		List<Employee> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			try {
				conn=DBConnectionUtil.getConnection();
				String sql="select *from "+table+" where empWorkingYears >="+startEmpWorkingYeas+" and empWorkingYears <="+endEmpWorkingYeas+" limit "+(pageNo-1)*pageSize+","+pageSize;
				pstmt=conn.prepareStatement(sql);
		    	rs=pstmt.executeQuery();
				while(rs.next()) {
					Employee emp=new Employee();
					emp.setEmpId(rs.getInt("empId"));
					emp.setEmpNo(rs.getString("empNo"));
					emp.setEmpName(rs.getString("empName"));
					emp.setEmpSex(rs.getString("empSex"));
					emp.setEmpAge(rs.getInt("empAge"));
					emp.setEmpEntryDate(rs.getString("empEntryDate"));
					emp.setEmpWorkingYears(rs.getInt("empWorkingYears"));
					emp.setEmpRemark(rs.getString("empRemark"));
					emp.setRoleId(rs.getInt("roleId"));
					emp.setRoleName(rs.getString("roleName"));
					emp.setLevel(rs.getInt("level"));
					emp.setMonthPay(rs.getInt("monthPay"));
					emp.setDepId(rs.getInt("depId"));
					emp.setDepNo(rs.getString("depNo"));
					emp.setDepName(rs.getString("depName"));
					emp.setDepManager(rs.getString("depManager"));
					list.add(emp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBConnectionUtil.CloseConnection(rs, pstmt, conn);
			}
		return list;
	}


	@Override
	public int getEmployeeCountByEntryDateInterval(String startDate, String endDate) {
		int count=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	    try {
	    	conn=DBConnectionUtil.getConnection();
	    	String sql="select count(*) count from "+table+" where empEntryDate >='"+startDate+"' and empEntryDate <='"+endDate+"'";
	    	pstmt=conn.prepareStatement(sql);
	    	rs=pstmt.executeQuery();
			if(rs.next())
				count=rs.getInt("count");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, pstmt, conn);
		}
		return count;
	}


	public List<Employee> getEmployeesByEntryDateInterval(int pageNo, int pageSize, String startDate, String endDate) {
		List<Employee> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			try {
				String sql="select *from "+table+" where empEntryDate >='"+startDate+"' and empEntryDate <='"+endDate+"' limit "+(pageNo-1)*pageSize+","+pageSize;
				conn=DBConnectionUtil.getConnection();
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Employee emp=new Employee();
					emp.setEmpId(rs.getInt("empId"));
					emp.setEmpNo(rs.getString("empNo"));
					emp.setEmpName(rs.getString("empName"));
					emp.setEmpSex(rs.getString("empSex"));
					emp.setEmpAge(rs.getInt("empAge"));
					emp.setEmpEntryDate(rs.getString("empEntryDate"));
					emp.setEmpWorkingYears(rs.getInt("empWorkingYears"));
					emp.setEmpRemark(rs.getString("empRemark"));
					emp.setRoleId(rs.getInt("roleId"));
					emp.setRoleName(rs.getString("roleName"));
					emp.setLevel(rs.getInt("level"));
					emp.setMonthPay(rs.getInt("monthPay"));
					emp.setDepId(rs.getInt("depId"));
					emp.setDepNo(rs.getString("depNo"));
					emp.setDepName(rs.getString("depName"));
					emp.setDepManager(rs.getString("depManager"));
					list.add(emp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBConnectionUtil.CloseConnection(rs, pstmt, conn);
			}
		return list;
	}


	public int getEmployeeCountByInterval(int attrCode,String start, String end) {
		int count=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	    try {
	    	String sql=SQL.getEmployeeQueryByInterval(attrCode, start, end);
	    	conn=DBConnectionUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
				count=rs.getInt("count");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, pstmt, conn);
		}
		return count;
	}


	public List<Employee> getEmployeesByInterval(int pageNo, int pageSize, int attruCode, String start, String end) {
		List<Employee> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			try {
				conn=DBConnectionUtil.getConnection();
				pstmt=conn.prepareStatement(SQL.getEmployeeListByInterval(pageNo,pageSize,attruCode,start,end));
				System.out.println("页码："+pageNo+"-->"+SQL.getEmployeeListByInterval(pageNo,pageSize,attruCode,start,end));
				
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Employee emp=new Employee();
					emp.setEmpId(rs.getInt("empId"));
					emp.setEmpNo(rs.getString("empNo"));
					emp.setEmpName(rs.getString("empName"));
					emp.setEmpSex(rs.getString("empSex"));
					emp.setEmpAge(rs.getInt("empAge"));
					emp.setEmpEntryDate(rs.getString("empEntryDate"));
					emp.setEmpWorkingYears(rs.getInt("empWorkingYears"));
					emp.setEmpRemark(rs.getString("empRemark"));
					emp.setRoleId(rs.getInt("roleId"));
					emp.setRoleName(rs.getString("roleName"));
					emp.setLevel(rs.getInt("level"));
					emp.setMonthPay(rs.getInt("monthPay"));
					emp.setDepId(rs.getInt("depId"));
					emp.setDepNo(rs.getString("depNo"));
					emp.setDepName(rs.getString("depName"));
					emp.setDepManager(rs.getString("depManager"));
					list.add(emp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBConnectionUtil.CloseConnection(rs, pstmt, conn);
			}
		return list;
	}

}
