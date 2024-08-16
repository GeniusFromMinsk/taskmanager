package com.itacademy.courses;

import com.itacademy.courses.dao.ProjectDAO;
import com.itacademy.courses.dao.UserDAO;
import com.itacademy.courses.models.Project;
import com.itacademy.courses.models.User;
import com.itacademy.courses.services.ProjectService;
import com.itacademy.courses.services.UserService;

public class ProjectStarter {
    public static void main(String[] args) {
        ProjectDAO projectDAO = new ProjectDAO();
        ProjectService projectService = new ProjectService(projectDAO);
        UserDAO userDAO = new UserDAO();

        UserService userService = new UserService(userDAO);

        User user = userService.getUserById(41);
        if (user == null) {
            System.out.println("Пользователь с ID 1 не найден.");
            return;
        }

        Project newProject = new Project();
        newProject.setUser(user);
        newProject.setName("New Project");
        newProject.setDescription("Description of the new project");

        projectService.addProject(newProject);

        newProject.setDescription("Updated description");
        projectService.updateProject(newProject);

        int projectToDeleteId = 20;

        projectService.deleteProject(projectToDeleteId);

    }
}
