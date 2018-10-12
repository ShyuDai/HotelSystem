package com.hs.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name="/UserServletGH",urlPatterns="/userServlet")
public class UserServletGH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserServletGH() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");
	        String flagStr=request.getParameter("flag");
	        int flag=Integer.parseInt(flagStr);
	        switch (flag) {
			case 1:
				
				break;

            case 2:
				
				break;
			default:
				break;
			}
	        
	        

	}
	
	
	
	

}
