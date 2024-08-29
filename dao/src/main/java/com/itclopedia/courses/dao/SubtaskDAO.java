package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.Subtask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubtaskDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public SubtaskDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
