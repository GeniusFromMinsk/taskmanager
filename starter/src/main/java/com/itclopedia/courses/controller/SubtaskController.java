package com.itclopedia.courses.controller;

import com.itclopedia.courses.models.Subtask;
import com.itclopedia.courses.services.SubtaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/subtasks")
public class SubtaskController {

    private final SubtaskService subtaskService;

    @Autowired
    public SubtaskController(SubtaskService subtaskService) {
        this.subtaskService = subtaskService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSubtask(@RequestBody Subtask subtask) {
        subtaskService.addSubtask(subtask);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateSubtask(@RequestBody Subtask subtask) {
        subtaskService.updateSubtask(subtask);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subtask> getSubtaskById(@PathVariable int id) {
        return new ResponseEntity<>(subtaskService.getSubtaskById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubtask(@PathVariable int id) {
        subtaskService.deleteSubtask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
