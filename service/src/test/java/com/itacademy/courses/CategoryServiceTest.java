package com.itacademy.courses;

import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.models.Category;
import com.itacademy.courses.services.CategoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryServiceTest {

    private static SessionFactory sessionFactory;
    private Session session;

    private static final CategoryService categoryService = new CategoryService();

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

        Category category = new Category();
        category.setName("Name");
        category.setDescription("Desc");
        categoryService.addCategory(category);
        assertEquals("Name", category.getName());
    }

    @Test
    public void testUpdate() {
        System.out.println("Running testUpdate...");

        Category category = new Category();
        category.setName("Personal");
        category.setDescription("Desc");
        categoryService.updateCategory(category);

        assertEquals("Personal", category.getName());
    }

    @Test
    public void testGet() {
        System.out.println("Running testGet...");
        int id = 36;
        Category category = categoryService.getCategoryById(id);
        assertEquals("New Category", category.getName());
    }

    @Test
    public void testDelete() {
        System.out.println("Running testDelete...");
        int id = 46;
        categoryService.deleteCategory(id);
        Category deletedCategory = categoryService.getCategoryById(id);
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
