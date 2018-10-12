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

@WebServlet("/ToOrderRoomServletwg")
public class ToOrderRoomServletwg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ToOrderRoomServletwg() {
        super();
    }
    
    @Test
    public void sysotest() {
    	OrderServicewg os=new OrderServicewgImpl();
    	List<Room> roomlist=os.getAllRoomListwg();
    	System.out.println(roomlist);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		OrderServicewg os=new OrderServicewgImpl();
		//鑾峰彇鎵�鏈夋埧闂寸殑淇℃伅浼犻�掔粰鐣岄潰
		//鎴块棿缂栧彿锛屾埧闂寸姸鎬佺爜
		List<Room> roomlist=os.getAllRoomListwg();
		//杩斿洖json
		PrintWriterwg.out(response, JSONUtil.toJson(roomlist));
		
		//璺宠浆鍒伴瀹氭埧闂磈sp鐣岄潰
		//璇锋眰杞彂
//		request.getRequestDispatcher("").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
