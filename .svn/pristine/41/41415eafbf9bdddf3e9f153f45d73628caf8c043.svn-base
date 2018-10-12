package com.hs.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.hs.entity.Room;
import com.hs.service.OrderServicewg;
import com.hs.service.impl.OrderServicewgImpl;
import com.hs.utils.JSONUtil;
import com.hs.utils.PrintWriterwg;



@WebServlet("/GetAllRoomListByRoomTypewgServlet")
public class GetAllRoomListByRoomTypewgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllRoomListByRoomTypewgServlet() {
        super();
    }
    
    @Test
    public void sysotest() {
    	OrderServicewg os=new OrderServicewgImpl();
    	List<Room> roomlist=os.getAllRoomListByRoomTypeId(1);
    	System.out.println(roomlist);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		//Ajax异步请求
		//根据房间类别查询所有目前可用的房间列表传给jsp
		String roomtypeidStr=request.getParameter("roomtypeid");
		int roomtypeid=Integer.parseInt(roomtypeidStr);
		OrderServicewg os=new OrderServicewgImpl();
		List<Room> roomlist=os.getAllRoomListByRoomTypeId(roomtypeid);
		String roomlistjson=JSONUtil.toJson(roomlist);
		
		PrintWriterwg.out(response, roomlistjson);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
