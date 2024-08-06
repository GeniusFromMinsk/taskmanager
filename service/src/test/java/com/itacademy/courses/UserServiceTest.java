package com.itacademy.courses;

import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.models.User;
import com.itacademy.courses.services.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {
    private static SessionFactory sessionFactory;
    private Session session;

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
    public void testCreate(){
        System.out.println("Running testCreate...");

        User user = new User();
        user.setPassword("1213");
        user.setUserName("Kirill");
        user.setEmail("john.doe@example.com");
        userService.addUser(user);
        assertEquals("Kirill", user.getUserName());
    }

    @Test
    public void testUpdate() throws ParseException {
        System.out.println("Running testUpdate...");

        User user = new User();
        user.setPassword("1213");
        user.setUserName("Kirill");
        user.setEmail("john.doe@example.com");
        userService.updateUser(user);

        assertEquals("Kirill", user.getUsername());
    }

    @Test
    public void testGet() {
        System.out.println("Running testGet...");
        int id = 3;
        User user = userService.getUserById(id);
        assertEquals("john_doe", user.getUsername());
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
