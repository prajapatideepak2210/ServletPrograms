package com.bridgelabz.servletfilters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/filter")
public class FilterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter printWriter=response.getWriter();
		printWriter.write("<html><body bgcolor=\"gray\"><h2 align=\"center\">Welcome to Servlet, "
				+ "You have entered in Servlet.</h2></body></html>");
		
		printWriter.flush();
		printWriter.close();
	}
}
