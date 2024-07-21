package com.itacademy.courses.services;
import com.itacademy.courses.dao.ProjectDAO;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.Project;

import java.sql.SQLException;
import java.util.List;

public class ProjectService {

    private ProjectDAO projectDAO;

    public ProjectService() {
        this.projectDAO = new ProjectDAO();
    }

    public void createProject(Project project) {
        try {
            projectDAO.insertProject(project);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }

    public boolean updateProject(Project project) {
        try {
            return projectDAO.updateProject(project);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            return false;
        }
    }

    public boolean deleteProject(int projectId) {
        try {
            return projectDAO.deleteProject(projectId);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            return false;
        }
    }
}
