package com.itacademy.courses;

import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.models.Tag;
import com.itacademy.courses.services.TagService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagServiceTest {
    private static SessionFactory sessionFactory;
    private Session session;

    private static final TagService tagService = new TagService();


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

        Tag tag = new Tag();
        tag.setName("Name");
        tagService.addTag(tag);
        assertEquals("Name", tag.getName());
    }

    @Test
    public void testUpdate() {
        System.out.println("Running testUpdate...");

        Tag tag = new Tag();
        tag.setName("Name");
        tagService.updateTag(tag);

        assertEquals("Name", tag.getName());
    }

    @Test
    public void testGet() {
        System.out.println("Running testGet...");
        int id = 13;
        Tag tag = tagService.getTagById(id);
        assertEquals("home", tag.getName());
    }

    @Test
    public void testDelete() {
        System.out.println("Running testDelete...");
        int id = 19;
        tagService.deleteTag(id);
        Tag deletedTag = tagService.getTagById(id);
        Assertions.assertNull(deletedTag);
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
