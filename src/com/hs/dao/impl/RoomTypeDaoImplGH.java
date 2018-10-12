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

import com.hs.dao.RoomTypeDaoGH;
import com.hs.entity.Roomtype;
import com.hs.utils.BaseDao;
import com.hs.utils.DBConnectionUtil;

public class RoomTypeDaoImplGH extends BaseDao implements RoomTypeDaoGH {

	private static String table_roomtype=null;
	 //静态初始化块只会在类加载的时候加载一次,加载表名
    static {
        InputStream is=DBConnectionUtil.class.getClassLoader().getResourceAsStream("table.properties");
        Properties p=new Properties();
        try {
            p.load(is);
            table_roomtype=p.getProperty("table_roomtype");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

	@Override
	public boolean save(Roomtype roomtype) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Roomtype roomtype) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Roomtype roomtype) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Roomtype getRoomType(int roomtypeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roomtype> getAllRoomTypes() {
		// TODO Auto-generated method stub
		List<Roomtype> list=new ArrayList<Roomtype>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=DBConnectionUtil.getConnection();
			String sql="select *from "+table_roomtype;
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Roomtype type=new Roomtype();
				type.setRoomtypeid(rs.getInt("roomtypeid"));
				type.setRoomtypename(rs.getString("roomtypename"));
				type.setRoomtypeintroduce(rs.getString("roomtypeintroduce"));
				type.setRoomtypeprice(rs.getInt("roomtypeprice"));
				list.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.CloseConnection(rs, pstmt, conn);
		}
		return list;
		
	}

}
