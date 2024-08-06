package com.itacademy.courses;

import com.itacademy.courses.models.Project;
import com.itacademy.courses.models.User;
import com.itacademy.courses.services.ProjectService;
import com.itacademy.courses.services.UserService;

public class ProjectStarter {
    public static void main(String[] args) {
        ProjectService projectService = new ProjectService();
        UserService userService = new UserService();

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

        boolean isDeleted = projectService.deleteProject(projectToDeleteId);
        if (isDeleted) {
            System.out.println("Категория с ID " + projectToDeleteId + " успешно удалена.");
        } else {
            System.out.println("Категория с ID " + projectToDeleteId + " не найдена.");
        }
    }
}
