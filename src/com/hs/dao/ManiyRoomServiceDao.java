package com.hs.dao;

import com.hs.entity.Roomservice;

import java.util.List;

/**
 * @author liuzonghua
 * @Package com.hs.dao
 * @Description:
 * @date 2018/9/23 15:03
 */
public interface ManiyRoomServiceDao {
    //添加房间服务
    public int saveRoomService(Roomservice roomservice);

    public List<Roomservice> getAllRoomService(int pageNo,int pageSize);

    public int roomServiceCount();
}
