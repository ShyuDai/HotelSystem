package com.hs.dao.impl;

import com.hs.dao.ManiyGoodsDao;
import com.hs.entity.Goods;
import com.hs.entity.Room;
import com.hs.utils.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzonghua
 * @Package com.hs.dao.impl
 * @Description:
 * @date 2018/9/24 21:42
 */
public class ManiyGoodsDaoImpl implements ManiyGoodsDao{
    @Override
    public Goods getGoods(int gid) {
        Goods goods =new Goods();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;


        try {
            conn= DBConnectionUtil.getConnection();
            String sql="SELECT * FROM goods WHERE gid=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,gid);
            rs=ps.executeQuery();
            if (rs.next()){

                goods.setGid(rs.getInt("gid"));
                goods.setGname(rs.getString("gname"));
                goods.setGprice(rs.getInt("gprice"));
                goods.setGcount(rs.getInt("gcount"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnectionUtil.CloseConnection(rs,ps,conn);
        }
        return goods;
    }

    @Override
    public List<Goods> getGoodsList() {
        List<Goods> goodList =new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;


        try {
            conn= DBConnectionUtil.getConnection();
            String sql="SELECT * FROM goods ";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Goods goods =new Goods();
                goods.setGid(rs.getInt("gid"));
                goods.setGname(rs.getString("gname"));
                goods.setGprice(rs.getInt("gprice"));
                goods.setGcount(rs.getInt("gcount"));
                goodList.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnectionUtil.CloseConnection(rs,ps,conn);
        }
        return goodList;
    }
}
