package com.itacademy.courses.dao;

import com.itacademy.courses.db.DBConnection;
import com.itacademy.courses.models.Report;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {
    private static final String INSERT_REPORT_SQL = "INSERT INTO Reports (user_id, content) VALUES (?, ?)";
    private static final String DELETE_REPORT_SQL = "DELETE FROM Reports WHERE id = ?";
    private static final String UPDATE_REPORT_SQL = "UPDATE Reports SET content = ? WHERE id = ?";

    public void insertReport(Report report) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REPORT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, report.getUserId());
            preparedStatement.setString(2, report.getContent());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                report.setReportId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public boolean deleteReport(int reportId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_REPORT_SQL)) {
            statement.setInt(1, reportId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateReport(Report report) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_REPORT_SQL)) {
            statement.setString(1, report.getContent());
            statement.setInt(2, report.getReportId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
