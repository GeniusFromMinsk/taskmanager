package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.ReportRepository;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsException;
import com.itclopedia.courses.models.Report;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
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
        if (reportRepository.existsById(report.getId())) {
            throw new EntityAlreadyExistsException("Report", report.getId());
        }
        reportRepository.save(report);
    }

    public void updateReport(Report report) {
        if (!reportRepository.existsById(report.getId())) {
            throw new EntityNotFoundException("Report", report.getId());
        }
        reportRepository.save(report);
    }

    public Report getReportById(int reportId) {
        return reportRepository.findById(reportId)
                .orElseThrow(() -> new EntityNotFoundException("Report", reportId));
    }

    public void deleteReport(int reportId) {
        if (!reportRepository.existsById(reportId)) {
            throw new EntityNotFoundException("Report", reportId);
        }
        reportRepository.deleteById(reportId);
    }
}
