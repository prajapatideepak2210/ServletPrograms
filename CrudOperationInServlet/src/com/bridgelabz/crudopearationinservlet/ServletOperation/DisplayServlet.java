package com.bridgelabz.crudopearationinservlet.ServletOperation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.crudopearationinservlet.DAO.DaoUtility;

public class DisplayServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)   
			throws ServletException, IOException {  
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		DaoUtility daoUtility=new DaoUtility();
		List<Employee> list=daoUtility.displayData();

		printWriter.print("<html><body bgcolor='pink'><h3 align='center'>All Employee Data</h3><table border='1px'>"
				+ "<tr><th>ID</th><th>Name</th><th>Contact</th><th>Email</th><th>City</th></tr>");

		for(Employee e:list)
		{
			printWriter.print("<tr><td>"+e.getId()+"</td><td>"+e.getEmployeeName()+"</td><td>"+e.getContactNumber()
			+"</td><td>"+e.getEmail()+"</td><td>"+e.getCity()+"</td></tr>");
		}
		printWriter.print("</table></body></html>");
	}  
}
