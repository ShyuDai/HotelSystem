package com.hs.service;

import com.hs.entity.Room;

import java.util.List;

/**
 * @author liuzonghua
 * @Package com.hs.service
 * @Description:
 * @date 2018/9/20 9:23
 */
public interface ManiyRoomService {
    //获取5接取中的所有房间
    public List<Room> getRoomByRoomStatus(int pageNo,int pageSize);



    //把房间状态接取中改成打扫中 即5->3
    public int updateRoomStatusTo3ByRoomId(int roomid);

    //把房间状态打扫中改成空闲 即3->0
    public int updateRoomStatusTo0ByRoomId(int roomid);

    //房间数量
    public int roomCount();
}
