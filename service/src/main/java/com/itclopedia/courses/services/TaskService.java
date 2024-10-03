package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.UserRepository;
import com.itclopedia.courses.dto.TaskDTO;
import com.itclopedia.courses.mapper.TaskMapper;
import com.itclopedia.courses.dao.TaskRepository;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsException;
import com.itclopedia.courses.models.Task;
import com.itclopedia.courses.enums.TaskFilter;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
import com.itclopedia.courses.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import specification.TaskSpecifications;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper = TaskMapper.INSTANCE;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public void addTask(TaskDTO taskDTO) {
        Task task = taskMapper.toTask(taskDTO, userRepository);
        User user = userRepository.findById(taskDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User", taskDTO.getUserId()));
        task.setUser(user);

        if (taskRepository.existsById(task.getId())) {
            throw new EntityAlreadyExistsException("Task", task.getId());
        }
        taskRepository.save(task);
    }

    public void updateTask(TaskDTO taskDTO) {
        Task task = taskMapper.toTask(taskDTO, userRepository);
        User user = userRepository.findById(taskDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User", taskDTO.getUserId()));
        task.setUser(user);

        if (!taskRepository.existsById(task.getId())) {
            throw new EntityNotFoundException("Task", task.getId());
        }
        taskRepository.save(task);
    }

    public TaskDTO getTaskById(int taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task", taskId));
        return taskMapper.toTaskDTO(task);
    }
    public void deleteTask(int taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new EntityNotFoundException("Task", taskId);
        }
        taskRepository.deleteById(taskId);
    }

    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toTaskDTO)
                .collect(Collectors.toList());
    }

    public List<TaskDTO> getTasksByFilter(TaskFilter filter, String filterValue) {
        Specification<Task> specification = TaskSpecifications.hasField(filter.getFieldName(), filterValue);
        return taskRepository.findAll(specification).stream()
                .map(taskMapper::toTaskDTO)
                .collect(Collectors.toList());
    }
}
