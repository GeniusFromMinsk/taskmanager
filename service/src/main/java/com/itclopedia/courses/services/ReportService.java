package com.itclopedia.courses.services;

import com.itclopedia.courses.models.Report;
import com.itclopedia.courses.dao.ReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void addReport(Report report) {
        reportRepository.save(report);
    }

    public void updateReport(Report report) {
        reportRepository.save(report);
    }

    public Report getReportById(int reportId) {
        return reportRepository.findById(reportId).orElse(null);
    }

    public void deleteReport(int reportId) {
        reportRepository.deleteById(reportId);
    }
}
