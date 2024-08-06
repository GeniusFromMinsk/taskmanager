package com.itacademy.courses;

import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.models.Project;
import com.itacademy.courses.models.User;
import com.itacademy.courses.services.ProjectService;
import com.itacademy.courses.services.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectServiceTest {
    private static SessionFactory sessionFactory;
    private Session session;

    private static final ProjectService projectService = new ProjectService();
    private static final UserService userService = new UserService();


    @BeforeAll
    public static void setup() {
        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        System.out.println("SessionFactory created");
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }

    @Test
    public void testCreate() {
        System.out.println("Running testCreate...");

        Project project = new Project();
        User user = userService.getUserById(10);
        project.setUser(user);
        project.setName("Name");
        project.setDescription("Desc");
        projectService.addProject(project);
        assertEquals("Name", project.getName());
    }

    @Test
    public void testUpdate() {
        System.out.println("Running testUpdate...");

        Project project = new Project();
        User user = userService.getUserById(10);
        project.setUser(user);
        project.setName("Name");
        project.setDescription("Desc");
        projectService.updateProject(project);

        assertEquals("Name", project.getName());
    }

    @Test
    public void testGet() {
        System.out.println("Running testGet...");
        int id = 30;
        Project project = projectService.getProjectById(id);
        assertEquals("Проект A", project.getName());
    }

    @Test
    public void testDelete() {
        System.out.println("Running testDelete...");
        int id = 46;
        projectService.deleteProject(id);
        Project deletedCategory = projectService.getProjectById(id);
        Assertions.assertNull(deletedCategory);
    }

    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
        System.out.println("Session created");
    }

    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }
}
