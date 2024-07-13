package com.itacademy.courses.dao;
import com.itacademy.courses.db.DBConnection;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.Subtask;

import java.sql.*;

public class SubtaskDAO {
    private static final String INSERT_SUBTASK_SQL = "INSERT INTO SUBTASKS (TASK_ID, TITLE, STATUS, DUE_DATE) VALUES (?, ?, ?, ?)";
    private static final String DELETE_SUBTASK_SQL = "DELETE FROM SUBTASKS WHERE ID = ?";
    private static final String UPDATE_SUBTASK_SQL = "UPDATE SUBTASKS SET TASK_ID = ?, TITLE = ?, STATUS = ?, DUE_DATE = ? WHERE ID = ?";

    public void insertSubtask(Subtask subtask) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SUBTASK_SQL)) {
            preparedStatement.setInt(1, subtask.getTaskId());
            preparedStatement.setString(2, subtask.getTitle());
            preparedStatement.setString(3, subtask.getStatus());
            preparedStatement.setDate(4, new java.sql.Date(subtask.getDueDate().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }


    public boolean deleteSubtask(int subtaskId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_SUBTASK_SQL)) {
            statement.setInt(1, subtaskId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateSubtask(Subtask subtask) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SUBTASK_SQL)) {
            statement.setInt(1, subtask.getTaskId());
            statement.setString(2, subtask.getTitle());
            statement.setString(3, subtask.getStatus());
            statement.setDate(4, new java.sql.Date(subtask.getDueDate().getTime()));
            statement.setInt(5, subtask.getSubtaskId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}