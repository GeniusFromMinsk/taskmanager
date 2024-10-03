package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.ReportRepository;
import com.itclopedia.courses.dao.UserRepository;
import com.itclopedia.courses.dto.ReportDTO;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsException;
import com.itclopedia.courses.mapper.ReportMapper;
import com.itclopedia.courses.models.Report;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
import com.itclopedia.courses.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReportService {

    private final ReportRepository reportRepository;

    private final UserRepository userRepository;
    private final ReportMapper reportMapper = ReportMapper.INSTANCE;
    @Autowired
    public ReportService(ReportRepository reportRepository, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
    }

    public void addReport(ReportDTO reportDTO) {
        Report report = reportMapper.toReport(reportDTO, userRepository);
        User user = userRepository.findById(reportDTO.getUserId())
                .orElseThrow(() -> new EntityAlreadyExistsException("User", report.getId()));
        report.setUser(user);
        reportRepository.save(report);
    }

    public void updateReport(ReportDTO reportDTO) {
        Report report = reportMapper.toReport(reportDTO, userRepository);
        User user = userRepository.findById(reportDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User", report.getId()));
        report.setUser(user);
        reportRepository.save(report);
    }


    public ReportDTO getReportById(int reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new EntityNotFoundException("Report", reportId));
        return reportMapper.toReportDTO(report);
    }

    public void deleteReport(int reportId) {
        if (!reportRepository.existsById(reportId)) {
            throw new EntityNotFoundException("Report", reportId);
        }
        reportRepository.deleteById(reportId);
    }
}
