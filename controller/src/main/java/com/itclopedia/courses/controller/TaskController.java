package com.itclopedia.courses.controller;

import com.itclopedia.courses.dto.TaskDTO;
import com.itclopedia.courses.enums.TaskFilter;
import com.itclopedia.courses.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@Tag(name = "Задачи")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Добавление задачи")
    @PostMapping
    public ResponseEntity<String> addTask(@RequestBody TaskDTO taskDTO) {
        taskService.addTask(taskDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление задачи")
    @PutMapping
    public ResponseEntity<String> updateTask(@RequestBody TaskDTO taskDTO) {
        taskService.updateTask(taskDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Получение задачи по id")
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable int id) {
        TaskDTO taskDTO = taskService.getTaskById(id);
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }

    @Operation(summary = "Получение всех задач")
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @Operation(summary = "Удаление задачи по id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Фильтр задач")
    @GetMapping("/filter")
    public ResponseEntity<List<TaskDTO>> getTasksByFilter(@RequestParam TaskFilter filter, @RequestParam String value) {
        List<TaskDTO> tasks = taskService.getTasksByFilter(filter, value);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
