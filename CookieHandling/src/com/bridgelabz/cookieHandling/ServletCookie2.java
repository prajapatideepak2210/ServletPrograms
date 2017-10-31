package com.bridgelabz.cookieHandling;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCookie2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response){  
		try{  

			response.setContentType("text/html");  
			PrintWriter printWriter = response.getWriter();  

			Cookie cookieArray[]=request.getCookies();
			printWriter.print("<html><body bgcolor=\"gray\">");
			printWriter.print("<h4 align='center'>Hello "+cookieArray[0].getValue());  
			printWriter.print(" we welcomes in Servlet two.</h4></body></html>");
			printWriter.flush();
			printWriter.close();  

		}catch(Exception e){
			System.out.println(e);
		}  
	}  
}
