package com.hs.dao.impl;

import com.hs.dao.ManiyRoomDao;
import com.hs.entity.Room;
import com.hs.utils.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzonghua
 * @Package com.hs.dao.impl
 * @Description:
 * @date 2018/9/19 16:56
 */
public class ManiyRoomDaoImpl implements ManiyRoomDao {
    @Override
    public List<Room> getRoomByRoomStatus(int pageNo,int pageSize) {
        List<Room> roomList =new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;


        try {
            conn= DBConnectionUtil.getConnection();
            String sql="SELECT * FROM room WHERE roomstatus=3 OR roomstatus=5 ORDER BY roomid ASC limit ?,?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,(pageNo-1)*pageSize);
            ps.setInt(2,pageSize);
            rs=ps.executeQuery();
            while (rs.next()){
                Room room =new Room();
                room.setRoomid(rs.getInt("roomid"));
                room.setRoomnumber(rs.getString("roomnumber"));
                room.setRoomtypeid(rs.getInt("roomtypeid"));
                room.setRoomtypename(rs.getString("roomtypename"));
                room.setRoomintroduce(rs.getString("roomintroduce"));
                room.setRoomstatus(rs.getInt("roomstatus"));
                roomList.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnectionUtil.CloseConnection(rs,ps,conn);
        }
        return roomList;
    }

    @Override
    public int updateRoomStatusByRoomId(int roomid, int roomstatus) {
        int flag =0;
        Connection conn=null;
        PreparedStatement ps=null;


        try {
            conn=DBConnectionUtil.getConnection();
            String sql ="UPDATE room SET roomstatus=? WHERE roomid=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,roomstatus);
            ps.setInt(2,roomid);
            int rows=ps.executeUpdate();
            if (rows>0){
                flag=1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnectionUtil.CloseConnection(null,ps,conn);
        }
        return flag;
    }

    @Override
    public int roomCount(int roomstatus) {
        int count =0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnectionUtil.getConnection();
            String sql = "SELECT COUNT(*) count FROM room WHERE roomstatus IN (3,5)";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            if (rs.next()) {
                count=rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionUtil.CloseConnection(rs, ps, conn);
        }

        return count;
    }


}
