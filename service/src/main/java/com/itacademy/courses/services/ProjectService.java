package com.itacademy.courses.services;

import com.itacademy.courses.dao.ProjectDAO;
import com.itacademy.courses.models.Project;

public class ProjectService {

    private final ProjectDAO projectDAO;

    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public void addProject(Project project) {
        projectDAO.insertProject(project);
    }

    public void updateProject(Project project) {
        projectDAO.updateProject(project);
    }

    public Project getProjectById(int id) {
        return projectDAO.getProjectById(id);
    }

    public void deleteProject(int id) {
        projectDAO.deleteProject(id);
    }
}
