package com.hs.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.entity.Orderinfo;
import com.hs.entity.User;
import com.hs.service.OrderServicewg;
import com.hs.service.impl.OrderServicewgImpl;
import com.hs.utils.DateFormatDefinition;
import com.hs.utils.JSONUtil;
import com.hs.utils.PrintWriterwg;


@WebServlet("/CheckOutwgServlet")
public class CheckOutwgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckOutwgServlet() {
        super();
    }
    
    /**
     * 接收房间编号和flag
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		OrderServicewg os=new OrderServicewgImpl();
		//退房操作：员工编号、退房时间、结算入住天数、计算房价、查询商品消费情况、改变账单状态、改变房间状态
		
		String roomnumber=request.getParameter("roomnumber");//房间编号
		
		//员工信息
		User user=(User) request.getSession().getAttribute("user");
//		String empnumber3=user.getEmpnumber();//员工编号
		String empnumber3="201510930100";//员工编号
		//退房时间
		String checkouttime=DateFormatDefinition.MySQLSystemDateTimeStr();//顾客退房时的系统时间
		
		//结算入住天数
		//获取入住时间
		Orderinfo orderinfo=os.getOrderinfoByRoomNumber(roomnumber);
		System.out.println(orderinfo);
		String checkintime=orderinfo.getCheckintime();
		int statydays = DateFormatDefinition.statydays(checkintime,checkouttime);
		
		//计算房价
		int roomtotalprice=statydays*orderinfo.getRoomprice();
		
		//账单状态：orderstatus：1--完结（已退房）
		int orderstatus=1;
		
		
		String flagStr=request.getParameter("flag");
		int flag=Integer.parseInt(flagStr);
		if(flag==0) {//返回账单信息
			orderinfo.setStatydays(statydays);//保存入住天数
			orderinfo.setRoomtotalprice(roomtotalprice);//总共房价
			//返回账单信息，让顾客确认消费情况
			PrintWriterwg.out(response, JSONUtil.toJson(orderinfo));
		}else if(flag==1) {//开始退房操作
			//修改账单信息
			int result=os.CheckOutRoomByRoomNumber(empnumber3,roomtotalprice,statydays,orderstatus,roomnumber);
			if(result==1) {
				//修改房间状态roomstatus的值变为：3--打扫中
				//根据房间编号查询房间对象，修改房间对象的roomstatus属性的值改为3
				int roomstatus=3;
				int result1=os.UpdateRoomStatusByRoomNumber(roomstatus,roomnumber);//更新成功则result1的返回值为1
				if(result1==1) {
					//返回result值为1则说明退房成功
					PrintWriterwg.out(response, JSONUtil.toJson(result));
				}else {
					//返回result值为1则说明退房成功
					PrintWriterwg.out(response, JSONUtil.toJson(0));
				}
			}else {
				//返回result值为1则说明退房成功
				PrintWriterwg.out(response, JSONUtil.toJson(0));
			}
		}else if(flag==2){//无操作
//			PrintWriterwg.out(response, JSONUtil.toJson(3));
//			System.out.println(flag+"123");
			//页面跳转
			request.getRequestDispatcher("Reception.html").forward(request, response);
		}else {
//			response.getWriter().println(JSONUtil.toJson(000));
			//页面跳转
			request.getRequestDispatcher("Reception.html").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
