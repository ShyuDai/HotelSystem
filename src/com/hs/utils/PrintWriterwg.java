package com.hs.utils;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class PrintWriterwg {
	
	public static void out(HttpServletResponse response,Object obj) throws IOException {
		java.io.PrintWriter out = response.getWriter();
		out.println(obj);
		
		out.flush();
		out.close();
	}
	

}
