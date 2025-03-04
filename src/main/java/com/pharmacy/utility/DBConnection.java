package com.pharmacy.utility;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/pharmacy";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection conn = null;

    public static Connection getConn() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL JDBC Driver
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Database connected successfully!");
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Database connection failed: " + e.getMessage());
            }
        }
        return conn;
    }
}
