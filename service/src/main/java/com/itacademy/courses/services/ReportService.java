package com.itacademy.courses.services;

import com.itacademy.courses.dao.ReportDAO;
import com.itacademy.courses.dao.UserDAO;
import com.itacademy.courses.models.Report;

public class ReportService {
    private final ReportDAO reportDAO = new ReportDAO();
    private final UserDAO userDAO = new UserDAO();

    public void addReport(Report report) {
        reportDAO.insertReport(report);
    }

    public void updateReport(Report report) {
        reportDAO.updateReport(report);
    }

    public Report getReportById(int reportId) {
        return reportDAO.getReportById(reportId);
    }

    public boolean deleteReport(int reportId) {
        return reportDAO.deleteReport(reportId);
    }
}