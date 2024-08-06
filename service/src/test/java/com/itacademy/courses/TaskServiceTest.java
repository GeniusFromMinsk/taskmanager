package com.itacademy.courses;

import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.models.Task;
import com.itacademy.courses.models.User;
import com.itacademy.courses.services.TaskService;
import com.itacademy.courses.services.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskServiceTest {
    private static SessionFactory sessionFactory;
    private Session session;

    private static final TaskService taskService = new TaskService();
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
    public void testCreate() throws ParseException {
        System.out.println("Running testCreate...");

        Task task = new Task();
        User user = userService.getUserById(18);
        task.setUser(user);
        task.setStatus("in progress");
        task.setDescription("desc");
        task.setPriority("high");
        task.setTitle("title");
        task.setDueDate(new Date(124, Calendar.AUGUST, 23)); // Установите значение для due_date
        String dateString = "2024-08-24 14:00:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = dateFormat.parse(dateString);
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        task.setReminderTime(timestamp);
        taskService.addTask(task);
        assertEquals("in progress", task.getStatus());
    }

    @Test
    public void testUpdate() throws ParseException {
        System.out.println("Running testUpdate...");

        Task task = new Task();
        User user = userService.getUserById(1);
        task.setUser(user);
        task.setStatus("in progress");
        task.setPriority("high");
        task.setTitle("title");
        task.setDescription("desc");
        task.setDueDate(new Date(124, Calendar.AUGUST, 23)); // Установите значение для due_date
        String dateString = "2024-08-24 14:00:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = dateFormat.parse(dateString);
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        task.setReminderTime(timestamp);
        taskService.updateTask(task);

        assertEquals("in progress", task.getStatus());
    }

    @Test
    public void testGet() {
        System.out.println("Running testGet...");
        int id = 2;
        Task task = taskService.getTaskById(id);
        assertEquals("in progress", task.getStatus());
    }

    @Test
    public void testDelete() {
        System.out.println("Running testDelete...");
        int id = 24;
        taskService.deleteTask(id);
        Task deletedTask = taskService.getTaskById(id);
        Assertions.assertNull(deletedTask);
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
