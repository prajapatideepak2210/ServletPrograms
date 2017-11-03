package com.bridgelabz.internationalizationservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings({ "serial" }) 
public class InternationalizationDemoServlet extends HttpServlet{
	@SuppressWarnings("static-access")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set response content type
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String lang="en";
		String country="US";
		//Get the client's Locale
		Locale local=new Locale(lang, country);
		ResourceBundle bundle = ResourceBundle.getBundle("i18n.MessageBundle", local); 

		printWriter.println("Message in "+Locale.US+" : "+bundle.getString("wish")+"<br/>");  


		Locale.setDefault(new Locale("hi", "ID"));

		bundle = ResourceBundle.getBundle("i18n.MessageBundle");
		printWriter.println("Message in "+local.getDefault()+" : "+bundle.getString("wish"));
	}
}
