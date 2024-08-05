package com.itacademy.courses.dao;

import com.itacademy.courses.db.DBConnection;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {
    private static final String INSERT_PROJECT_SQL = "INSERT INTO PROJECTS (USER_ID, NAME, DESCRIPTION) VALUES (?, ?, ?)";
    private static final String DELETE_PROJECT_SQL = "DELETE FROM PROJECTS WHERE ID = ?";
    private static final String UPDATE_PROJECT_SQL = "UPDATE PROJECTS SET NAME = ?, DESCRIPTION = ? WHERE ID = ?";

    public void insertProject(Project project) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT_SQL)) {
            preparedStatement.setInt(1, project.getUserId());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }


    public boolean deleteProject(int projectId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PROJECT_SQL)) {
            statement.setInt(1, projectId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateProject(Project project) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PROJECT_SQL)) {
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setInt(3, project.getProjectId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
