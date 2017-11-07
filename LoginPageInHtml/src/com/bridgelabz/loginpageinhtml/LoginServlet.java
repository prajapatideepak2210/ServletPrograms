package com.bridgelabz.loginpageinhtml;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		String username=request.getParameter("uname");
		String password=request.getParameter("password");
		
		if(username.equals("") || password.equals(""))
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.html");
			requestDispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("Welcome.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
