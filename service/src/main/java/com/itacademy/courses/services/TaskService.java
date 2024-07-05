package com.itacademy.courses.services;

import com.itacademy.courses.dao.TaskDAO;
import com.itacademy.courses.models.Task;

import java.sql.SQLException;
import java.util.List;

public class TaskService {
    private final TaskDAO taskDAO;

    public TaskService() {
        this.taskDAO = new TaskDAO();
    }

    public void createTask(Task task) {
        try {
            taskDAO.insertTask(task);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Task getTaskById(int taskId) {
        return taskDAO.selectTask(taskId);
    }

    public List<Task> getAllTasks() {
        return taskDAO.selectAllTasks();
    }

    public boolean updateTask(Task task) {
        try {
            return taskDAO.updateTask(task);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTask(int taskId) {
        try {
            return taskDAO.deleteTask(taskId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Task> getTasksByStatus(String status) {
        return taskDAO.selectTasksByStatus(status);
    }

    public List<Task> getTasksByPriority(String priority) {
        return taskDAO.selectTasksByPriority(priority);
    }

}
