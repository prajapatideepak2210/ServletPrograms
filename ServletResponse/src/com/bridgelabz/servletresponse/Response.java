package com.bridgelabz.servletresponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")
public class Response extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	 
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
	 
	      String CurrentTime = hour+":"+ minute +":"+ second +" "+ am_pm;
	    
	      PrintWriter printWriter = response.getWriter();
	      String title = "Auto Refresh Header Setting";

	      printWriter.println("<html>\n" +"<head><title>" + title + "</title></head>\n"+
	         "<body bgcolor = \"#f0f0f0\">\n" +"<h1 align = \"center\">" + title + "</h1>\n" +
	         "<p>Current Time is: " + CurrentTime + "</p>\n");
	      printWriter.println("</body>"+ "</html>");
	      
	}
}
