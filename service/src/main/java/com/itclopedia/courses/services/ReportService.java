package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.ReportDAO;
import com.itclopedia.courses.models.Report;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReportService {

    private final ReportDAO reportDAO;

    @Autowired
    public ReportService(ReportDAO reportDAO) {
        this.reportDAO = reportDAO;
    }

    public void addReport(Report report) {
        log.info("Adding report: {}", report);
        reportDAO.insertReport(report);
        log.info("Report added successfully: {}", report);
    }

    public void updateReport(Report report) {
        log.info("Updating report: {}", report);
        reportDAO.updateReport(report);
        log.info("Report updated successfully: {}", report);
    }

    public Report getReportById(int reportId) {
        log.info("Fetching report with ID: {}", reportId);
        Report report = reportDAO.getReportById(reportId);
        if (report != null) {
            log.info("Report found: {}", report);
        } else {
            log.warn("Report not found with ID: {}", reportId);
        }
        return report;
    }

    public boolean deleteReport(int reportId) {
        log.info("Deleting report with ID: {}", reportId);
        boolean isDeleted = reportDAO.deleteReport(reportId);
        if (isDeleted) {
            log.info("Report deleted successfully with ID: {}", reportId);
        } else {
            log.warn("Failed to delete report with ID: {}", reportId);
        }
        return isDeleted;
    }
}
