package com.itacademy.courses;

import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.models.Subtask;
import com.itacademy.courses.services.SubtaskService;
import com.itacademy.courses.services.TaskService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtaskServiceTest {
    private static SessionFactory sessionFactory;
    private Session session;

    private static final SubtaskService subtaskService = new SubtaskService();
    private static final TaskService taskService = new TaskService();


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

        Subtask subtask = new Subtask();
        subtask.setTaskId(12);
        subtask.setStatus("pending");
        subtask.setTitle("Subtask 1 for Task 1");
        subtask.setDueDate(new Date(124, Calendar.AUGUST, 23));
        subtaskService.addSubtask(subtask);
        assertEquals("pending", subtask.getStatus());
    }

    @Test
    public void testUpdate() {
        System.out.println("Running testUpdate...");

        Subtask subtask = new Subtask();
        subtask.setTaskId(12);
        subtask.setStatus("pending");
        subtask.setTitle("Subtask 1 for Task 1");
        subtask.setDueDate(new Date(124, Calendar.AUGUST, 23));
        subtaskService.updateSubtask(subtask);

        assertEquals("pending", subtask.getStatus());
    }

    @Test
    public void testGet() {
        System.out.println("Running testGet...");
        int id = 24;
        Subtask subtask = subtaskService.getSubTaskById(id);
        assertEquals("pending", subtask.getStatus());
    }

    @Test
    public void testDelete() {
        System.out.println("Running testDelete...");
        int id = 34;
        subtaskService.deleteSubtask(id);
        Subtask deletedSubtask = subtaskService.getSubTaskById(id);
        Assertions.assertNull(deletedSubtask);
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
