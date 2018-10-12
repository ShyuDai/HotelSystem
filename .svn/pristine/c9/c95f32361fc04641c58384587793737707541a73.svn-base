package com.hs.service.impl;

import com.hs.dao.ManiyGoodsDao;
import com.hs.dao.impl.ManiyGoodsDaoImpl;
import com.hs.entity.Goods;
import com.hs.entity.Room;
import com.hs.service.ManiyGoodsService;


import java.util.List;

/**
 * @author liuzonghua
 * @Package com.hs.service.impl
 * @Description:
 * @date 2018/9/24 21:54
 */
public class ManiyGoodsServiceImpl implements ManiyGoodsService{
    ManiyGoodsDao maniyGoodsDao =new ManiyGoodsDaoImpl();


    @Override
    public Goods getGoods(int gid) {
        return maniyGoodsDao.getGoods(gid);
    }

    @Override
    public List<Goods> getGoodsList() {
        return maniyGoodsDao.getGoodsList();
    }
}
