package com.hs.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.hs.entity.Room;
import com.hs.entity.Roomtype;
import com.hs.entity.User;
import com.hs.service.OrderServicewg;
import com.hs.service.impl.OrderServicewgImpl;
import com.hs.utils.JSONUtil;
import com.hs.utils.PrintWriterwg;


@WebServlet("/ChangeRoomNumberwgServlet")
public class ChangeRoomNumberwgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeRoomNumberwgServlet() {
        super();
    }
    
    /**
     * 接收两个房间编号
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		OrderServicewg os=new OrderServicewgImpl();
		//换房操作：获取两个房间编号、修改两个房间状态、换房服务的员工编号
		
		//1.接收房间编号（之前和之后）
		String oldroomnumber=request.getParameter("");
		String newroomnumber=request.getParameter("");
		//2.根据房间编号修改房间状态
		int result1=os.UpdateRoomStatusByRoomNumber(0, oldroomnumber);//以前的房间，状态改为0--空闲
		int result2=os.UpdateRoomStatusByRoomNumber(1, newroomnumber);//新房间，状态改为1--预定
		//3.根据房间编号修改账单的房间信息
		//根据房间编号查询房间对象
		Room room=os.getRoomByRoomNumber(newroomnumber);
		Roomtype roomtype=os.getRoomTypeByRoomTypeId(room.getRoomtypeid());
		
		//员工信息
		User user=(User) request.getSession().getAttribute("user");
		String empnumber4=user.getEmpnumber();//员工编号
		
		//将原先的房间信息修改(房间编号、换房员工编号)
		int result=os.ChangeRoomInfoByOldRoomNumber(newroomnumber,room.getRoomtypeid(),room.getRoomtypename(),empnumber4,roomtype.getRoomtypeprice(),oldroomnumber);
		//返回数据result:1--成功
		PrintWriterwg.out(response, JSONUtil.toJson(result));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
