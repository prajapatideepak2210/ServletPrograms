package com.bridgelabz.crudopearationinservlet.ServletOperation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.crudopearationinservlet.DAO.DaoUtility;

public class UpdateServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter printWriter=response.getWriter();  
		
		int employeeId=Integer.parseInt(request.getParameter("id"));
		String employeeName=request.getParameter("name");  
		String contactNumber=request.getParameter("contact");  
		String email=request.getParameter("email");  
		String city=request.getParameter("city");  
		
		Employee employee=new Employee();  
		employee.setId(employeeId);
		employee.setEmployeeName(employeeName);  
		employee.setContactNumber(contactNumber); 
		employee.setEmail(email);  
		employee.setCity(city); 
		
		DaoUtility daoUtility=new DaoUtility();
		boolean check=daoUtility.updateData(employee);
		if(check)
		{
			printWriter.print("Data Updated");
			request.getRequestDispatcher("update.html").include(request, response);
		}
		else
		{
			printWriter.print("Data is not Updated");
			request.getRequestDispatcher("update.html").include(request, response);
		}
		printWriter.flush();
		printWriter.close();  
	}
}
