package com.hexaware.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test5 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("driver class loaded");
		
		//get the connection 
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexaware", "root", "");
		
		System.out.println("i got the connection");
		
		PreparedStatement ps = connection.prepareStatement("insert into student values(?,?)");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter student id");
		int x = scanner.nextInt();
		System.out.println("enter student name");
		String y = scanner.next();
		
		ps.setInt(1, x);
		ps.setString(2, y);
		
		int result = ps.executeUpdate();
		
		System.out.println(result + "row(s) inserted");
		
		//close the connection 
		connection.close();
		
	}

}
