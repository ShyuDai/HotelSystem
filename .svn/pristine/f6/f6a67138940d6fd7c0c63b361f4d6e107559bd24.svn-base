package com.hs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hs.dao.OrderDaowg;
import com.hs.entity.Orderinfo;
import com.hs.entity.Room;
import com.hs.entity.Roomtype;
import com.hs.utils.BaseDaoImplwg;

public class OrderDaowgImpl extends BaseDaoImplwg implements OrderDaowg{
	
	protected ResultSet rs = null;

	@Override
	public List<Roomtype> getAllRoomTypewg(String sql) {
		List<Roomtype> list=new ArrayList<>();
		rs=executeQuerywg(sql);
		try {
			while (rs.next()) {
				Roomtype type=new Roomtype();
				type.setRoomtypeid(rs.getInt("roomtypeid"));
				type.setRoomtypename(rs.getString("roomtypename"));
				type.setRoomtypeintroduce(rs.getString("roomtypeintroduce"));
				type.setRoomtypeprice(rs.getInt("roomtypeprice"));
				list.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Room> getAllRoomListByRoomTypeId(String sql, int roomtypeid) {
		List<Room> roomlist=new ArrayList<>(); 
		rs=executeQuerywg(sql, roomtypeid);
		try {
			while(rs.next()) {//返回：roomid,roomnumber,roomintroduce
				Room room=new Room();
				room.setRoomid(rs.getInt("roomid"));
				room.setRoomnumber(rs.getString("roomnumber"));
				room.setRoomtypeid(rs.getInt("roomtypeid"));
				room.setRoomtypename(rs.getString("roomtypename"));
				room.setRoomintroduce(rs.getString("roomintroduce"));
				room.setRoomstatus(rs.getInt("roomstatus"));
				roomlist.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomlist;
	}

	@Override
	public Roomtype getRoomTypeByRoomTypeId(String sql, int roomtypeid) {
		Roomtype type=null;
		rs=executeQuerywg(sql, roomtypeid);
		try {
			while(rs.next()) {
				type=new Roomtype();
				type.setRoomtypeid(rs.getInt("roomtypeid"));
				type.setRoomtypename(rs.getString("roomtypename"));
				type.setRoomtypeintroduce(rs.getString("roomtypeintroduce"));
				type.setRoomtypeprice(rs.getInt("roomtypeprice"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public int UpdateRoomStatusByRoomNumber(String sql, int roomstatus, String roomnumber) {
		int result=executeUpdatewg(sql, roomstatus,roomnumber);
		return result;
	}

	@Override
	public int customerIsExit(String sql, String customeridcard) {
		int count=0;
		rs=executeQuerywg(sql, customeridcard);
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int addCustomerInfo(String sql, String customername, String customersex, String customeridcard,
			String customerphone) {
		return executeUpdatewg(sql, customername, customersex, customeridcard, customerphone);
	}

	@Override
	public int OrderRoomServletwg(String sql, int orderid, String customername, String customerphone,
			String customeridcard, String customersex, String roomnumber, int roomtypeid, String roomtypename,
			String empnumber1,int roomprice, int status) {
		//返回
		return executeUpdatewg(sql, orderid, customername, customerphone, customeridcard,
				 customersex, roomnumber, roomtypeid, roomtypename, empnumber1,
				 roomprice, status);
	}

	@Override
	public List<Room> getAllRoomListwg(String sql) {
		List<Room> roomlist=new ArrayList<>(); 
		rs=executeQuerywg(sql);
		try {
			while(rs.next()) {//返回room对象全部属性值
				Room room=new Room();
				room.setRoomid(rs.getInt("roomid"));
				room.setRoomnumber(rs.getString("roomnumber"));
				room.setRoomtypeid(rs.getInt("roomtypeid"));
				room.setRoomtypename(rs.getString("roomtypename"));
				room.setRoomintroduce(rs.getString("roomintroduce"));
				room.setRoomstatus(rs.getInt("roomstatus"));
				roomlist.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomlist;
	}

	@Override
	public Room getRoomByRoomNumberwg(String sql, String newroomnumber) {
		Room room=null;
		rs=executeQuerywg(sql, newroomnumber);
		try {
			while(rs.next()) {
				room=new Room();
				room.setRoomid(rs.getInt("roomid"));
				room.setRoomnumber(rs.getString("roomnumber"));
				room.setRoomtypeid(rs.getInt("roomtypeid"));
				room.setRoomtypename(rs.getString("roomtypename"));
				room.setRoomintroduce(rs.getString("roomintroduce"));
				room.setRoomstatus(rs.getInt("roomstatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}

	@Override
	public int ChangeRoomInfoByOldRoomNumber(String sql, String newroomnumber, Integer roomtypeid, String roomtypename,String empnumber4,
			Integer roomtypeprice, String oldroomnumber) {
		return executeUpdatewg( sql, newroomnumber, roomtypeid, roomtypename,empnumber4, roomtypeprice, oldroomnumber);
	}

	@Override
	public int AddOrderOfCheckinwg(String sql, int orderid, String customername, String customerphone,
			String customeridcard, String customersex, String roomnumber, Integer roomtypeid, String roomtypename,
			String empnumber2, int roomprice, int orderstatus) {
		
		return executeUpdatewg(sql, orderid, customername, customerphone, customeridcard, customersex, 
				roomnumber, roomtypeid, roomtypename, empnumber2,
				roomprice, orderstatus);
	}

	@Override
	public int AddOrderOfCheckinAfterOrderwg(String sql, String empnumber2, String roomnumber) {
		return executeUpdatewg(sql, empnumber2, roomnumber);
	}

	@Override
	public Orderinfo getOrderinfoByRoomNumber(String sql, String roomnumber) {
		Orderinfo orderinfo=null;
		rs=executeQuerywg(sql, roomnumber);
		try {
			while(rs.next()) {
				orderinfo=new Orderinfo();
				orderinfo.setOrderid(rs.getInt("orderid"));
				orderinfo.setCustomername(rs.getString("customername"));
				orderinfo.setCustomerphone(rs.getString("customerphone"));
				orderinfo.setCustomeridcard(rs.getString("customeridcard"));
				orderinfo.setCustomersex(rs.getString("customersex"));
				orderinfo.setRoomnumber(rs.getString("roomnumber"));
				orderinfo.setRoomtypeid(rs.getInt("roomtypeid"));
				orderinfo.setRoomtypename(rs.getString("roomtypename"));
				orderinfo.setEmpnumber1(rs.getString("empnumber1"));
				orderinfo.setEmpnumber2(rs.getString("empnumber2"));
				orderinfo.setEmpnumber3(rs.getString("empnumber3"));
				orderinfo.setEmpnumber4(rs.getString("empnumber4"));
				orderinfo.setOrdertime(rs.getString("ordertime"));
				orderinfo.setCheckintime(rs.getString("checkintime"));
				orderinfo.setCheckouttime(rs.getString("checkouttime"));
				orderinfo.setRoomprice(rs.getInt("roomprice"));
				orderinfo.setRoomtotalprice(rs.getInt("roomtotalprice"));
				orderinfo.setServicetotalprice(rs.getInt("servicetotalprice"));
				orderinfo.setStatydays(rs.getInt("statydays"));
				orderinfo.setOrderstatus(rs.getInt("orderstatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderinfo;
	}

	@Override
	public int CheckOutRoomByRoomNumber(String sql, String empnumber3, int roomtotalprice,
			int statydays, int orderstatus, String roomnumber) {
		return executeUpdatewg(sql,empnumber3,roomtotalprice,statydays,orderstatus,roomnumber);
	}

	@Override
	public int checkoutAfterOrderByRoomNumber(String sql, int i, String roomnumber) {
		return executeUpdatewg(sql, i,roomnumber);
	}

	
	

}
