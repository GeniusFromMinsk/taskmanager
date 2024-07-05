package com.itacademy.courses.dao;
import com.itacademy.courses.db.DBConnection;
import com.itacademy.courses.models.Filter;

import java.sql.*;

public class FilterDAO {
    private static final String INSERT_FILTER_SQL = "INSERT INTO Filters (filter_name, criteria) VALUES (?, ?)";
    private static final String DELETE_FILTER_SQL = "DELETE FROM Filters WHERE id = ?";
    private static final String UPDATE_FILTER_SQL = "UPDATE Filters SET filter_name = ?, criteria = ? WHERE id = ?";

    public void insertFilter(Filter filter) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FILTER_SQL)) {
            preparedStatement.setString(1, filter.getName());     // Изменено на getName() для установки имени фильтра
            preparedStatement.setString(2, filter.getCriteria()); // criteria
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public boolean deleteFilter(int filterId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_FILTER_SQL)) {
            statement.setInt(1, filterId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateFilter(Filter filter) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_FILTER_SQL)) {
            statement.setString(1, filter.getName());
            statement.setString(2, filter.getCriteria());
            statement.setInt(3, filter.getFilterId());
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
