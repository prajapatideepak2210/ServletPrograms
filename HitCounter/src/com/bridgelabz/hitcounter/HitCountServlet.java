package com.bridgelabz.hitcounter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HitCountServlet extends HttpServlet{
	private int hitCount; 

	public void init() { 
		// Reset hit counter.
		hitCount = 0;
	} 

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");

		// This method executes whenever the servlet is hit 
		// increment hitCount 
		hitCount++; 
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html><head><title>hit counter</title></head><body bgcolor = \"#f0f0f0\">\n" +
				"<h1 align = \"center\">Total Number of Hits</h1><h2 align = \"center\">" + hitCount + "</h2>\n" +
				"</body></html>");
	}
}
