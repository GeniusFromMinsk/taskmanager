package com.itacademy.courses.dao;

import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.models.Project;
import com.itacademy.courses.models.Report;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReportDAO {
    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void insertReport(Report report) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(report);
            transaction.commit();
        }
    }

    public boolean deleteReport(int reportId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Report report = session.get(Report.class, reportId);
            if (report != null) {
                session.remove(report);
                transaction.commit();
                return true;
            }
            return false;
        }
    }

    public void updateReport(Report report) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(report);
            transaction.commit();
        }
    }
}
