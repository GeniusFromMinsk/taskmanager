package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.ProjectRepository;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsException;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
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
        if (projectRepository.existsById(project.getId())) {
            throw new EntityAlreadyExistsException("Project", project.getId());
        }
        projectRepository.save(project);
    }

    public void updateProject(Project project) {
        if (!projectRepository.existsById(project.getId())) {
            throw new EntityNotFoundException("Project", project.getId());
        }
        projectRepository.save(project);
    }

    public Project getProjectById(int id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project", id));
    }

    public void deleteProject(int id) {
        if (!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("Project", id);
        }
        projectRepository.deleteById(id);
    }
}
