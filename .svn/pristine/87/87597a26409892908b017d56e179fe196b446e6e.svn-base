package com.hs.web.servlet;

import com.hs.service.ManiyRoomService;
import com.hs.service.impl.ManiyRoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liuzonghua
 * @Package ${PACKAGE_NAME}
 * @Description:
 * @date 2018/9/20 15:19
 */
@WebServlet(name = "ManiyUpdateStatusServlet",urlPatterns = {"/maniyUpdateStatusServlet"})
public class ManiyUpdateStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String flag="0";
        String flagStr =request.getParameter("flag");
        if(flagStr!=null){
            flag=flagStr;
        }

        switch (flag){
            case "0" :
                PrintWriter out =response.getWriter();
                int result =  updateRoomStatusTo3ByRoomId(request,response);
                out.print(result);
                out.flush();
                out.close();

                break;
            case "1":
                PrintWriter out1 =response.getWriter();
                int result1 =  updateRoomStatusTo0ByRoomId(request,response);
                out1.print(result1);
                out1.flush();
                out1.close();

                break;
            default:
                break;
        }


    }
    public int updateRoomStatusTo3ByRoomId(HttpServletRequest request, HttpServletResponse response){
        int roomid = Integer.parseInt(request.getParameter("roomId"));
        ManiyRoomService roomService =new ManiyRoomServiceImpl();
        int flag =roomService.updateRoomStatusTo3ByRoomId(roomid);
        return  flag;
    }
    public int updateRoomStatusTo0ByRoomId(HttpServletRequest request, HttpServletResponse response){
        int roomid = Integer.parseInt(request.getParameter("roomId"));
        ManiyRoomService roomService =new ManiyRoomServiceImpl();
        int flag =roomService.updateRoomStatusTo0ByRoomId(roomid);
        return  flag;
    }


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
