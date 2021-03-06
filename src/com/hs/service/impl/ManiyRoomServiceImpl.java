package com.hs.service.impl;

import com.hs.dao.ManiyRoomDao;
import com.hs.dao.impl.ManiyRoomDaoImpl;
import com.hs.entity.Room;
import com.hs.service.ManiyRoomService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package com.hs.service.impl
 * @Description:
 * @date 2018/9/20 9:34
 */
public class ManiyRoomServiceImpl implements ManiyRoomService {
    ManiyRoomDao maniyRoomDao=new ManiyRoomDaoImpl();

    @Override
    public List<Room> getRoomByRoomStatus(int pageNo,int pageSize) {
        return maniyRoomDao.getRoomByRoomStatus(pageNo,pageSize);
    }

    @Override
    public int updateRoomStatusTo3ByRoomId(int roomid) {
        return maniyRoomDao.updateRoomStatusByRoomId(roomid,3);
    }

    @Override
    public int updateRoomStatusTo0ByRoomId(int roomid) {
        return maniyRoomDao.updateRoomStatusByRoomId(roomid,0);
    }

    @Override
    public int roomCount() {
        return maniyRoomDao.roomCount(5);
    }
}
