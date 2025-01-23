package com.ASS2;

import java.sql.*;

public class sql1 {

    public static void main(String[] args) {
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "//password of your sql workbench");

            // Create a statement object
            Statement stmt = con.createStatement();

            // Create the database (uncomment the desired line)
            String sql = "CREATE DATABASE student3";
            // String sql = "DROP DATABASE student3"; 

            // Execute the SQL query
            stmt.executeUpdate(sql);

            System.out.println("Database operation successful.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
