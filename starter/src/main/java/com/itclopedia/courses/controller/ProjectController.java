package com.itclopedia.courses.controller;

import com.itclopedia.courses.models.Project;
import com.itclopedia.courses.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProject(@RequestBody Project project) {
        projectService.addProject(project);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProject(@RequestBody Project project) {
        projectService.updateProject(project);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProjectById(@PathVariable int id) {
        return new ResponseEntity<>(projectService.getProjectById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
