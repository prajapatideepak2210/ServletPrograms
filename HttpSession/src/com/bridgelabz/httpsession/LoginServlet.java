package com.bridgelabz.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  
		response.setContentType("text/html");  
		PrintWriter printWriter=response.getWriter();  

		String username=request.getParameter("username");  
		String password=request.getParameter("password");  
		ServletConfig servletConfig=getServletConfig();
		
		if(password.equals(servletConfig.getInitParameter("password")) && 
				username.equals(servletConfig.getInitParameter("username"))){  
			request.getRequestDispatcher("profile.html").include(request, response); 
			HttpSession session=request.getSession();  
			session.setAttribute("name",username);  
			 
		}  
		else{  
			printWriter.print("Soory, username and password missmatch!");
			request.getRequestDispatcher("login.html").include(request, response);
		} 
		printWriter.flush();
		printWriter.close();  
	}  
}
