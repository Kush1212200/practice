package com.hexaware.jdbc;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Properties;
	import java.util.Scanner;

	public class Test7 {

		public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
			
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\chatu\\eclipse-workspace\\javapractice\\practicejavahexaware\\src\\com\\hexaware\\jdbc\\db.properties");
			properties.load(fis);
			
			String url = properties.getProperty("jdbc.url");
			String username = properties.getProperty("jdbc.username");
			String password = properties.getProperty("jdbc.password");
			String driver = properties.getProperty("jdbc.driver");
			
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = connection.prepareStatement("insert into student values(?,?)");
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter student id:");
			int stid = scanner.nextInt();
			System.out.println("enter student name:");
			String stname=scanner.next();
			ps.setInt(1, stid);
			ps.setString(2, stname);
			int x = ps.executeUpdate();
			System.out.println(x + "row(s) inserted");
			connection.close();
		}
}
