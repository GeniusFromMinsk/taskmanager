package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.TaskDAO;
import com.itclopedia.courses.enums.TaskFilter;
import com.itclopedia.courses.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskDAO taskDAO;
    @Autowired
    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
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
