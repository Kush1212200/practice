package com.hexaware.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class loaded");
		String url = "jdbc:mysql://127.0.0.1:3306/hexaware" ;
		String root = "root";
		String pass = ".Kush123";
	    Connection conn =	DriverManager.getConnection(url, root, pass);
	    
	   System.out.println("I got the connection.");
	   
	   Statement st = conn.createStatement();
	   
	   int x = st.executeUpdate("Delete from  employees where fname = 'Aish'");
	   System.out.println(x +" " + "row(s) affected");
	   conn.close();
	}

}
