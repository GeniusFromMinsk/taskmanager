package com.itacademy.courses.dao;

import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.models.Category;
import com.itacademy.courses.models.Subtask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SubtaskDAO {

    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void insertSubtask(Subtask subtask) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(subtask);
            transaction.commit();
        }
    }

    public boolean deleteSubtask(int subtaskId) {
        boolean isDeleted = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Subtask subtask = session.get(Subtask.class, subtaskId);
            if (subtask != null) {
                session.remove(subtask);
                transaction.commit();
                isDeleted = true;
            }
        }
        return isDeleted;
    }


    public boolean updateSubtask(Subtask subtask) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(subtask);
            transaction.commit();
            return true;
        }
    }

    public Subtask getSubtaskById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Subtask.class, id);
        }
    }
}