package com.hexaware.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Loaded the Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hexaware", "root", ".Kush123");
		
		System.out.println("I got the connection");
		
		String sql = "INSERT into employees Values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 123);
		ps.setString(2, "Ram");
		ps.setString(3,"Kumar");
		ps.setString(4, "rk785667@outlook.com");
		ps.setDate(5,java.sql.Date.valueOf("2024-10-03"));
		
		int x = ps.executeUpdate();
		System.out.println(x + "  row(s) affected");
		
		conn.close();
		
		
	} 

}
