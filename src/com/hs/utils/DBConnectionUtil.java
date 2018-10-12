package com.hs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


import org.junit.Test;

public class DBConnectionUtil {


	static String jdbcDriver,jdbcURL, jdbcUser, jdbcPassword;

	static {//静态初始化块只会在类加载的时候执行一次
		// 读取文件
		InputStream is = DBConnectionUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties p = new Properties();

		try {
			p.load(is);
			jdbcDriver = p.getProperty("jdbcDriver");
			jdbcURL = p.getProperty("jdbcURL");
			jdbcUser = p.getProperty("jdbcUser");
			jdbcPassword = p.getProperty("jdbcPassword");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 1.加载驱动程序
			Class.forName(jdbcDriver);
			// 2.获得数据库链接
			conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Test
	public void syso() {
//		System.out.println(getConnection());
	}

	/**
	 * 关闭数据库连接 Statement 和 PreparedStatement之间的关系和区别
	 * 关系：PreparedStatement继承自Statement,都是接口
	 * 区别：PreparedStatement可以使用占位符，是预编译的，批处理比Statement效率高
	 */
	public static void CloseConnection(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
