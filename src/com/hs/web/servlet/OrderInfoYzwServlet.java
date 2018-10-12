package com.hs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hs.dao.OrderDaoYzw;
import com.hs.dao.impl.OrderDaoYzwImpl;
import com.hs.entity.Orderinfo;
import com.hs.entity.PageHelperDataResult;
import com.hs.service.OrderServiceYzw;
import com.hs.service.impl.OrderServiceYzwImpl;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.sun.xml.internal.fastinfoset.algorithm.FloatEncodingAlgorithm;

@WebServlet("/OrderInfoYzwServlet")
public class OrderInfoYzwServlet extends HttpServlet {
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
		
		OrderServiceYzw service = new OrderServiceYzwImpl();
		if(flag == 1) {//查询一段时间内所有订单
			PageHelperDataResult pageHelper = service.getOrderinfoByTime(pageNo, pageSize, starttime, endtime); 
			request.setAttribute("pageHelper", pageHelper);
			request.getRequestDispatcher("/The-profitability.jsp").forward(request, response);
			
		}else if(flag == 2){//查询一段时间内已完成订单
			if(starttime.equals("")||endtime.equals("")) {
				PageHelperDataResult pageHelper = service.getAllOrderinfo(pageNo, pageSize);
				request.setAttribute("pageHelper", pageHelper);
				request.getRequestDispatcher("/The-profitability.jsp").forward(request, response);
				
			}else {
				PageHelperDataResult pageHelper = service.getOrderinfoByTimeAndStatus(pageNo, pageSize, starttime, endtime, 1);
				request.setAttribute("pageHelper", pageHelper);
				request.getRequestDispatcher("/The-profitability.jsp").forward(request, response);
			}
			
		}else if(flag == 3){//查询未完成订单
			PageHelperDataResult pageHelper = service.getOrderinfoByStatus(pageNo, pageSize);
			request.setAttribute("pageHelper", pageHelper);
			request.getRequestDispatcher("/The-profitability.jsp").forward(request, response);
			
		}else if(flag == 4){//查询所有订单
			PageHelperDataResult pageHelper = service.getAllOrderinfo(pageNo, pageSize);
			request.setAttribute("pageHelper", pageHelper);
			request.getRequestDispatcher("/The-profitability.jsp").forward(request, response);
		}else if(flag == 5) {
			if(str.equals("")) {
				PageHelperDataResult pageHelper = service.getAllOrderinfo(pageNo, pageSize);
				request.setAttribute("pageHelper", pageHelper);
				request.getRequestDispatcher("/The-profitability.jsp").forward(request, response);
			}else {
				PageHelperDataResult pageHelper = service.getOrderInfoByNameOrIdcard(pageNo, pageSize, str);
				
				request.setAttribute("pageHelper", pageHelper);
				request.getRequestDispatcher("/The-profitability.jsp").forward(request, response);
			}
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}
	
//	public int getCount(int flag,int pageNo,int pageSize,String starttime,String endtime) {
//		int count = 0;
//		OrderDaoYzw dao=new OrderDaoYzwImpl();
//		if(flag==1) {
//			
//			List<Orderinfo> list = dao.getOrderinfoByTime(pageNo, pageSize, starttime, endtime);
//			for (Orderinfo orderinfo : list) {
//				count =count+orderinfo.getRoomtotalprice()+orderinfo.getServicetotalprice();
//			}
//		}else if(flag == 2){//查询一段时间内已完成订单
//			List<Orderinfo> list = dao.getOrderinfoByTimeAndStatus(pageNo, pageSize, starttime, endtime, 1);
//			for (Orderinfo orderinfo : list) {
//				count =count+orderinfo.getRoomtotalprice()+orderinfo.getServicetotalprice();
//			}
//		}else if(flag == 3){//查询未完成订单
//			List<Orderinfo> list = dao.getOrderinfoByStatus(pageNo, pageSize);
//			for (Orderinfo orderinfo : list) {
//				count =count+orderinfo.getRoomtotalprice()+orderinfo.getServicetotalprice();
//			}
//		}else if(flag == 4){//查询所有订单
//			List<Orderinfo> list = dao.getHistorys(pageNo, pageSize);
//			for (Orderinfo orderinfo : list) {
//				if(orderinfo.getRoomtotalprice()==null&&orderinfo.getServicetotalprice()==null) {
//				count =count+orderinfo.getRoomtotalprice()+orderinfo.getServicetotalprice();
//				}else {
//					count = count;
//				}
//			}
//		}
//		
//		return count;
//	}
	
}
