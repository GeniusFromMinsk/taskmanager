package com.itacademy.courses.services;

import com.itacademy.courses.dao.ProjectTaskDAO;
import com.itacademy.courses.models.ProjectTask;

import java.sql.SQLException;
import java.util.List;

public class ProjectTaskService {

    private ProjectTaskDAO projectTaskDAO;

    public ProjectTaskService() {
        this.projectTaskDAO = new ProjectTaskDAO();
    }

    public void createProjectTask(ProjectTask projectTask) {
        try {
            projectTaskDAO.insertProjectTask(projectTask);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}