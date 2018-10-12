package com.hs.service;

import com.hs.entity.Goods;

import java.util.List;

/**
 * @author liuzonghua
 * @Package com.hs.service
 * @Description:
 * @date 2018/9/24 21:54
 */
public interface ManiyGoodsService {
    public Goods getGoods(int gid);

    public List<Goods> getGoodsList();
}
