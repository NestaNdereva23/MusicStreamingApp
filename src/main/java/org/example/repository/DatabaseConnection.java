package org.example.repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DatabaseConnection {

    private String url = "jdbc:postgresql://localhost:5432/MusicStreamingApp";
    private static Connection conn;
    private String username = "postgres";
    private String password = "";


    public Connection getConnection() {
        try {
            if (conn == null) {
                //Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(url, username, password);
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database: ",e);
        }
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to close database connection: ",e);
        }
    }


}
