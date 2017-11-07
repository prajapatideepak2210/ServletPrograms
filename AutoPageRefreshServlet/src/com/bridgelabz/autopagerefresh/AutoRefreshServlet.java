package com.bridgelabz.autopagerefresh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AutoRefreshServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set refresh, autoload time as 1 seconds
		response.setIntHeader("Refresh", 1);

		// Set response content type
		response.setContentType("text/html");

		// Get current time
		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		if(calendar.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";

		String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
		PrintWriter printWriter = response.getWriter();

		printWriter.println("<html><head><title>Auto Page Refresh</title></head><body bgcolor = \"#f0f0f0\">\n" +
				"<h1 align = \"center\">Auto Page Refresh using Servlet</h1><p>Current Time is: " + CT + "</p></body></html>");
	}
}
