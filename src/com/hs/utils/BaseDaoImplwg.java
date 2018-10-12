package com.hs.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseDaoImplwg {
	
	protected boolean flag = false;
	protected Connection conn = null;
	protected PreparedStatement st = null;
	protected ResultSet rs = null;
	
	//查询
	public ResultSet executeQuerywg(String sql,Object...params) {
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			System.out.println("wgconn==="+conn);
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			st = conn.prepareStatement(sql);
			//参数赋值
			for (int i = 0; i < params.length; i++) {
				st.setObject(i+1, params[i]);
			}
			// 4.处理数据库的返回结果
			rs = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			// 关闭资源
			//DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return rs;
	}
	
	
	//增加
	//删除
	//修改
	public int executeUpdatewg(String sql,Object...params) {
		int result=0;
		try {
			// 1.加载驱动程序
			// 2.获得数据库链接
			conn = DBConnectionUtil.getConnection();
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			st = conn.prepareStatement(sql);
			//参数赋值
			for (int i = 0; i < params.length; i++) {
				st.setObject(i+1, params[i]);
			}
			// 4.处理数据库的返回结果
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			DBConnectionUtil.CloseConnection(rs, st, conn);
		}
		return result;
		
	}
	
	
	
	
	

}
