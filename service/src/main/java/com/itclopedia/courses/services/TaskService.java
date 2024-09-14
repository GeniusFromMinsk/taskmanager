package com.itclopedia.courses.services;

import com.itclopedia.courses.enums.TaskFilter;
import com.itclopedia.courses.models.Task;
import com.itclopedia.courses.dao.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import specification.TaskSpecifications;

import java.util.List;

@Slf4j
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public Task getTaskById(int taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getTasksByFilter(TaskFilter filter, String filterValue) {
        Specification<Task> specification = TaskSpecifications.hasField(filter.getQuery(), filterValue);
        return taskRepository.findAll(specification);
    }
}
