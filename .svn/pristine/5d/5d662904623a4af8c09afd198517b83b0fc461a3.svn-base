package com.hs.service;

import java.sql.SQLException;
import java.util.List;

import com.hs.dao.RoomDaoGH;
import com.hs.dao.impl.RoomDaoImplGH;
import com.hs.entity.Room;

public class RoomServiceGH {
    private RoomDaoGH dao=new RoomDaoImplGH();

    public boolean save(Room room) throws SQLException {
        return dao.save(room);
    }

    public boolean update(Room room) throws SQLException {
        return dao.update(room);
    }

    public boolean delete(Room room) throws SQLException {
        return dao.delete(room);
    }


    public int getRoomsCount(int attruCode,String value){
        return dao.getRoomsCount(attruCode,value);
    }

    public List<Room> getRoomsByPage(int pageNo,int pageSize,int attruCode,String value){
        return dao.getRooms(pageNo,pageSize,attruCode,value);
    }

}
