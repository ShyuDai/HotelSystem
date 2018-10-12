package com.hs.service.impl;

import java.util.List;

import com.hs.dao.OrderDaowg;
import com.hs.dao.impl.OrderDaowgImpl;
import com.hs.entity.Orderinfo;
import com.hs.entity.Room;
import com.hs.entity.Roomtype;
import com.hs.service.OrderServicewg;

public class OrderServicewgImpl implements OrderServicewg {
	
	private OrderDaowg od=new OrderDaowgImpl();

	@Override
	public List<Roomtype> getAllRoomTypewg() {
		String sql="select * from roomtype";
		return od.getAllRoomTypewg(sql);
	}

	@Override
	public List<Room> getAllRoomListByRoomTypeId(int roomtypeid) {
		String sql="select * from room where roomstatus=0 and roomtypeid=?";
		return od.getAllRoomListByRoomTypeId(sql,roomtypeid);
	}

	@Override
	public Roomtype getRoomTypeByRoomTypeId(int roomtypeid) {
		String sql="select * from roomtype where roomtypeid=?";
		return od.getRoomTypeByRoomTypeId(sql,roomtypeid);
	}

	@Override
	public int UpdateRoomStatusByRoomNumber(int roomstatus, String roomnumber) {
		String sql="update room set roomstatus=? where roomnumber=?";
		return od.UpdateRoomStatusByRoomNumber(sql,roomstatus,roomnumber);
	}

	@Override
	public int customerIsExit(String customeridcard) {
		String sql="select count(*) from customer where idcard=?";
		return od.customerIsExit(sql,customeridcard);
	}

	@Override
	public int addCustomerInfo(String customername, String customersex, String customeridcard, String customerphone) {
		String sql="insert into customer(name,sex,idcard,phone) value(?,?,?,?)";
		return od.addCustomerInfo(sql, customername,  customersex,  customeridcard,  customerphone);
	}

	@Override
	public int OrderRoomServletwg(int orderid, String customername, String customerphone, String customeridcard,
			String customersex, String roomnumber, int roomtypeid, String roomtypename, String empnumber1,
			int roomprice, int orderstatus) {
		String sql="insert into orderinfo(orderid,customername,customerphone,customeridcard,customersex,roomnumber,"
				+ "roomtypeid,roomtypename,empnumber1,ordertime,roomprice,orderstatus) "
				+ "value(?,?,?,?,?,?,?,?,?,SYSDATE(),?,?)";
		return od.OrderRoomServletwg(sql, orderid, customername, customerphone, customeridcard,
			 customersex, roomnumber, roomtypeid, roomtypename, empnumber1,
			 roomprice, orderstatus);
	}

	@Override
	public List<Room> getAllRoomListwg() {
		String sql="select * from room";
		return od.getAllRoomListwg(sql);
	}


	@Override
	public Room getRoomByRoomNumber(String newroomnumber) {
		String sql="select * from room where roomnumber=?";
		return od.getRoomByRoomNumberwg(sql,newroomnumber);
	}

	@Override
	public int ChangeRoomInfoByOldRoomNumber(String newroomnumber, Integer roomtypeid, String roomtypename,String empnumber4,
			Integer roomtypeprice, String oldroomnumber) {
		String sql="update orderinfo set roomnumber=?,roomtypeid=?,roomtypename=?,empnumber4=?,roomprice=? where roomnumber=?";
		return od.ChangeRoomInfoByOldRoomNumber(sql, newroomnumber, roomtypeid, roomtypename,empnumber4,roomtypeprice, oldroomnumber);
	}

	@Override
	public int AddOrderOfCheckinwg(int orderid, String customername, String customerphone, String customeridcard,
			String customersex, String roomnumber, Integer roomtypeid, String roomtypename, String empnumber2,
			int roomprice, int orderstatus) {
		String sql="insert into orderinfo(orderid,customername,customerphone,customeridcard,customersex,roomnumber,"
				+ "roomtypeid,roomtypename,empnumber2,checkintime,roomprice,orderstatus) "
				+ "value(?,?,?,?,?,?,?,?,?,SYSDATE(),?,?)";
		return od.AddOrderOfCheckinwg(sql, orderid, customername, customerphone, customeridcard, customersex, 
				roomnumber, roomtypeid, roomtypename, empnumber2,
				roomprice, orderstatus);
	}

	@Override
	public int AddOrderOfCheckinAfterOrderwg(String empnumber2, String roomnumber) {
		String sql="update orderinfo set empnumber2=?,checkintime=SYSDATE() where roomnumber=? AND orderstatus=0";
		return od.AddOrderOfCheckinAfterOrderwg(sql, empnumber2, roomnumber);
	}

	@Override
	public Orderinfo getOrderinfoByRoomNumber(String roomnumber) {
		String sql="select * from orderinfo where orderstatus=0 and roomnumber=?";
		return od.getOrderinfoByRoomNumber(sql,roomnumber);
	}

	@Override
	public int CheckOutRoomByRoomNumber(String empnumber3, int roomtotalprice, int statydays,
			int orderstatus, String roomnumber) {
		String sql="update orderinfo set empnumber3=?,checkouttime=SYSDATE(),roomtotalprice=?,statydays=?,orderstatus=? where roomnumber=? and orderstatus=0";
		return od.CheckOutRoomByRoomNumber(sql,empnumber3,roomtotalprice,statydays,orderstatus,roomnumber);
	}

	@Override
	public int checkoutAfterOrderByRoomNumber(int i, String roomnumber) {
		String sql="update orderinfo set orderstatus=? where roomnumber=? and orderstatus=0 and checkintime is null ";
		return od.checkoutAfterOrderByRoomNumber(sql,i,roomnumber);
	}

	

	

	
	

}
