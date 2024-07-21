package com.itacademy.courses.services;

import com.itacademy.courses.dao.ReportDAO;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.Report;

import java.sql.SQLException;
import java.util.List;

public class ReportService {
    private ReportDAO reportDAO;

    public ReportService() {
        this.reportDAO = new ReportDAO();
    }

    public void createReport(Report report) {
        try {
            reportDAO.insertReport(report);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }


    public boolean updateReport(Report report) {
        try {
            return reportDAO.updateReport(report);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            return false;
        }
    }

    public boolean deleteReport(int reportId) {
        try {
            return reportDAO.deleteReport(reportId);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            return false;
        }
    }
}