package com.hs.dao.impl;

import com.hs.dao.ManiyRoomServiceDao;
import com.hs.entity.Goods;
import com.hs.entity.Room;
import com.hs.entity.Roomservice;
import com.hs.service.ManiyRoomService;
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
 * @date 2018/9/23 15:06
 */
public class ManiyRoomServiceDaoImpl implements ManiyRoomServiceDao {
    @Override
    public int saveRoomService(Roomservice roomservice) {
        int flag =0;
        Connection conn=null;
        PreparedStatement ps=null;


        try {
            conn= DBConnectionUtil.getConnection();
            String sql ="INSERT INTO roomservice (name,roomnumber,roomtypeid,roomtypename,servicename,servicetotalprice,servicetime" +
                    ",empnumber) VALUES (?,?,?,?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,roomservice.getName());
            ps.setString(2,roomservice.getRoomnumber());
            ps.setInt(3,roomservice.getRoomtypeid());
            ps.setString(4,roomservice.getRoomtypename());
            ps.setString(5,roomservice.getServicename());
            ps.setInt(6,roomservice.getServicetotalprice());
            ps.setString(7,roomservice.getServicetime());
            ps.setString(8,roomservice.getEmpnumber());
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
    public List<Roomservice> getAllRoomService(int pageNo,int pageSize) {
        List<Roomservice> roomserviceList =new ArrayList<Roomservice>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;


        try {
            conn= DBConnectionUtil.getConnection();
            String sql="SELECT * FROM roomservice ORDER BY id ASC limit ?,? ";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,(pageNo-1)*pageSize);
            ps.setInt(2,pageSize);
            rs=ps.executeQuery();
            while (rs.next()){
                Roomservice roomservice =new Roomservice();
                roomservice.setId(rs.getInt("id"));
                roomservice.setName(rs.getString("name"));
                roomservice.setRoomnumber(rs.getString("roomnumber"));
                roomservice.setRoomtypeid(rs.getInt("roomtypeid"));
                roomservice.setRoomtypename(rs.getString("roomtypename"));
                roomservice.setServicename(rs.getString("servicename"));
                roomservice.setServicetotalprice(rs.getInt("servicetotalprice"));
                roomservice.setServicetime(rs.getString("servicetime"));
                roomservice.setEmpnumber(rs.getString("empnumber"));
                roomserviceList.add(roomservice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnectionUtil.CloseConnection(rs,ps,conn);
        }
        return roomserviceList;
    }

    @Override
    public int roomServiceCount() {
        int count =0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnectionUtil.getConnection();
            String sql = "SELECT COUNT(*) count FROM roomservice";
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
