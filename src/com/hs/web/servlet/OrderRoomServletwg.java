package com.hs.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.entity.Room;
import com.hs.entity.Roomtype;
import com.hs.entity.User;
import com.hs.service.OrderServicewg;
import com.hs.service.impl.OrderServicewgImpl;
import com.hs.utils.DateFormatDefinition;
import com.hs.utils.IDUtils;
import com.hs.utils.JSONUtil;
import com.hs.utils.PrintWriterwg;

@WebServlet("/OrderRoomServletwg")
public class OrderRoomServletwg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderRoomServletwg() {
		super();
	}

	/**
	 * 空闲房间的预定操作 已完成
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		OrderServicewg os = new OrderServicewgImpl();
		// 获取预定房间的顾客的信息
		// 生成订单编号：时间+随机数
		String s = IDUtils.genItemId() + "";
		int orderid = Integer.parseInt(s);
		// 订单编号、顾客姓名、联系方式、顾客身份证号码、顾客性别、房间信息（房间编号）、房间类型id、房间类型名称、预定日期时间、房间当日单价、账单状态、提供服务的员工编号

		// 顾客信息
		String customername = request.getParameter("customername");
		String customerphone = request.getParameter("customerphone");
		String customeridcard = request.getParameter("customeridcard");
		String customersex = request.getParameter("customersex");// 1--男，0--女
//		System.out.println("customername---"+customername);
		// 判断是否是老顾客，根据身份证号码查询
		int count1 = os.customerIsExit(customeridcard);
		int count2 = 0;
		if (count1 == 0) {
			// 新顾客
			// 添加顾客基本信息到数据库
			count2 = os.addCustomerInfo(customername, customersex, customeridcard, customerphone);
		}

		// 房间信息
		String roomnumber = request.getParameter("roomnumber");// 房间编号
		Room room = os.getRoomByRoomNumber(roomnumber);
		String roomtypeidStr = room.getRoomtypeid() + "";
		int roomtypeid = Integer.parseInt(roomtypeidStr);// 房间类型id
		Roomtype roomtype = os.getRoomTypeByRoomTypeId(roomtypeid);// 根据房间类型的id查询类型对象
		String roomtypename = roomtype.getRoomtypename();// 房间类型名称
		int roomprice = roomtype.getRoomtypeprice();// 当前时间下的房间单价：元/间/天

		// 员工信息
		User user = (User) request.getSession().getAttribute("user");
//		String empnumber1=user.getEmpnumber();//员工编号
		String empnumber1 = "2015109301";// 员工编号

		// 预定时间
//		String ordertime=DateFormatDefinition.SimpleDateFormatwg();//顾客预定时的系统时间

		// 账单状态status的值变为：0--未完结
		int status = 0;// 账单状态

		// 开始保存账单信息
		int result2 = os.OrderRoomServletwg(orderid, customername, customerphone, customeridcard, customersex,
				roomnumber, roomtypeid, roomtypename, empnumber1, roomprice, status);

		// 返回result2值为1则说明预定成功
//		PrintWriterwg.out(response, result2);
		if (result2 == 1) {
			// 修改房间状态roomstatus的值变为：1--预定
			// 根据房间编号查询房间对象，修改房间对象的roomstatus属性的值改为1
			int roomstatus = 1;
			int result1 = os.UpdateRoomStatusByRoomNumber(roomstatus, roomnumber);// 更新成功则result1的返回值为1
			if (result1 == 1) {
				PrintWriterwg.out(response, JSONUtil.toJson(result1));
			} else {
				PrintWriterwg.out(response, JSONUtil.toJson(0));
			}
		} else {
			PrintWriterwg.out(response, JSONUtil.toJson(0));
		}

		PrintWriterwg.out(response, JSONUtil.toJson(0));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
