package com.itclopedia.courses;

import com.itclopedia.courses.models.Project;
import com.itclopedia.courses.models.User;
import com.itclopedia.courses.dao.ProjectRepository;
import com.itclopedia.courses.services.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class ProjectServiceTest {

  /*  private ProjectRepository projectRepository;
    private ProjectService projectService;

    @BeforeEach
    public void setup() {
        projectRepository = Mockito.mock(ProjectRepository.class);
        projectService = new ProjectService(projectRepository);
    }

    @Test
    public void testCreate() {
        Project project = new Project();
        User user = new User();
        user.setId(10);
        project.setUser(user);
        project.setName("Name");
        project.setDescription("Desc");

        when(projectRepository.save(project)).thenReturn(project);

        projectService.addProject(project);

        verify(projectRepository, times(1)).save(project);
    }

    @Test
    public void testUpdate() {
        Project project = new Project();
        User user = new User();
        user.setId(10);
        project.setName("Namee");
        project.setDescription("Descc");

        when(projectRepository.save(project)).thenReturn(project);

        projectService.updateProject(project);

        verify(projectRepository, times(1)).save(project);
    }

    @Test
    public void testGet() {
        int id = 30;
        Project project = new Project();
        project.setName("Проект A");

        when(projectRepository.findById(id)).thenReturn(Optional.of(project));

        Project retrievedProject = projectService.getProjectById(id);
        assertEquals("Проект A", retrievedProject.getName());
    }

    @Test
    public void testDelete() {
        int id = 46;

        doNothing().when(projectRepository).deleteById(id);

        projectService.deleteProject(id);

        verify(projectRepository, times(1)).deleteById(id);
        when(projectRepository.findById(id)).thenReturn(Optional.empty());
        Project deletedProject = projectService.getProjectById(id);
        assertNull(deletedProject);
    }

   */
}
