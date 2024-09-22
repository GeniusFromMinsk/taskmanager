package com.itclopedia.courses.controller;

import com.itacademy.courses.dto.TaskDTO;
import com.itclopedia.courses.enums.TaskFilter;
import com.itclopedia.courses.models.Task;
import com.itclopedia.courses.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TaskDTO>> getTasksByFilter(@RequestParam TaskFilter filter, @RequestParam String value) {
        List<TaskDTO> tasks = taskService.getTasksByFilter(filter, value);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
