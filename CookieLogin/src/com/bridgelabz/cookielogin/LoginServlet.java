package com.bridgelabz.cookielogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet{
	ServletConfig servletConfig;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletConfig=config;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  
		response.setContentType("text/html");  
		PrintWriter printWriter=response.getWriter();  


		String username=request.getParameter("username");  
		String password=request.getParameter("password");  
		
		if(password.equals(servletConfig.getInitParameter("password")) && 
				username.equals(servletConfig.getInitParameter("name"))){  
			printWriter.print("You are successfully logged in!");  
			printWriter.print("<br>Welcome, "+username);  

			Cookie ck=new Cookie("name",username);  
			response.addCookie(ck);  
		}else{  
			printWriter.print("sorry, username or password error!");  
			request.getRequestDispatcher("index.html").include(request, response);  
		}  
		
		printWriter.flush();
		printWriter.close();  
	}
	
	@Override
	public void destroy() {
	}
}
