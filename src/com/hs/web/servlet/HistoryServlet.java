package com.hs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hs.entity.Orderinfo;
import com.hs.entity.PageHelperDataResult;
import com.hs.service.OrderServiceYzw;
import com.hs.service.impl.OrderServiceYzwImpl;

@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 设置编码
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String str = request.getParameter("select");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime"); 

		int pageNo = Integer.parseInt(request.getParameter("currentPage"));
		int pageSize = 10;
		int flag = Integer.parseInt(request.getParameter("flag"));
		
		OrderServiceYzw serviceYzw = new OrderServiceYzwImpl();
		
		
		if(flag==1) {//查询所有，查询条件为空
			PageHelperDataResult pageHelper= serviceYzw.getAllCustomer(pageNo, pageSize);
			request.setAttribute("pageHelper", pageHelper);
			request.getRequestDispatcher("/Historical-users.jsp").forward(request, response);
			
		}else if(flag==2){//根据时间段查找
			
		}else if(flag==3&&str.equals("")){//根据用户名查找
			PageHelperDataResult pageHelper= serviceYzw.getAllCustomer(pageNo, pageSize);
			request.setAttribute("pageHelper", pageHelper);
			request.getRequestDispatcher("/Historical-users.jsp").forward(request, response);
		}else if(flag == 3) {
			
			PageHelperDataResult pageHelper = serviceYzw.getCustomerByName(pageNo, pageSize, str);
			request.setAttribute("pageHelper", pageHelper);
			request.getRequestDispatcher("/Historical-users.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		

		
	}

}
