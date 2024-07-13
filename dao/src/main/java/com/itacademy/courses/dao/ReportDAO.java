package com.itacademy.courses.dao;

import com.itacademy.courses.db.DBConnection;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.Report;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {
    private static final String INSERT_REPORT_SQL = "INSERT INTO REPORTS (USER_ID, CONTENT) VALUES (?, ?)";
    private static final String DELETE_REPORT_SQL = "DELETE FROM REPORTS WHERE ID = ?";
    private static final String UPDATE_REPORT_SQL = "UPDATE REPORTS SET CONTENT = ? WHERE ID = ?";

    public void insertReport(Report report) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REPORT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, report.getUserId());
            preparedStatement.setString(2, report.getContent());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                report.setReportId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }

    public boolean deleteReport(int reportId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_REPORT_SQL)) {
            statement.setInt(1, reportId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateReport(Report report) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_REPORT_SQL)) {
            statement.setString(1, report.getContent());
            statement.setInt(2, report.getReportId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
