package com.itclopedia.courses.controller;

import com.itclopedia.courses.dto.ProjectDTO;
import com.itclopedia.courses.dto.TaskDTO;
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

    @PostMapping()
    public ResponseEntity<String> addProject(@RequestBody ProjectDTO projectDTO) {
        projectService.addProject(projectDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<String> updateProject(@RequestBody ProjectDTO projectDTO) {
        projectService.updateProject(projectDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable int id) {
        ProjectDTO projectDTO = projectService.getProjectById(id);
        return new ResponseEntity<>(projectDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
