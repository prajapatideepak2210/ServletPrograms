package com.bridgelabz.fileuploading;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 200177215) 
public class FileUploadServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String query="INSERT INTO FileUpload (id,filename) VALUES (?,?)";
		PrintWriter printWriter=response.getWriter();
		InputStream inputStream = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			printWriter.println("driver Uploaded");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/DEEPAK?user=root&password=password");
			printWriter.println("Connection Established");
			preparedStatement=connection.prepareStatement(query);
			printWriter.println("prepared the statement");
			
	        Part filePart = request.getPart("filename");
	        if (filePart != null) {
	            inputStream = filePart.getInputStream();
	        }
			preparedStatement.setString(1, request.getParameter("fileid"));
			preparedStatement.setBlob(2, inputStream);
			int check=preparedStatement.executeUpdate();
			if(check>0)
			{
				printWriter.println("\n File Uploaded");
			}
			else{
				printWriter.print("File is not uploaded.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null)
			{
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}  
}
