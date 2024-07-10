package com.codtech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    // JDBC URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/codtech_crm";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "chandu@93467";

    // Method to establish a database connection
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error: Failed to connect to database.");
            e.printStackTrace();
            // Optionally handle the exception further or throw a runtime exception
        }
        return connection;
    }

    // Method to close a database connection
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error: Failed to close database connection.");
                e.printStackTrace();
                // Optionally handle the exception further or throw a runtime exception
            }
        }
    }
}
