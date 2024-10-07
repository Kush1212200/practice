package com.hexaware.jdbc;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class Test3 {
		
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			//loading the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//obtain the connection 
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexaware","root",".Kush123");
		
		    //create the Statement object
			
			Statement statement = connection.createStatement();
		
			ResultSet rs = statement.executeQuery("select * From student");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
			
			connection.close();
			
		}

	}

