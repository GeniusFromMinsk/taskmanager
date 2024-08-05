package com.itacademy.courses.dao;

import com.itacademy.courses.db.DBConnection;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagDAO {
    private static final String INSERT_TAG_SQL = "INSERT INTO TAGS (NAME) VALUES (?)";
    private static final String DELETE_TAG_SQL = "DELETE FROM TAGS WHERE ID = ?";
    private static final String UPDATE_TAG_SQL = "UPDATE TAGS SET NAME = ? WHERE ID = ?";

    public void insertTag(Tag tag) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TAG_SQL)) {
            preparedStatement.setString(1, tag.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }


    public boolean deleteTag(int tagId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TAG_SQL)) {
            statement.setInt(1, tagId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateTag(Tag tag) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TAG_SQL)) {
            statement.setString(1, tag.getName());
            statement.setInt(2, tag.getTagId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
