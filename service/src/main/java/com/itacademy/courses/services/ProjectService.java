package com.itacademy.courses.services;

import com.itacademy.courses.dao.ProjectDAO;
import com.itacademy.courses.models.Project;

public class ProjectService {

    private final ProjectDAO projectDAO;

    public ProjectService() {
        this.projectDAO = new ProjectDAO();
    }

    public void addProject(Project project) {
        projectDAO.insertProject(project);
    }

    public boolean updateProject(Project project) {
        return projectDAO.updateProject(project);
    }

    public boolean deleteProject(int projectId) {
        return projectDAO.deleteProject(projectId);
    }

    public Project getProjectById(int categoryId) {
        return projectDAO.getProjectById(categoryId);
    }
}
