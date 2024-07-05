package com.itacademy.courses.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/manager";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "1111";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}
