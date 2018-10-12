package com.hs.service.impl;

import com.hs.dao.ManiyRoomServiceDao;
import com.hs.dao.ManiyRoomTypeDao;
import com.hs.dao.RoomTypeDaoGH;
import com.hs.dao.impl.ManiyRoomServiceDaoImpl;
import com.hs.dao.impl.ManiyRoomTypeDaoImpl;
import com.hs.dao.impl.RoomTypeDaoImplGH;
import com.hs.entity.Roomservice;
import com.hs.service.ManiyRoomServiceService;

import java.util.List;

/**
 * @author liuzonghua
 * @Package com.hs.service.impl
 * @Description:
 * @date 2018/9/23 15:37
 */
public class ManiyRoomServiceServiceImpl implements ManiyRoomServiceService {
    ManiyRoomServiceDao maniyRoomServiceDao =new ManiyRoomServiceDaoImpl();

    @Override
    public int saveRoomService(Roomservice roomservice) {

        return maniyRoomServiceDao.saveRoomService(roomservice);
    }

    @Override
    public List<Roomservice> getAllRoomService(int pageNo,int pageSize) {
        return maniyRoomServiceDao.getAllRoomService(pageNo,pageSize);
    }

    @Override
    public int roomServiceCount() {
        return maniyRoomServiceDao.roomServiceCount();
    }
}
