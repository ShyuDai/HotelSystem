package com.hs.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.hs.entity.Customer;
import com.hs.entity.Room;
import com.hs.service.CustomerServiceGH;
import com.hs.utils.PageCount;
import com.hs.utils.PageResult;
import com.hs.utils.SQL;

/**
 * Servlet implementation class CustomerServletGH
 */
@WebServlet(name="/CustomerServletGH",urlPatterns="/customerServlet")
public class CustomerServletGH extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static int pageSize=12;
	
	private CustomerServiceGH cservice=new CustomerServiceGH();
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String flagStr=request.getParameter("flag");
        int flag=Integer.parseInt(flagStr);
        switch (flag){
            case 1://分页查询顾客表
                doQueryByPage(request,response);
                break;


            case 2:


                break;

            case 3:


                break;
        }
	}
	
	//根据关键字查询顾客表
	 private void doQueryByPage(HttpServletRequest request,HttpServletResponse response) throws IOException {
	       /* int attruCode=4;
	        String value="标准大床房";
	        int pageNo=1;*/
	        String pageNoStr=request.getParameter("pageNo");
	        int pageNo=Integer.parseInt(pageNoStr);

	        String attruCodeStr=request.getParameter("attruCode");
	        int attruCode=Integer.parseInt(attruCodeStr);

	        String value=request.getParameter("value");
	        
	       // System.out.println("1--->customer查询数量的sql语句："+SQL.getCustomerQueryByCount(attruCode,value));
	       // System.out.println("2--->customer查询集合的-->sql语句："+ SQL.getCustomerQuerySqlByPage(pageNo,pageSize,attruCode,value));

	        PageResult pr=new PageResult();
	    
	        pr.setToatalCount(cservice.getCustomerCount(attruCode, value));
	        pr.setPageSize(pageSize);
	        pr.setPageCount(PageCount.getPageCount(pr.getToatalCount(),pageSize));
	        if(pageNo<1){
	            pageNo=1;
	        }
	        if(pageNo>pr.getPageCount()){
	            pageNo=pr.getPageCount();
	        }
	        pr.setPageNo(pageNo);
	        
	        if(pageNo>0&&pageNo<=pr.getPageCount()) {
            List<Customer> list=cservice.getCustomersByPage(pageNo,pageSize,attruCode,value);
	        pr.setList(list);
	        }
	        
	        PrintWriter out = response.getWriter();
	        out.print(new GsonBuilder().create().toJson(pr));
	        out.flush();;
	        out.close();
	    }


}
