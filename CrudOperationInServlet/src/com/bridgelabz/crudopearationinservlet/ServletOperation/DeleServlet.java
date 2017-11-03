package com.bridgelabz.crudopearationinservlet.ServletOperation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.crudopearationinservlet.DAO.DaoUtility;

public class DeleServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)   
			throws ServletException, IOException {  
		response.setContentType("text/html");  
		PrintWriter printWriter=response.getWriter();  
		
		int employeeId=Integer.parseInt(request.getParameter("id"));
		
		Employee employee=new Employee();  
		employee.setId(employeeId);
		
		DaoUtility daoUtility=new DaoUtility();
		boolean check=daoUtility.deleteData(employee);
		if(check){
			printWriter.print("Data Deleted.");
			request.getRequestDispatcher("delete.html").include(request, response);
		}
		else{
			printWriter.print("Data is not deleted.");
			request.getRequestDispatcher("delete.html").include(request, response);
		}
		printWriter.flush();
		printWriter.close();  
	}  
}
