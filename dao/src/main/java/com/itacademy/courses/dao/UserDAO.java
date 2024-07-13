package com.itacademy.courses.dao;

import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.User;
import com.itacademy.courses.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String INSERT_USER_SQL = "INSERT INTO USERS (USERNAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";
    private static final String DELETE_USER_SQL = "DELETE FROM USERS WHERE ID = ?";
    private static final String UPDATE_USER_SQL = "UPDATE USERS SET USERNAME = ?, EMAIL = ?, PASSWORD = ? WHERE ID = ?";
    private static final String SELECT_USER_BY_ID = "SELECT ID, USERNAME, EMAIL, PASSWORD FROM USERS WHERE ID = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM USERS";
    private static final String CHECK_USER_EXISTS_SQL = "SELECT COUNT(*) FROM USERS WHERE EMAIL = ? OR USERNAME = ?";

    public void insertUser(User user) throws SQLException {
        String[] generatedColumns = { "id" };
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL, generatedColumns)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setUserId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            if (e.getSQLState().equals("23505")) { // Unique constraint violation
                throw new SQLException("User with this email or username already exists.", e);
            }
            throw e;
        }
    }

    public boolean deleteUser(int userId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL)) {
            statement.setInt(1, userId);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            rowDeleted = false;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getUserId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            rowUpdated = false;
        }
        return rowUpdated;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String userName = rs.getString("USERNAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                User user = new User();
                user.setUserId(id);
                user.setUsername(userName);
                user.setEmail(email);
                user.setPassword(password);
                users.add(user);
            }
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
        return users;
    }

    public User getUserById(int userId) throws SQLException {
        User user = null;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String userName = rs.getString("USERNAME");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                user = new User();
                user.setUserId(userId);
                user.setUsername(userName);
                user.setEmail(email);
                user.setPassword(password);
            }
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
        return user;
    }

    public boolean isUserExists(String email, String username) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USER_EXISTS_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
        return false;
    }
}
