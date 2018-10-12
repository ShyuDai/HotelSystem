package com.hs.dao;


import java.sql.SQLException;
import java.util.List;

import com.hs.entity.Room;

public interface RoomDaoGH {
    public boolean save(Room room) throws SQLException;

    public boolean delete(Room room) throws SQLException;

    public boolean update(Room room) throws SQLException;


    public Room getRoomById(int roomId);

    public List<Room> getRooms(int pageNo, int pageSize,int attruCode, String value);

    public int getRoomsCount(int attrCode,String value);


}
