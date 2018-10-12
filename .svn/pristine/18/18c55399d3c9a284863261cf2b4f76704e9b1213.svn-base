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

import com.hs.dao.UserDaoGH;
import com.hs.entity.User;
import com.hs.utils.BaseDao;
import com.hs.utils.DBConnectionUtil;
import com.hs.utils.SQL;

public class UserDaoImplGH extends BaseDao implements UserDaoGH {
	private static String table=null;
    //静态初始化块只会在类加载的时候加载一次,加载表名
    static {
        InputStream is=DBConnectionUtil.class.getClassLoader().getResourceAsStream("table.properties");
        Properties p=new Properties();
        try {
            p.load(is);
            table=p.getProperty("table_user");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	/*@Override private Integer userid;

    private String empnumber;

    private String password;

    private Integer roleid;*/
	public boolean save(User user) {
		// TODO Auto-generated method stub
		   boolean flag=false;
	        String sql="insert into "+table+"(empnumber,password,roleid)"+ " values (?,?,?)";
		  int results = this.excuteUpdate(sql,user.getEmpnumber(),user.getPassword(),user.getRoleid());
		if(results>0){
		       flag=true;
		   }
	        return flag;
		
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		 boolean flag=false;
	        String sql="update "+table+"set empnumber=?,password=?,roleid=? where userid=?";
		  int results = this.excuteUpdate(sql,user.getEmpnumber(),user.getPassword(),user.getRoleid(),user.getUserid());
		if(results>0){
		       flag=true;
		   }
	        return flag;
		
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		 boolean flag=false;
	        String sql="delete from "+table+" where userid=?";
		  int results = this.excuteUpdate(sql,user.getUserid());
		if(results>0){
		       flag=true;
		   }
	        return flag;
		
	}

	@Override
	public User getUserById(int userid) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		 User user=null;
		try {
		String sql="select *from "+table+" where userid=?";
		 rs=this.excuteQuery(sql,userid);
		
		 if(rs.next()) {
			 user=new User();
			 user.setUserid(rs.getInt("userid"));
			 user.setEmpnumber(rs.getString("empnumber"));
			 user.setPassword(rs.getString("password"));
			 user.setRoleid(rs.getInt("roleid"));
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User getUserByEmpnumber(String empnumber) {
		ResultSet rs=null;
		 User user=null;
		try {
		String sql="select *from "+table+" where empnumber=?";
		 rs=this.excuteQuery(sql,empnumber);
		 if(rs.next()) {
			 user=new User();
			 user.setUserid(rs.getInt("userid"));
			 user.setEmpnumber(rs.getString("empnumber"));
			 user.setPassword(rs.getString("password"));
			 user.setRoleid(rs.getInt("roleid"));
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int getUsersCountByPage(int attruCode, String value) {
		// TODO Auto-generated method stub
		int count=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		try {
			conn=DBConnectionUtil.getConnection();
			String sql=SQL.getUserQueryByCount(attruCode, value);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
	
			if(rs.next()) {
				count=rs.getInt("count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, pstmt, conn);
		}
		
		return count;
	}

	@Override
	public List<User> getUsersByPage(int pageNo, int pageSize, int attruCode, String value) {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<User>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		try {
			conn=DBConnectionUtil.getConnection();
			String sql=SQL.getUserQuerySqlByPage(pageNo, pageSize, attruCode, value);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				 User user=new User();
				 user.setUserid(rs.getInt("userid"));
				 user.setEmpnumber(rs.getString("empnumber"));
				 user.setPassword(rs.getString("password"));
				 user.setRoleid(rs.getInt("roleid"));
				 list.add(user);
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
