package com.itacademy.courses.dao;

import com.itacademy.courses.db.DBConnection;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.ProjectTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProjectTaskDAO {
    private static final String INSERT_PROJECT_TASK_SQL = "INSERT INTO PROJECT_TASKS (ID, TASK_ID) VALUES (?, ?)";

    public void insertProjectTask(ProjectTask projectTask) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT_TASK_SQL)) {
            preparedStatement.setInt(1, projectTask.getProjectId());
            preparedStatement.setInt(2, projectTask.getTaskId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }
}
