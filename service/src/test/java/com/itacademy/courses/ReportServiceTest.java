package com.itacademy.courses;

import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.models.Report;
import com.itacademy.courses.models.User;
import com.itacademy.courses.services.ReportService;
import com.itacademy.courses.services.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportServiceTest {

    private static SessionFactory sessionFactory;
    private Session session;

    private static final ReportService reportService = new ReportService();
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

        Report report = new Report();
        User user = userService.getUserById(10);
        report.setUser(user);
        report.setContent("Content");
        reportService.addReport(report);
        assertEquals("Content", report.getContent());
    }

    @Test
    public void testUpdate() {
        System.out.println("Running testUpdate...");

        Report report = new Report();
        User user = userService.getUserById(10);
        report.setUser(user);
        report.setContent("Content");
        reportService.updateReport(report);

        assertEquals("Content", report.getContent());
    }

    @Test
    public void testGet() {
        System.out.println("Running testGet...");
        int id = 30;
        Report report = reportService.getReportById(id);
        assertEquals("report content for user 1", report.getContent());
    }

    @Test
    public void testDelete() {
        System.out.println("Running testDelete...");
        int id = 44;
        reportService.deleteReport(id);
        Report deletedReport = reportService.getReportById(id);
        Assertions.assertNull(deletedReport);
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
