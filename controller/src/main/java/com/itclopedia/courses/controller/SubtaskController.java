package com.itclopedia.courses.controller;

import com.itclopedia.courses.dto.SubtaskDTO;
import com.itclopedia.courses.services.SubtaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/subtasks")
@Tag(name = "Подзадачи")
public class SubtaskController {

    private final SubtaskService subtaskService;

    @Autowired
    public SubtaskController(SubtaskService subtaskService) {
        this.subtaskService = subtaskService;
    }

    @Operation(summary = "Добавление подзадачи")
    @PostMapping
    public ResponseEntity<String> addSubtask(@RequestBody SubtaskDTO subtaskDTO) {
        subtaskService.addSubtask(subtaskDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Обновление подзадачи")
    @PutMapping
    public ResponseEntity<String> updateSubtask(@RequestBody SubtaskDTO subtaskDTO) {
        subtaskService.updateSubtask(subtaskDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Получение подзадачи по id")
    @GetMapping("/{id}")
    public ResponseEntity<SubtaskDTO> getSubtaskById(@PathVariable int id) {
        SubtaskDTO subtaskDTO = subtaskService.getSubtaskById(id);
        return new ResponseEntity<>(subtaskDTO, HttpStatus.OK);
    }

    @Operation(summary = "Удаление подзадачи")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubtask(@PathVariable int id) {
        subtaskService.deleteSubtask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
