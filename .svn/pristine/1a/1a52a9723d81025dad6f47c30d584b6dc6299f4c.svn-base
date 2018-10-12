package com.hs.web.servlet;

import com.alibaba.fastjson.JSON;

import com.hs.entity.Room;
import com.hs.service.ManiyRoomService;
import com.hs.service.impl.ManiyRoomServiceImpl;
import com.hs.utils.PageResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author liuzonghua
 * @Package ${PACKAGE_NAME}
 * @Description:
 * @date 2018/9/20 9:41
 */
@WebServlet(name = "ManiyGetRoomServlet",urlPatterns = {"/maniyGetRoomServlet"})
public class ManiyGetRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo =1;
        int pageSize =10;
        String pageNoStr =request.getParameter("pageNo");
        String pageSizeStr =request.getParameter("pageSize");
        if(pageNoStr!=null){
            pageNo=Integer.valueOf(pageNoStr);

        }
        if(pageSizeStr!=null){
            pageSize=Integer.parseInt(pageSizeStr);
        }
        ManiyRoomService maniyRoomService=new ManiyRoomServiceImpl();
        int count=maniyRoomService.roomCount();
        List<Room> roomList =maniyRoomService.getRoomByRoomStatus(pageNo,pageSize);
        System.out.println(roomList);
        PageResult pageResult =new PageResult();
        pageResult.setPageNo(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setList(roomList);
        pageResult.setToatalCount(count);
        if (count%pageSize!=0){
            pageResult.setPageCount(count/pageSize+1);
        }else {
            pageResult.setPageCount(count/pageSize);
        }

        request.setAttribute("pageResult",pageResult);
        System.out.println();
        request.getRequestDispatcher("/room-service.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
