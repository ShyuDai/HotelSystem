package com.hs.dao.impl;

import com.hs.dao.ManiyRoomTypeDao;
import com.hs.entity.Roomservice;
import com.hs.utils.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author liuzonghua
 * @Package com.hs.dao.impl
 * @Description:
 * @date 2018/9/27 20:27
 */
public class ManiyRoomTypeDaoImpl implements ManiyRoomTypeDao {
    @Override
    public String getRoomtypeNameByRoomtypeId(int roomtypeId) {
        String roomtypeName="";

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;


        try {
            conn= DBConnectionUtil.getConnection();
            String sql="SELECT roomtypename FROM roomtype WHERE roomtypeid=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,roomtypeId);

            rs=ps.executeQuery();
            if (rs.next()){
               roomtypeName=rs.getString("roomtypename");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnectionUtil.CloseConnection(rs,ps,conn);
        }
        return  roomtypeName;
    }
}
