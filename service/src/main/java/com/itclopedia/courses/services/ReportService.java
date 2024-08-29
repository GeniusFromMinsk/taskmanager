package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.ReportDAO;
import com.itclopedia.courses.models.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final ReportDAO reportDAO;

    @Autowired
    public ReportService(ReportDAO reportDAO) {
        this.reportDAO = reportDAO;
    }

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
