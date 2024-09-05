package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.ProjectDAO;
import com.itclopedia.courses.models.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProjectService {

    private final ProjectDAO projectDAO;

    @Autowired
    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public void addProject(Project project) {
        log.info("Adding project: {}", project);
        projectDAO.insertProject(project);
        log.info("Project added successfully: {}", project);
    }

    public void updateProject(Project project) {
        log.info("Updating project: {}", project);
        projectDAO.updateProject(project);
        log.info("Project updated successfully: {}", project);
    }

    public Project getProjectById(int id) {
        log.info("Fetching project with ID: {}", id);
        Project project = projectDAO.getProjectById(id);
        if (project != null) {
            log.info("Project found: {}", project);
        } else {
            log.warn("Project not found with ID: {}", id);
        }
        return project;
    }

    public void deleteProject(int id) {
        log.info("Deleting project with ID: {}", id);
        projectDAO.deleteProject(id);
        log.info("Project deleted successfully with ID: {}", id);
    }
}
