package com.bridgelabz.datehandling;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateHandlingServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Date date = new Date();

		out.println("<html><head><title>Date Servlet</title></head><body bgcolor = \"#f0f0f0\">\n" +
				"<h1 align = \"center\">Current Date and Time</h1><h2 align = \"center\">" + date.toString() + "</h2>\n" +
				"</body></html>");
	}
}
