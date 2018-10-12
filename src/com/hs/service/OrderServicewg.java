package com.hs.service;

import java.util.List;

import com.hs.entity.Orderinfo;
import com.hs.entity.Room;
import com.hs.entity.Roomtype;

public interface OrderServicewg {
	// 获取所有房间类型，返回列表
	List<Roomtype> getAllRoomTypewg();

	// 根据房间类型id查询所有房间对象，返回列表
	List<Room> getAllRoomListByRoomTypeId(int roomtypeid);

	// 根据房间类型id查询房间类型对象
	Roomtype getRoomTypeByRoomTypeId(int roomtypeid);

	// 根据房间编号修改房间状态码，返回int
	int UpdateRoomStatusByRoomNumber(int roomstatus, String roomnumber);

	// 根据顾客身份证号码查询顾客是否已存在，返回int
	int customerIsExit(String customeridcard);

	// 添加新顾客信息，返回int
	int addCustomerInfo(String customername, String customersex, String customeridcard, String customerphone);

	// 预定功能
	int OrderRoomServletwg(int orderid, String customername, String customerphone, String customeridcard,
			String customersex, String roomnumber, int roomtypeid, String roomtypename, String empnumber1,
			int roomprice, int orderstatus);

	// 获取所有房间信息，返回列表
	List<Room> getAllRoomListwg();
	
	//根据房间编号查询房间对象
	Room getRoomByRoomNumber(String newroomnumber);
	
	//根据房间编号修改房间信息
	int ChangeRoomInfoByOldRoomNumber(String newroomnumber, Integer roomtypeid, String roomtypename,String empnumber4, Integer roomtypeprice,
			String oldroomnumber);
	
	//直接入住，添加账单信息
	int AddOrderOfCheckinwg(int orderid, String customername, String customerphone, String customeridcard,
			String customersex, String roomnumber, Integer roomtypeid, String roomtypename, String empnumber2,
			int roomprice, int orderstatus);
	
	//预定之后入住，添加账单信息
	int AddOrderOfCheckinAfterOrderwg(String empnumber2, String roomnumber);
	
	//退房时，根据房间编号查询账单对象
	Orderinfo getOrderinfoByRoomNumber(String roomnumber);

	//退房时，修改账单信息
	int CheckOutRoomByRoomNumber(String empnumber3, int roomtotalprice, int statydays,
			int orderstatus, String roomnumber);
	
	//取消预定
	int checkoutAfterOrderByRoomNumber(int i, String roomnumber);

	
	
	

}
