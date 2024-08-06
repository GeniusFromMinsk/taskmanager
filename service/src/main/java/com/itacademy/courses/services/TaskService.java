package com.itacademy.courses.services;

import com.itacademy.courses.dao.TaskDAO;
import com.itacademy.courses.enums.TaskFilter;
import com.itacademy.courses.models.Task;

import java.util.List;

public class TaskService {

    private final TaskDAO taskDAO;

    public TaskService() {
        this.taskDAO = new TaskDAO();
    }

    public void addTask(Task task) {
        taskDAO.insertTask(task);
    }

    public Task getTaskById(int taskId) {
        return taskDAO.selectTask(taskId);
    }

    public List<Task> getAllTasks() {
        return taskDAO.selectAllTasks();
    }

    public boolean deleteTask(int taskId) {
        return taskDAO.deleteTask(taskId);
    }

    public boolean updateTask(Task task) {
        return taskDAO.updateTask(task);
    }

    public List<Task> getTasksByFilter(TaskFilter filter, String filterValue) {
        return taskDAO.selectTasksByFilter(filter, filterValue);
    }
}
