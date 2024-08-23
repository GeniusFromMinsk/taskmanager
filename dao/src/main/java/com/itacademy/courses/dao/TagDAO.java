package com.itacademy.courses.dao;

import com.itacademy.courses.models.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TagDAO {


    private final SessionFactory sessionFactory;

    @Autowired
    public TagDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void insertTag(Tag tag) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(tag);
            transaction.commit();
        }
    }

    public void deleteTag(int tagId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Tag tag = session.get(Tag.class, tagId);
            session.remove(tag);
            transaction.commit();
        }
    }

    public void updateTag(Tag tag) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(tag);
            transaction.commit();
        }
    }

    public Tag getTagById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Tag.class, id);
        }
    }
}
