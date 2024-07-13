package com.itacademy.courses.dao;

import com.itacademy.courses.db.DBConnection;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    private static final String SELECT_TASKS_BY_STATUS_SQL = "SELECT * FROM TASKS WHERE STATUS = ?";
    private static final String SELECT_TASKS_BY_PRIORITY_SQL = "SELECT * FROM TASKS WHERE PRIORITY = ?";
    private static final String INSERT_TASK_SQL = "INSERT INTO TASKS (USER_ID, TITLE, DESCRIPTION, STATUS, PRIORITY, DUE_DATE, REMINDER_TIME) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_TASK_BY_ID = "SELECT * FROM TASKS WHERE ID = ?";
    private static final String SELECT_ALL_TASKS = "SELECT * FROM TASKS";
    private static final String DELETE_TASK_SQL = "DELETE FROM TASKS WHERE ID = ?";
    private static final String UPDATE_TASK_SQL = "UPDATE TASKS SET USER_ID = ?, TITLE = ?, DESCRIPTION = ?, STATUS = ?, PRIORITY = ?, DUE_DATE = ?, REMINDER_TIME = ? WHERE ID = ?";

    public void insertTask(Task task) throws SQLException {
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASK_SQL)) {
            preparedStatement.setInt(1, task.getUserId());
            preparedStatement.setString(2, task.getTitle());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setString(4, task.getStatus());
            preparedStatement.setString(5, task.getPriority());
            preparedStatement.setDate(6, new java.sql.Date(task.getDueDate().getTime()));
            preparedStatement.setTimestamp(7, task.getReminderTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }

    public Task selectTask(int taskId) {
        Task task = null;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASK_BY_ID)) {
            preparedStatement.setInt(1, taskId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String priority = rs.getString("priority");
                Date dueDate = rs.getDate("due_date");
                task = new Task();
                task.setTaskId(taskId);
                task.setUserId(userId);
                task.setTitle(title);
                task.setDescription(description);
                task.setStatus(status);
                task.setPriority(priority);
                task.setDueDate(dueDate);
            }
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
        return task;
    }

    public List<Task> selectAllTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TASKS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int taskId = rs.getInt("id");
                int userId = rs.getInt("user_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String priority = rs.getString("priority");
                Date dueDate = rs.getDate("due_date");
                Task task = new Task();
                task.setTaskId(taskId);
                task.setUserId(userId);
                task.setTitle(title);
                task.setDescription(description);
                task.setStatus(status);
                task.setPriority(priority);
                task.setDueDate(dueDate);
                tasks.add(task);
            }
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
        return tasks;
    }

    public boolean deleteTask(int taskId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TASK_SQL)) {
            statement.setInt(1, taskId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateTask(Task task) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TASK_SQL)) {
            statement.setInt(1, task.getUserId());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getStatus());
            statement.setString(5, task.getPriority());
            statement.setDate(6, new java.sql.Date(task.getDueDate().getTime()));
            statement.setTimestamp(7, task.getReminderTime());
            statement.setInt(8, task.getTaskId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public List<Task> selectTasksByStatus(String status) {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASKS_BY_STATUS_SQL)) {
            preparedStatement.setString(1, status);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Task task = extractTaskFromResultSet(rs);
                tasks.add(task);
            }
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
        return tasks;
    }

    public List<Task> selectTasksByPriority(String priority) {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASKS_BY_PRIORITY_SQL)) {
            preparedStatement.setString(1, priority);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Task task = extractTaskFromResultSet(rs);
                tasks.add(task);
            }
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
        return tasks;
    }

    private Task extractTaskFromResultSet(ResultSet rs) throws SQLException {
        Task task = new Task();
        task.setTaskId(rs.getInt("id"));
        task.setUserId(rs.getInt("user_id"));
        task.setTitle(rs.getString("title"));
        task.setDescription(rs.getString("description"));
        task.setStatus(rs.getString("status"));
        task.setPriority(rs.getString("priority"));
        task.setDueDate(rs.getDate("due_date"));
        return task;
    }
}
