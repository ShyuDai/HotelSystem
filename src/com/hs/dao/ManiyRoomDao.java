package com.hs.dao;

import com.hs.entity.Room;

import java.util.List;

/**
 * @author liuzonghua
 * @Package com.hs.dao
 * @Description:
 * @date 2018/9/19 16:50
 */
public interface ManiyRoomDao {
    public List<Room> getRoomByRoomStatus(int pageNo,int pageSize);

    public int updateRoomStatusByRoomId(int roomid,int roomstatus);

    public int roomCount(int roomstatus);
}
