package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.ProjectRepository;
import com.itclopedia.courses.models.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void addProject(Project project) {
        projectRepository.save(project);
    }

    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    public Project getProjectById(int id) {
        return projectRepository.findById(id).orElse(null);
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }
}
