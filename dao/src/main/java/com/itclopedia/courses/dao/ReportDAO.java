package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.Report;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ReportDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertReport(Report report) {
        entityManager.persist(report);
    }

    public boolean deleteReport(int reportId) {
        Report report = entityManager.find(Report.class, reportId);
        if (report != null) {
            entityManager.remove(report);
            return true;
        }
        return false;
    }

    public void updateReport(Report report) {
        entityManager.merge(report);
    }

    public Report getReportById(int reportId) {
        return entityManager.find(Report.class, reportId);
    }
}
