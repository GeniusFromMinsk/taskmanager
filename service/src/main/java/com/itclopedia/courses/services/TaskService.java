package com.itclopedia.courses.services;

import com.itacademy.courses.dto.TaskDTO;
import com.itacademy.courses.mapper.TaskMapper;
import com.itclopedia.courses.dao.TaskRepository;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsException;
import com.itclopedia.courses.models.Task;
import com.itclopedia.courses.enums.TaskFilter;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import specification.TaskSpecifications;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper = TaskMapper.INSTANCE;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) {
        if (taskRepository.existsById(task.getId())) {
            throw new EntityAlreadyExistsException("Task", task.getId());
        }
        taskRepository.save(task);
    }

    public void updateTask(Task task) {
        if (!taskRepository.existsById(task.getId())) {
            throw new EntityNotFoundException("Task", task.getId());
        }
        taskRepository.save(task);
    }

    public Task getTaskById(int taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task", taskId));
    }

    public void deleteTask(int taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new EntityNotFoundException("Task", taskId);
        }
        taskRepository.deleteById(taskId);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<TaskDTO> getTasksByFilter(TaskFilter filter, String filterValue) {
        Specification<Task> specification = TaskSpecifications.hasField(filter.getFieldName(), filterValue);

        return taskRepository.findAll(specification).stream()
                .map(taskMapper::toTaskDTO) // Маппинг с помощью MapStruct
                .collect(Collectors.toList());
    }
}
