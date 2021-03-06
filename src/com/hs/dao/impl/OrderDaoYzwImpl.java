package com.hs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hs.dao.OrderDaoYzw;
import com.hs.entity.Customer;
import com.hs.entity.Orderinfo;
import com.hs.utils.BaseDaoImplwg;

import sun.util.resources.cldr.nmg.LocaleNames_nmg;



public class OrderDaoYzwImpl extends BaseDaoImplwg implements OrderDaoYzw {

	@Override
	public List<Orderinfo> getHistoryOrderinfoByStatus(int status,int pageNo,int pageSize,String starttime,String endtime) {
		List<Orderinfo> orderinfos = new ArrayList<Orderinfo>();
		ResultSet rs=null;
		String sql="SELECT customername,customerphone,customeridcard,customersex FROM orderinfo WHERE orderstatus=? and checkouttime>='"+starttime+" 00:00:01' and checkouttime<='"+endtime+" 23:59:59'";
		rs=this.executeQuerywg(sql, status);
		try {
			while (rs.next()) {
				Orderinfo orderinfo = new Orderinfo();
				orderinfo.setCustomername(rs.getString("customername"));
				orderinfo.setCustomerphone(rs.getString("customerphone"));
				orderinfo.setCustomeridcard(rs.getString("customeridcard"));
				orderinfo.setCustomersex(rs.getString("customersex"));
				orderinfos.add(orderinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderinfos;
	}

	@Override
	public List<Orderinfo> getOrderinfoByTime(int pageNo,int pageSize,String starttime,String endtime) {
		
		List<Orderinfo> orderinfos = new ArrayList<Orderinfo>();
		ResultSet rs=null;
		String sql="select customername,roomtypename,checkintime,checkouttime,roomprice,roomtotalprice,servicetotalprice FROM orderinfo where ordertime>='"+starttime+" 00:00:01' and ordertime<='"+endtime+" 23:59:59'";
		rs=this.executeQuerywg(sql);
		try {
			while (rs.next()) {
				Orderinfo orderinfo = new Orderinfo();
				orderinfo.setCustomername(rs.getString("customername"));
				orderinfo.setRoomtypename(rs.getString("roomtypename"));
				orderinfo.setCheckintime(rs.getString("checkintime"));
				orderinfo.setCheckouttime(rs.getString("checkouttime"));
				orderinfo.setRoomprice(rs.getInt("roomprice"));
				orderinfo.setRoomtotalprice(rs.getInt("roomtotalprice"));
				orderinfo.setServicetotalprice(rs.getInt("servicetotalprice"));
				orderinfos.add(orderinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderinfos;

	}

	@Override
	public List<Orderinfo> getOrderinfoByTimeAndStatus(int pageNo,int pageSize,String starttime, String endtime,int status) {
		List<Orderinfo> Orderinfos = new ArrayList<Orderinfo>();
		ResultSet rs=null;
		String sql="select customername,roomtypename,checkintime,checkouttime,roomprice,roomtotalprice,servicetotalprice from orderinfo where checkouttime>='"+starttime+" 00:00:01' and checkouttime<='"+endtime+" 23:59:59' and orderstatus=?";
		rs=this.executeQuerywg(sql,status);
		try {
			while (rs.next()) {
				Orderinfo orderinfo = new Orderinfo();
				orderinfo.setCustomername(rs.getString("customername"));
				orderinfo.setRoomtypename(rs.getString("roomtypename"));
				orderinfo.setCheckintime(rs.getString("checkintime"));
				orderinfo.setCheckouttime(rs.getString("checkouttime"));
				orderinfo.setRoomprice(rs.getInt("roomprice"));
				orderinfo.setRoomtotalprice(rs.getInt("roomtotalprice"));
				orderinfo.setServicetotalprice(rs.getInt("servicetotalprice"));
				Orderinfos.add(orderinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Orderinfos;

	}

	@Override
	public List<Orderinfo> getAllOrderinfo() {
		List<Orderinfo> Orderinfos = new ArrayList<Orderinfo>();
		ResultSet rs=null;
		String sql="select * from orderinfo";
		rs=this.executeQuerywg(sql);
		try {
			while (rs.next()) {
				Orderinfo orderinfo = new Orderinfo();
				orderinfo.setCustomername(rs.getString("customername"));
				orderinfo.setRoomtypename(rs.getString("roomtypename"));
				orderinfo.setCheckintime(rs.getString("checkintime"));
				orderinfo.setCheckouttime(rs.getString("checkouttime"));
				orderinfo.setRoomprice(rs.getInt("roomprice"));
				orderinfo.setRoomtotalprice(rs.getInt("roomtotalprice"));
				orderinfo.setServicetotalprice(rs.getInt("servicetotalprice"));
				Orderinfos.add(orderinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Orderinfos;
	}

	@Override
	public long getCountAllHistory() {
		int count= 0;
		ResultSet rs=null;
		String sql = "select count(*) from orderinfo where orderstatus=1";
		rs = executeQuerywg(sql);
		try {
			count = rs.getInt("count(*)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Orderinfo> getOrderInfoByNameOrIdcard(String str) {
		List<Orderinfo> list = new ArrayList<Orderinfo>();
		ResultSet rs=null;
		String sql = "select * from orderinfo where customername='"+str+"' or customeridcard ='"+str+"'";
		rs= this.executeQuerywg(sql);
		try {
			while (rs.next()) {
				Orderinfo orderinfo = new Orderinfo();
				orderinfo.setCustomername(rs.getString("customername"));
				orderinfo.setCustomerphone(rs.getString("customerphone"));
				orderinfo.setCustomeridcard(rs.getString("customeridcard"));
				orderinfo.setCustomersex(rs.getString("customersex"));
				orderinfo.setRoomtypename(rs.getString("roomtypename"));
				orderinfo.setCheckintime(rs.getString("checkintime"));
				orderinfo.setCheckouttime(rs.getString("checkouttime"));
				orderinfo.setRoomprice(rs.getInt("roomprice"));
				orderinfo.setRoomtotalprice(rs.getInt("roomtotalprice"));
				orderinfo.setServicetotalprice(rs.getInt("servicetotalprice"));
				list.add(orderinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Orderinfo> getHistorys(int pageNo, int pageSize) {
		List<Orderinfo> orderinfos = new ArrayList<Orderinfo>();
		ResultSet rs=null;
		String sql="SELECT customername,customerphone,customeridcard,customersex FROM orderinfo WHERE orderstatus=1";
		rs=this.executeQuerywg(sql);
		try {
			while (rs.next()) {
				Orderinfo orderinfo = new Orderinfo();
				orderinfo.setCustomername(rs.getString("customername"));
				orderinfo.setCustomerphone(rs.getString("customerphone"));
				orderinfo.setCustomeridcard(rs.getString("customeridcard"));
				orderinfo.setCustomersex(rs.getString("customersex"));
				orderinfos.add(orderinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderinfos;

	}

	@Override
	public List<Orderinfo> getOrderinfoByStatus(int pageNo,int pageSize) {
		List<Orderinfo> list = new ArrayList<Orderinfo>();
		ResultSet rs=null;
		String sql="select customername,roomtypename,checkintime,checkouttime,roomprice,roomtotalprice,servicetotalprice FROM orderinfo WHERE orderstatus=0";
		rs=this.executeQuerywg(sql);
		try {
			while (rs.next()) {
				Orderinfo orderinfo = new Orderinfo();
				orderinfo.setCustomername(rs.getString("customername"));
				orderinfo.setRoomtypename(rs.getString("roomtypename"));
				orderinfo.setCheckintime(rs.getString("checkintime"));
				orderinfo.setCheckouttime(rs.getString("checkouttime"));
				orderinfo.setRoomprice(rs.getInt("roomprice"));
				orderinfo.setRoomtotalprice(rs.getInt("roomtotalprice"));
				orderinfo.setServicetotalprice(rs.getInt("servicetotalprice"));
				list.add(orderinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;

	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> list = new ArrayList<Customer>();
		ResultSet rs=null;
		String sql="select * from customer";
		rs=this.executeQuerywg(sql);
		try {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setName(rs.getString("name"));
				customer.setIdcard(rs.getString("idcard"));
				customer.setPhone(rs.getString("phone"));
				customer.setSex(rs.getString("sex"));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;

	}

	@Override
	public List<Customer> getCustomerByName(String str) {
		List<Customer> list = new ArrayList<Customer>();
		ResultSet rs=null;
		String sql="select * from customer where name = '"+str+"' or idcard = '"+str+"'";
		rs=this.executeQuerywg(sql);
		try {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setName(rs.getString("name"));
				customer.setIdcard(rs.getString("idcard"));
				customer.setPhone(rs.getString("phone"));
				customer.setSex(rs.getString("sex"));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}	
}
