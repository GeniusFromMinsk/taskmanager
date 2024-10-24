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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final ReportMapper reportMapper = ReportMapper.INSTANCE;
    @Autowired
    public ReportService(ReportRepository reportRepository, UserService userService, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public void addReport(ReportDTO reportDTO) {
        User currentUser = userService.getCurrentUser();
        if (reportDTO.getUserId() != null && !reportDTO.getUserId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You cannot create a report for another user");
        }
        Report report = reportMapper.toReport(reportDTO, userRepository);
        if (reportRepository.existsById(report.getId())) {
            throw new EntityAlreadyExistsException("Report", report.getId());
        }
        report.setUser(currentUser);
        reportRepository.save(report);
    }

    public void updateReport(ReportDTO reportDTO) {
        User currentUser = userService.getCurrentUser();
        if (reportDTO.getUserId() != null && !reportDTO.getUserId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You cannot create a report for another user");
        }
        Report report = reportMapper.toReport(reportDTO, userRepository);
        if (reportRepository.existsById(report.getId())) {
            throw new EntityNotFoundException("Report", report.getId());
        }
        report.setUser(currentUser);
        reportRepository.save(report);
    }


    public ReportDTO getReportById(int reportId) {
        User currentUser = userService.getCurrentUser();
        Report report = reportRepository.findByIdAndUserId(reportId, currentUser.getId())
                .orElseThrow(() -> new EntityNotFoundException("Report", reportId));

        return reportMapper.toReportDTO(report);
    }

    public void deleteReport(int reportId) {
        User currentUser = userService.getCurrentUser();
        Report report = reportRepository.findByIdAndUserId(reportId, currentUser.getId())
                .orElseThrow(() -> new EntityNotFoundException("Report", reportId));

        reportRepository.delete(report);
    }
}
