package com.hexaware.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test4 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("driver class loaded");
		
		//get the connection 
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexaware", "root", ".Kush123");
		
		System.out.println("i got the connection");
		
		Statement statement = connection.createStatement();
		
		//int x = statement.executeUpdate("insert into student values(104,'aman')");
		int x = statement.executeUpdate("delete from student where stid = '106'");
		//int x = statement.executeUpdate("Update student set st")
		
		System.out.println(x + "row(s) inserted");
		
		//close the connection 
		connection.close();
		
	}

}