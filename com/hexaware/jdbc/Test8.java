package com.hexaware.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test8 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexaware", "root",".Kush123");
		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		statement.addBatch("update ram set bal=bal-10000 where accno=100");
		statement.addBatch("update kush set bal=bal+10000 where accno=100");
		int x[] = statement.executeBatch();
		
		if(x[0] > 0 & x[1] > 0) {
			connection.commit();
			System.out.println("funds transferred successfully, have a great day...");
		}
		else
		{
			connection.rollback();
			System.out.println("something went wrong in your account, please check it once");
		}
		
	}
	

}
	

