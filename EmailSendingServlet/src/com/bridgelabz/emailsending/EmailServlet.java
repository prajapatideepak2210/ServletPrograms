package com.bridgelabz.emailsending;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String to =request.getParameter("to");
		String from =request.getParameter("from");
		String password=request.getParameter("pass");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		
		Mailer mail=new Mailer();
		mail.send(username, password, from, to, subject, message);
		String title = "Send Email";
		String res = "Sent message successfully....";
		String docType =
				"<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		PrintWriter printWriter=response.getWriter();
		printWriter.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor = \"#f0f0f0\">\n" +
				"<h1 align = \"center\">" + title + "</h1>\n" +
				"<p align = \"center\">" + res + "</p>\n" +
				"</body></html>");
	}
}  

