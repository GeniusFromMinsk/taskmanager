package com.itacademy.courses.dao;
import com.itacademy.courses.db.DBConnection;
import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.Subtask;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.*;

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
        boolean isUpdated = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Subtask existingSubtask = session.get(Subtask.class, subtask.getSubtaskId());
            if (existingSubtask != null) {
                existingSubtask.setTaskId(subtask.getTaskId());
                existingSubtask.setTitle(subtask.getTitle());
                existingSubtask.setStatus(subtask.getStatus());
                existingSubtask.setDueDate(subtask.getDueDate());
                session.merge(existingSubtask);
                transaction.commit();
                isUpdated = true;
            }
        }
        return isUpdated;
    }
}