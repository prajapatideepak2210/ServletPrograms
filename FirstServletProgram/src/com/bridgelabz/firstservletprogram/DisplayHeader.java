package com.bridgelabz.firstservletprogram;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DisplayHeader extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		 
	      PrintWriter printWriter = response.getWriter();
	      String title = "Welcome to first example of Servlet";

	      printWriter.println("<html>\n" +"<head><title>" + title + "</title></head>\n"+
	         "<body bgcolor=\"gray\">\n" + "<h1>" + title + "</h1>\n");
	      printWriter.println("</table>\n</body></html>");
	      printWriter.close();
	}
}
