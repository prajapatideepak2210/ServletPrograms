package com.bridgelabz.crudopearationinservlet.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.bridgelabz.crudopearationinservlet.ServletOperation.Employee;

public class DaoUtility {
	private String driverPath="com.mysql.jdbc.Driver";
	private static String connectionPath="jdbc:mysql://localhost:3306/DEEPAK?user=root&password=password";
	

	public boolean insertEmployee(Employee employee)
	{
		boolean forReturn=false;
		Connection connection=null;
		PreparedStatement preparestatement=null;
		String query="INSERT INTO Employee2 (id,name,contactNumber,email,city) VALUES (?,?,?,?,?)";
		try {
			Class.forName(driverPath);
			connection=DriverManager.getConnection(connectionPath);
			preparestatement=connection.prepareStatement(query);
			preparestatement.setInt(1, employee.getId());
			preparestatement.setString(2,employee.getEmployeeName());  
			preparestatement.setString(3, employee.getContactNumber()); 
			preparestatement.setString(4, employee.getEmail());
			preparestatement.setString(5, employee.getCity());
			int check=preparestatement.executeUpdate();
			if(check>0)
			{
				System.out.println("Data inserted.");
				forReturn=true;
			}
			else
			{
				System.out.println("Data is not inserted.");
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
			if(preparestatement!=null)
			{
				try {
					preparestatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return forReturn;
	}

	 public boolean deleteData(Employee employee)
	 {
		 boolean forReturn=false;
		 Connection connection=null;
		 PreparedStatement preparedstatement=null;
		 String query="delete from Employee2 where id='"+employee.getId()+"'";
		 try {
			Class.forName(driverPath);
			connection=DriverManager.getConnection(connectionPath);
			preparedstatement=connection.prepareStatement(query);
			int check=preparedstatement.executeUpdate();
			if(check>0)
			{
				System.out.println("Data deleted.");
				forReturn=true;
			}
			else
			{
				System.out.println("Data is not deleted.");
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
			
			if(preparedstatement!=null)
			{
				try {
					preparedstatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return forReturn;
	 }
	 
	 public boolean updateData(Employee employee)
	 {
		 boolean forReturn=false;
		 Connection connection=null;
		 PreparedStatement preparedStatement=null;
		 String query="UPDATE Employee2 SET name='"+employee.getEmployeeName()
		 +"',contactNumber='"+employee.getContactNumber()+"',email='"+employee.getEmail()
		 +"',city='"+employee.getCity()+"' where id='"+employee.getId()+"'";
		 
		 
		 try {
			 Class.forName(driverPath);
			 connection=DriverManager.getConnection(connectionPath);
			 preparedStatement=connection.prepareStatement(query);
			 
			 int check=preparedStatement.executeUpdate();
			 if(check>0)
			 {
				 System.out.println("Data updated.");
				 forReturn=true;
			 }
			 else
			 {
				 System.out.println("Data is not updated.");
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
		 return forReturn;
	 }
	 
	 public List<Employee> displayData()
	 {
		 List<Employee> list=new ArrayList<Employee>();  
		 Connection connection=null;
		 PreparedStatement preparedStatement=null;
		 ResultSet resultSet=null;
		 try{
			 Class.forName(driverPath);
			 connection=DriverManager.getConnection(connectionPath); 
			 preparedStatement=connection.prepareStatement("select * from Employee2");  
			 resultSet=preparedStatement.executeQuery();  
			 while(resultSet.next()){  
				 Employee employee=new Employee();  
				 employee.setId(resultSet.getInt(1));  
				 employee.setEmployeeName(resultSet.getString(2));  
				 employee.setContactNumber(resultSet.getString(3));  
				 employee.setEmail(resultSet.getString(4));  
				 employee.setCity(resultSet.getString(5));  
				 list.add(employee);  
			 }  
		 }catch(Exception e){e.printStackTrace();}  
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
			
			if(resultSet!=null)
			{
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		 return list;  
	 }
}

