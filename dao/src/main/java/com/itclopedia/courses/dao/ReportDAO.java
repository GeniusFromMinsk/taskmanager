package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.Report;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public ReportDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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

    public Report getReportById(int reportId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Report.class, reportId);
        }
    }
}
