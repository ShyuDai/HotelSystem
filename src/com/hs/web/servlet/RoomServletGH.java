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
import com.hs.entity.Room;
import com.hs.entity.Roomtype;
import com.hs.service.RoomServiceGH;
import com.hs.service.RoomTypeServiceGH;
import com.hs.utils.PageCount;
import com.hs.utils.PageResult;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet(name="/RoomServletGH",urlPatterns="/roomServlet")
public class RoomServletGH extends HttpServlet {
	  private static final long serialVersionUID = 1L;
	  private RoomServiceGH roomService=new RoomServiceGH();;
	  private RoomTypeServiceGH roomTypeServiceGH=new RoomTypeServiceGH();
	   private static int pageSize=12;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomServletGH() {
        super();
        // TODO Auto-generated constructor stub
    }


  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String flagStr=request.getParameter("flag");
        int flag=Integer.parseInt(flagStr);
        switch (flag){
            case 1://加载房间类型
            	doQueryRoomTpes(request,response);
                break;

            case 2:
            	//分页查询房间表
            	doQueryByPage(request,response);
                break;

            case 3:


                break;


        }





    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }

    private void doQueryByPage(HttpServletRequest request,HttpServletResponse response) throws IOException {
       /* int attruCode=4;
        String value="标准大床房";
        int pageNo=1;*/
        String pageNoStr=request.getParameter("pageNo");
        int pageNo=Integer.parseInt(pageNoStr);

        String attruCodeStr=request.getParameter("attruCode");
        int attruCode=Integer.parseInt(attruCodeStr);

        String value=request.getParameter("value");

        PageResult pr=new PageResult();
    
        pr.setToatalCount(roomService.getRoomsCount(attruCode,value));
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
        List<Room> list=roomService.getRoomsByPage(pageNo,pageSize,attruCode,value);
        pr.setList(list);
        }
        
        PrintWriter out = response.getWriter();
        out.print(new GsonBuilder().create().toJson(pr));
        out.flush();;
        out.close();
    }
    
    
    private void doQueryRoomTpes(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	List<Roomtype> list=roomTypeServiceGH.getAllRoomTpes();
    	 PrintWriter out = response.getWriter();
         out.print(new GsonBuilder().create().toJson(list));
         out.flush();;
         out.close();
    }



}
