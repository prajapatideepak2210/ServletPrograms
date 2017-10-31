package com.bridgelabz.cookieHandling;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCookie extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response){  
		try{  

			response.setContentType("text/html");  
			PrintWriter printWriter = response.getWriter();  

			String name=request.getParameter("username");  
 
			Cookie cookie=new Cookie("username",name);//creating cookie object  
			response.addCookie(cookie);//adding cookie in the response  
			
			//creating submit button  
			printWriter.print("<html><body bgcolor=\"lightblue\"><h4>Welcome to servlet one Mr. "+name+"</h4>"
					+ "<h4>Please click on the button to go Servlet two.</h4><form action='servlet2'>");  
			printWriter.print("<input type='submit' value='Go'>");  
			printWriter.print("</form></body></html>");  
			
			printWriter.flush();
			printWriter.close();  

		}catch(Exception e){
			System.out.println(e);
		}  
	}  
}
