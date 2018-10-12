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

import com.hs.dao.DepartmentDaoGH;
import com.hs.entity.Department;
import com.hs.utils.BaseDao;
import com.hs.utils.DBConnectionUtil;

public class DepartmentDaoImplGH extends BaseDao implements DepartmentDaoGH {

	private static String table=null;
    //静态初始化块只会在类加载的时候加载一次,加载表名
    static {
        InputStream is=DBConnectionUtil.class.getClassLoader().getResourceAsStream("table.properties");
        Properties p=new Properties();
        try {
            p.load(is);
            table=p.getProperty("table_department");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
  
	public boolean save(Department department) {
		boolean flag=false;
		String sql="insert into "+table+" (depNo,depName,depManager,empCount) values(?,?,?,?)";
		int rows=this.excuteUpdate(sql, department.getDepNo(),department.getDepName(),department.getDepManager(),department.getEmpCount());
		if(rows>0)
			flag=true;
		
		return flag;
	}


	public boolean delete(Department department) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="delete from "+table+" where depId=?";
		int rows=this.excuteUpdate(sql, department.getDepId());
		if(rows>0)
			flag=true;
		
		return flag;
	}

	
	public boolean update(Department department) {
		boolean flag=false;
		String sql="update "+table+" set depNo=?,depName=?,depManager=?,empCount=? where depId=?";
		int rows=this.excuteUpdate(sql, department.getDepNo(),department.getDepName(),department.getDepManager(),department.getEmpCount(),department.getDepId());
		if(rows>0)
			flag=true;
		
		return flag;
	}

	
	public Department getDepartmentById(int depId) {
		Department department=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBConnectionUtil.getConnection();
			String sql="select *from "+table+" where depId=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, depId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				department=new Department();
				department.setDepId(rs.getInt("depId"));
				department.setDepManager(rs.getString("depManager"));
				department.setDepName(rs.getString("depName"));
				department.setDepNo(rs.getString("depNo"));
				department.setEmpCount(rs.getInt("empCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, pstmt, conn);
		}
		
		return department;
	}


	public List<Department> getAllDepartments() {
		List<Department> list=new ArrayList<Department>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBConnectionUtil.getConnection();
			String sql="select *from "+table;
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Department department=new Department();
				department.setDepId(rs.getInt("depId"));
				department.setDepManager(rs.getString("depManager"));
				department.setDepName(rs.getString("depName"));
				department.setDepNo(rs.getString("depNo"));
				department.setEmpCount(rs.getInt("empCount"));
				list.add(department);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, pstmt, conn);
		}
		
		return list;
	}

}
