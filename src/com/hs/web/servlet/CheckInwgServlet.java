package com.hs.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.entity.Orderinfo;
import com.hs.entity.Room;
import com.hs.entity.Roomtype;
import com.hs.entity.User;
import com.hs.service.OrderServicewg;
import com.hs.service.impl.OrderServicewgImpl;
import com.hs.utils.DateFormatDefinition;
import com.hs.utils.IDUtils;
import com.hs.utils.JSONUtil;
import com.hs.utils.PrintWriterwg;


@WebServlet("/CheckInwgServlet")
public class CheckInwgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckInwgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		OrderServicewg os=new OrderServicewgImpl();
		String flagStr=request.getParameter("flag");
		int flag=Integer.parseInt(flagStr);
//		System.out.println("flag----"+flag);
		String roomnumber=request.getParameter("roomnumber");//房间编号
		switch (flag) {
		case 1:		//预定之后入住：接收房间编号和flag==1
			
			//1.预定入住操作:修改房间状态、员工编号empnumber2、入住时间、
			//接收数据：flag（预定入住操作路径）、房间信息（roomnumber）。。。。。。。。。。。。待定
//			System.out.println("roomnumber---"+roomnumber);
			
			
			//员工信息
			User user=(User) request.getSession().getAttribute("user");
//			String empnumber2=user.getEmpnumber();//员工编号
			String empnumber2="2015109301";//员工编号
			
			//预定时间
//			String checkintime=DateFormatDefinition.SimpleDateFormatwg();//顾客预定时的系统时间
			
			//根据房间编号添加账单信息（预定之后的入住信息）
			int result2=os.AddOrderOfCheckinAfterOrderwg(empnumber2,roomnumber);
			if(result2==1) {
			//返回result值为1则说明预定成功
				//修改房间状态roomstatus的值变为：2--入住
				//根据房间编号查询房间对象，修改房间对象的roomstatus属性的值改为2
				int roomstatus=2;
				int result1=os.UpdateRoomStatusByRoomNumber(roomstatus,roomnumber);//更新成功则result1的返回值为1
				if(result1==1) {
					PrintWriterwg.out(response, JSONUtil.toJson(result1));
				}else {
					PrintWriterwg.out(response, JSONUtil.toJson(0));
				}
			}else {
				PrintWriterwg.out(response, JSONUtil.toJson(0));
			}
//			
//			
//			
			break;
			
		case 2:		//预定之后的取消：接收房间编号和flag
			
			//取消订单
			int result4=os.checkoutAfterOrderByRoomNumber(1,roomnumber);
			if(result4==1) {
				//根据房间编号去修改房间状态和修改订单状态
//			String roomnumber=request.getParameter("roomnumber");
				//修改房间状态roomstatus的值变为：0--空闲
				int result3=os.UpdateRoomStatusByRoomNumber(0,roomnumber);
				if(result3==1) {
					PrintWriterwg.out(response, JSONUtil.toJson(result3));
				}else {
					PrintWriterwg.out(response, JSONUtil.toJson(0));
				}
				response.sendRedirect("Reception.html");
			}else {
				PrintWriterwg.out(response, JSONUtil.toJson(0));
			}
			
			break;
			
		case 3:		//空房直接入住：0--空闲（已完成）
			
			//2.直接入住操作：添加账单信息、修改房间状态、修改账单状态、员工编号empnumber2
			//接收数据：flag（直接入住操作路径）、房间信息（roomnumber）、顾客信息（姓名、电话、性别、身份证号码）
			//顾客信息
			String customername=request.getParameter("customername");
			String customerphone=request.getParameter("customerphone");
			String customeridcard=request.getParameter("customeridcard");
			String customersex=request.getParameter("customersex");//1--男，0--女
			
//			System.out.println("customername---"+customername);
			
			//判断是否是老顾客，根据身份证号码查询
			int count1=os.customerIsExit(customeridcard);
			int count2=0;
			if(count1==0) {
				//新顾客
				//添加顾客基本信息到数据库
				count2=os.addCustomerInfo(customername,customersex,customeridcard,customerphone);
			}
			
			//房间信息
//			String roomnumber=request.getParameter("roomnumber");//房间编号
//			System.out.println("roomnumber---"+roomnumber);
			Room room=os.getRoomByRoomNumber(roomnumber);
			Roomtype roomtype=os.getRoomTypeByRoomTypeId(room.getRoomtypeid());//根据房间类型的id查询类型对象
			String roomtypename=roomtype.getRoomtypename();//房间类型名称
			int roomprice=roomtype.getRoomtypeprice();//当前时间下的房间单价：元/间/天
			
			//员工信息
			User user1=(User) request.getSession().getAttribute("user");
//			String empnumber2=user1.getEmpnumber();//员工编号
			String empnumber22="2015109301";//员工编号
			
			//预定时间
//			String checkintime=DateFormatDefinition.SimpleDateFormatwg();//顾客预定时的系统时间
			
			//账单状态status的值变为：0--未完结
			int orderstatus=0;//账单状态
			
			//修改房间状态roomstatus的值变为：2--入住
			//根据房间编号查询房间对象，修改房间对象的roomstatus属性的值改为2
			int result6=os.UpdateRoomStatusByRoomNumber(2,roomnumber);//更新成功则result1的返回值为1
			
			//生成订单编号：时间+随机数
			String s=IDUtils.genItemId()+"";
			int orderid=Integer.parseInt(s);
			
			//开始保存账单信息
			int result5=os.AddOrderOfCheckinwg(orderid,customername,
					customerphone,customeridcard,customersex,roomnumber,room.getRoomtypeid(),roomtypename,
					empnumber22,roomprice,orderstatus);
			
			if(result5==1) {
				//返回result值为1则说明预定成功
//			PrintWriterwg.out(response, JSONUtil.toJson(result));
				//页面跳转
//			request.getRequestDispatcher("Reception.html").forward(request, response);
				response.sendRedirect("Reception.html");
			}else {
				System.out.println("数据库影响行数返回值不等于1");
			}
			break;
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
