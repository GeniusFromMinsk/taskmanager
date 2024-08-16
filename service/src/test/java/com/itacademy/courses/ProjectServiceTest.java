package com.itacademy.courses;

import com.itacademy.courses.dao.ProjectDAO;
import com.itacademy.courses.models.Project;
import com.itacademy.courses.models.User;
import com.itacademy.courses.services.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class ProjectServiceTest {

    private ProjectDAO projectDAO;
    private ProjectService projectService;

    @BeforeEach
    public void setup() {
        projectDAO = Mockito.mock(ProjectDAO.class);
        projectService = new ProjectService(projectDAO);
    }

    @Test
    public void testCreate() {
        Project project = new Project();
        User user = new User();
        user.setUserId(10);
        project.setUser(user);
        project.setName("Name");
        project.setDescription("Desc");

        doNothing().when(projectDAO).insertProject(project);

        projectService.addProject(project);

        verify(projectDAO, times(1)).insertProject(project);
    }

    @Test
    public void testUpdate() {
        Project project = new Project();
        User user = new User();
        user.setUserId(10);
        project.setName("Namee");
        project.setDescription("Descc");

        doNothing().when(projectDAO).updateProject(project);

        projectService.updateProject(project);

        verify(projectDAO, times(1)).updateProject(project);
    }

    @Test
    public void testGet() {
        int id = 30;
        Project project = new Project();
        project.setName("Проект A");

        when(projectDAO.getProjectById(id)).thenReturn(project);

        Project retrievedProject = projectService.getProjectById(id);
        assertEquals("Проект A", retrievedProject.getName());
    }

    @Test
    public void testDelete() {
        int id = 46;

        doNothing().when(projectDAO).deleteProject(id);
        when(projectDAO.getProjectById(id)).thenReturn(null);

        projectService.deleteProject(id);

        verify(projectDAO, times(1)).deleteProject(id);
        Project deletedProject = projectService.getProjectById(id);
        assertNull(deletedProject);
    }
}