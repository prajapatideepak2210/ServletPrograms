package com.bridgelabz.crudopearationinservlet.ServletOperation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.crudopearationinservlet.DAO.DaoUtility;

public class DataInsertServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)   
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
		boolean check=daoUtility.insertEmployee(employee);
		if(check){
			printWriter.print("Data inserted.");
			request.getRequestDispatcher("insert.html").include(request, response);
		}
		else{
			printWriter.print("Data is not inserted.");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		printWriter.flush();
		printWriter.close();  
	}  
}
