package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.UserRepository;
import com.itclopedia.courses.dto.TaskDTO;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsException;
import com.itclopedia.courses.mapper.TaskMapper;
import com.itclopedia.courses.dao.TaskRepository;
import com.itclopedia.courses.models.Task;
import com.itclopedia.courses.enums.TaskFilter;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
import com.itclopedia.courses.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import specification.TaskSpecifications;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final TaskMapper taskMapper = TaskMapper.INSTANCE;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public void addTask(TaskDTO taskDTO) {
        User currentUser = userService.getCurrentUser();
        if (taskDTO.getUserId() != null && !taskDTO.getUserId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You cannot create a task for another user");
        }
        Task task = taskMapper.toTask(taskDTO, userRepository);
        if (taskRepository.existsById(task.getId())) {
            throw new EntityAlreadyExistsException("Task", task.getId());
        }
        task.setUser(currentUser);
        taskRepository.save(task);
    }

    public void updateTask(TaskDTO taskDTO) {
        User currentUser = userService.getCurrentUser();
        if (taskDTO.getUserId() != null && !taskDTO.getUserId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You cannot create a task for another user");
        }
        Task task = taskMapper.toTask(taskDTO, userRepository);
        if (!taskRepository.existsById(task.getId())) {
            throw new EntityNotFoundException("Task", task.getId());
        }
        task.setUser(currentUser);
        taskRepository.save(task);
    }

    public TaskDTO getTaskById(int taskId) {
        User currentUser = userService.getCurrentUser();
        Task task = taskRepository.findByIdAndUserId(taskId, currentUser.getId())
                .orElseThrow(() -> new EntityNotFoundException("Task", taskId));
        return taskMapper.toTaskDTO(task);
    }

    public void deleteTask(int taskId) {
        User currentUser = userService.getCurrentUser();
        Task task = taskRepository.findByIdAndUserId(taskId, currentUser.getId())
                .orElseThrow(() -> new EntityNotFoundException("Task", taskId));

        taskRepository.delete(task);
    }

    public List<TaskDTO> getAllTasks() {
        User currentUser = userService.getCurrentUser();

        List<Task> tasks = taskRepository.findAllByUserId(currentUser.getId());

        return tasks.stream()
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
