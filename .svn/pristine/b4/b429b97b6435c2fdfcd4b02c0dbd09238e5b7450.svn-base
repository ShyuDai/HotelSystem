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

import com.hs.dao.CustomerDaoGH;
import com.hs.entity.Customer;
import com.hs.utils.DBConnectionUtil;
import com.hs.utils.SQL;

public class CustomerDaoImplGH implements CustomerDaoGH {


    private static String table=null;
    //静态初始化块只会在类加载的时候加载一次,加载表名
    static {
        InputStream is=DBConnectionUtil.class.getClassLoader().getResourceAsStream("table.properties");
        Properties p=new Properties();
        try {
            p.load(is);
            table=p.getProperty("table_customer");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}

	@Override
	public boolean delete(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCustomerCount(int attruCode, String value) {
		// TODO Auto-generated method stub
		  int count=0;
	        Connection conn=null;
	        PreparedStatement pstmt=null;
	        ResultSet       resultSet=null;
	        try {
	            conn=DBConnectionUtil.getConnection();
	            String sql=SQL.getCustomerQueryByCount(attruCode,value);
	            pstmt=conn.prepareStatement(sql);
	            resultSet=pstmt.executeQuery();
	            if(resultSet.next()){
	                count=resultSet.getInt("count");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            DBConnectionUtil.CloseConnection(resultSet,pstmt,conn);
	        }
	        return count;
	}

	@Override
	public List<Customer> getCustomersByPage(int pageNo, int pageSize, int attruCode, String value) {
		// TODO Auto-generated method stub
		List<Customer> list=new ArrayList<Customer>();
		    Connection conn=null;
	        PreparedStatement pstmt=null;
	        ResultSet       rs=null;
	  
	        try {
	        	conn=DBConnectionUtil.getConnection();
		        String sql=SQL.getCustomerQuerySqlByPage(pageNo, pageSize, attruCode, value);
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					Customer  customer=new Customer();
					customer.setId(rs.getInt("id"));
					customer.setSex(rs.getString("sex"));
					customer.setName(rs.getString("name"));
					customer.setPhone(rs.getString("phone"));
					customer.setIdcard(rs.getString("idcard"));
					list.add(customer);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		return list;
	}

}
