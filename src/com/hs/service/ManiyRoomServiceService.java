package com.hs.service;

import com.hs.entity.Roomservice;

import java.util.List;

/**
 * @author liuzonghua
 * @Package com.hs.service
 * @Description:
 * @date 2018/9/23 15:35
 */
public interface ManiyRoomServiceService {

    public int saveRoomService(Roomservice roomservice);

    public List<Roomservice> getAllRoomService(int pageNo,int pageSize);

    public int roomServiceCount();

}
