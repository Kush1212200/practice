package com.hexaware.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test2 {

    public void insertEmployee(Connection conn) throws SQLException {
        String sql = "INSERT into employees Values(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 123);
        ps.setString(2, "Ram");
        ps.setString(3, "Kumar");
        ps.setString(4, "rk785667@outlook.com");
        ps.setDate(5, java.sql.Date.valueOf("2024-10-03"));

        int x = ps.executeUpdate();
        System.out.println(x + " row(s) affected");

        conn.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Actual connection and execution logic, this won't be part of the test
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hexaware", "root", ".Kush123");
        new Test2().insertEmployee(conn);
    }
}
