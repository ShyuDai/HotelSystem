package com.hs.dao;

import java.util.List;

import com.hs.entity.Customer;
import com.hs.entity.Orderinfo;



public interface OrderDaoYzw {
	//获取历史顾客信息
	public List<Orderinfo> getHistoryOrderinfoByStatus(int status,int pageNo,int pageSize,String starttime,String endtime);
	//获取所有历史信息
	public List<Orderinfo> getHistorys(int pageNo,int pageSize);
	//根据日期获取订单信息
	public List<Orderinfo> getOrderinfoByTime(int pageNo,int pageSize,String starttime,String endtime);
	//根据时间和订单状态查询订单
	public List<Orderinfo> getOrderinfoByTimeAndStatus(int pageNo,int pageSize,String starttime,String endtime,int status);
	//获取所有订单信息
	public List<Orderinfo> getAllOrderinfo();
	//获取记录总数
	public long getCountAllHistory();
	public List<Orderinfo> getOrderInfoByNameOrIdcard(String str);
	//获取所有未完成订单
	public List<Orderinfo> getOrderinfoByStatus(int pageNo,int pageSize);
	
	public List<Customer> getAllCustomer();
	public List<Customer> getCustomerByName(String str);
}
