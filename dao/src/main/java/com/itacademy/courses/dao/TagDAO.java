package com.itacademy.courses.dao;

import com.itacademy.courses.db.DBConnection;
import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TagDAO {

    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void insertTag(Tag tag) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(tag);
            transaction.commit();
        }
    }

    public boolean deleteTag(int tagId) {
        boolean isDeleted = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Tag tag = session.get(Tag.class, tagId);
            if (tag != null) {
                session.remove(tag);
                transaction.commit();
                isDeleted = true;
            }
        }
        return isDeleted;
    }

    public boolean updateTag(Tag tag) {
        boolean isUpdated = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Tag existingTag = session.get(Tag.class, tag.getTagId());
            if (existingTag != null) {
                existingTag.setName(tag.getName());
                session.merge(existingTag);
                transaction.commit();
                isUpdated = true;
            }
        }
        return isUpdated;
    }
}
