package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.TaskDAO;
import com.itclopedia.courses.enums.TaskFilter;
import com.itclopedia.courses.models.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaskService {

    private final TaskDAO taskDAO;

    @Autowired
    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public void addTask(Task task) {
        log.info("Adding task: {}", task);
        taskDAO.insertTask(task);
        log.info("Task added successfully: {}", task);
    }

    public Task getTaskById(int taskId) {
        log.info("Fetching task with ID: {}", taskId);
        Task task = taskDAO.selectTask(taskId);
        if (task != null) {
            log.info("Task found: {}", task);
        } else {
            log.warn("Task not found with ID: {}", taskId);
        }
        return task;
    }

    public List<Task> getAllTasks() {
        log.info("Fetching all tasks");
        List<Task> tasks = taskDAO.selectAllTasks();
        log.info("Retrieved {} tasks", tasks.size());
        return tasks;
    }

    public boolean deleteTask(int taskId) {
        log.info("Deleting task with ID: {}", taskId);
        boolean isDeleted = taskDAO.deleteTask(taskId);
        if (isDeleted) {
            log.info("Task deleted successfully with ID: {}", taskId);
        } else {
            log.warn("Failed to delete task with ID: {}", taskId);
        }
        return isDeleted;
    }

    public boolean updateTask(Task task) {
        log.info("Updating task: {}", task);
        boolean isUpdated = taskDAO.updateTask(task);
        if (isUpdated) {
            log.info("Task updated successfully: {}", task);
        } else {
            log.warn("Failed to update task: {}", task);
        }
        return isUpdated;
    }

    public List<Task> getTasksByFilter(TaskFilter filter, String filterValue) {
        log.info("Fetching tasks with filter: {} and value: {}", filter, filterValue);
        List<Task> tasks = taskDAO.selectTasksByFilter(filter, filterValue);
        log.info("Retrieved {} tasks for filter {} with value {}", tasks.size(), filter, filterValue);
        return tasks;
    }
}
