package com.itacademy.courses.dao;

import com.itacademy.courses.db.DBConnection;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.TaskTag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TaskTagDAO {
    private static final String INSERT_TASK_TAG_SQL = "INSERT INTO TASK_TAGS (TASK_ID, TAG_ID) VALUES (?, ?)";
    public void insertTaskTag(TaskTag taskTag) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASK_TAG_SQL)) {
            preparedStatement.setInt(1, taskTag.getTaskId());
            preparedStatement.setInt(2, taskTag.getTagId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }
}