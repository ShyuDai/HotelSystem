package com.hs.web.servlet;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.hs.entity.Goods;
import com.hs.service.ManiyGoodsService;
import com.hs.service.impl.ManiyGoodsServiceImpl;

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
 * @date 2018/9/27 21:20
 */
@WebServlet(name = "ManiyGetGoodsServlet",urlPatterns = {"/maniyGetGoodsServlet"})
public class ManiyGetGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManiyGoodsService maniyGoodsService=new ManiyGoodsServiceImpl();
        List<Goods> goodsList=maniyGoodsService.getGoodsList();



        Gson gs = new Gson();
        String objectStr = gs.toJson(goodsList);
        response.setCharacterEncoding("UTF-8");

        PrintWriter out=response.getWriter();
        out.write(objectStr);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
