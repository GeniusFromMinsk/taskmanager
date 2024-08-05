package com.itacademy.courses.dao;

import com.itacademy.courses.db.DBConnection;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.TaskCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TaskCategoryDAO {
    private static final String INSERT_TASK_CATEGORY_SQL = "INSERT INTO TASK_CATEGORIES (TASK_ID, CATEGORY_ID) VALUES (?, ?)";

    public void insertTaskCategory(TaskCategory taskCategory) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASK_CATEGORY_SQL)) {
            preparedStatement.setInt(1, taskCategory.getTaskId());
            preparedStatement.setInt(2, taskCategory.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }
}