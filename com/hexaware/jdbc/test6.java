package com.hexaware.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test6 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexaware", "root", ".Kush123");
		Statement statement = connection.createStatement();
		statement.addBatch("insert into student values(105,'Pal')");
		statement.addBatch("update student set stid='104' where stname='lalitha'");
		//statement.addBatch("delete from student where stid=104");
		
		int x[] = statement.executeBatch();
		
		System.out.println(x[0] + "row(s) inserted");
		System.out.println(x[1] + "row(s) updated");
		//System.out.println(x[2] + "row(s) deleted");
	}
}
