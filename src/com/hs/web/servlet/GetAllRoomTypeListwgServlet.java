package com.hs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.hs.entity.Room;
import com.hs.entity.Roomtype;
import com.hs.service.OrderServicewg;
import com.hs.service.impl.OrderServicewgImpl;
import com.hs.utils.JSONUtil;
import com.hs.utils.PrintWriterwg;

@WebServlet("/GetAllRoomTypeListwgServlet")
public class GetAllRoomTypeListwgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAllRoomTypeListwgServlet() {
        super();
    }
    
    @Test
    public void sysotest() {
    	OrderServicewg os=new OrderServicewgImpl();
		List<Roomtype> typelist=os.getAllRoomTypewg();
    	System.out.println(typelist);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		//Ajax异步请求
		//查询所有房间类别传给jsp
		OrderServicewg os=new OrderServicewgImpl();
		List<Roomtype> typelist=os.getAllRoomTypewg();
		String typelistjson=JSONUtil.toJson(typelist);
		
		PrintWriterwg.out(response, typelistjson);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
