package com.hs.service;

import java.util.List;

import com.hs.entity.Customer;
import com.hs.entity.Orderinfo;
import com.hs.entity.PageHelperDataResult;

public interface OrderServiceYzw {
	//获取历史顾客信息
	public PageHelperDataResult getHistoryOrderinfoByStatus(int status,int pageNo,int pageSize,String starttime,String endtime);
	
	public PageHelperDataResult getHistorys(int pageNo,int pageSize);
	//根据日期获取订单信息
	public PageHelperDataResult getOrderinfoByTime(int pageNo,int pageSize,String starttime,String endtime);
	//根据时间和订单状态查询订单
	public PageHelperDataResult getOrderinfoByTimeAndStatus(int pageNo,int pageSize,String starttime,String endtime,int status);
	//获取所有订单信息
	public PageHelperDataResult getAllOrderinfo(int pageNo,int pageSize);
	
	public PageHelperDataResult getOrderInfoByNameOrIdcard(int pageNo,int pageSize,String str);
	public PageHelperDataResult getOrderinfoByStatus(int pageNo,int pageSize);
	
	public PageHelperDataResult getAllCustomer(int pageNo,int pageSize);
	public PageHelperDataResult getCustomerByName(int pageNo,int pageSize,String str);

}
