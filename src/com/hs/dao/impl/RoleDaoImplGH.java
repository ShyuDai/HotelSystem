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

import com.hs.dao.RoleDaoGH;
import com.hs.entity.Role;
import com.hs.utils.BaseDao;
import com.hs.utils.DBConnectionUtil;

public class RoleDaoImplGH extends BaseDao implements RoleDaoGH {
	
	private static String table=null;
    //静态初始化块只会在类加载的时候加载一次,加载表名
    static {
        InputStream is=DBConnectionUtil.class.getClassLoader().getResourceAsStream("table.properties");
        Properties p=new Properties();
        try {
            p.load(is);
            table=p.getProperty("table_role");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   
	public boolean save(Role role) {
	    boolean flag=false;
	    String sql="insert into "+table+" (roleName,level,monthPay) values (?,?,?)";
		int rows=this.excuteUpdate(sql,role.getRoleName(),role.getLevel(),role.getMonthPay());
		if(rows>0)
			flag=true;
	 
		return flag;
	}

	 /*    private int roleId;//角色编号
		private String roleName;//角色名称
		private int level;//角色等级
		private int monthPay;//月薪
	*/		
	public boolean delete(Role role) {
		 boolean flag=false;
		    String sql="delete from "+table+" where roleId=?";
			int rows=this.excuteUpdate(sql,role.getRoleId());
			if(rows>0)
				flag=true;
			return flag;
	}


	public boolean update(Role role) {
		
		 boolean flag=false;
		    String sql="update "+table+" set roleName=?,level=?,monthPay=? where roleId=?";
			int rows=this.excuteUpdate(sql,role.getRoleName(),role.getLevel(),role.getMonthPay(),role.getRoleId());
			if(rows>0)
				flag=true;
		 
			return flag;
	}


	public Role getRoleById(int roleId) {
		Role role=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBConnectionUtil.getConnection();
			String sql="select *from "+table+" where roleId=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, roleId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				role=new Role();
				role.setRoleId(rs.getInt("roleId"));
				role.setRoleName(rs.getString("roleName"));
				role.setMonthPay(rs.getInt("monthPay"));
				role.setLevel(rs.getInt("level"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, pstmt, conn);
		}
		
		return role;
	}

	
	public List<Role> getAllRoles() {
		List<Role> list=new ArrayList<Role>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBConnectionUtil.getConnection();
			String sql="select *from "+table;
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Role role=new Role();
				role=new Role();
				role.setRoleId(rs.getInt("roleId"));
				role.setRoleName(rs.getString("roleName"));
				role.setMonthPay(rs.getInt("monthPay"));
				role.setLevel(rs.getInt("level"));
				list.add(role);
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
