package com.hs.dao;

import com.hs.entity.Goods;

import java.util.List;

/**
 * @author liuzonghua
 * @Package com.hs.dao
 * @Description:
 * @date 2018/9/24 21:41
 */
public interface ManiyGoodsDao {

    public Goods getGoods(int gid);

    public List<Goods> getGoodsList();
}
