package com.itclopedia.courses;

import com.itclopedia.courses.models.Report;
import com.itclopedia.courses.models.User;
import com.itclopedia.courses.dao.ReportRepository;
import com.itclopedia.courses.services.ReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class ReportServiceTest {

    private ReportRepository reportRepository;
    private ReportService reportService;

    @BeforeEach
    public void setup() {
        reportRepository = Mockito.mock(ReportRepository.class);
        reportService = new ReportService(reportRepository);
    }

    @Test
    public void testCreate() {
        Report report = new Report();
        User user = new User();
        user.setId(10);
        report.setUser(user);
        report.setContent("Content");

        when(reportRepository.save(report)).thenReturn(report);

        reportService.addReport(report);

        verify(reportRepository, times(1)).save(report);
        assertEquals("Content", report.getContent());
    }

    @Test
    public void testUpdate() {
        Report report = new Report();
        report.setContent("Updated Content");

        when(reportRepository.save(report)).thenReturn(report);

        reportService.updateReport(report);

        verify(reportRepository, times(1)).save(report);
    }

    @Test
    public void testGet() {
        Report report = new Report();
        report.setContent("report content for user 1");

        when(reportRepository.findById(30)).thenReturn(Optional.of(report));

        Report retrievedReport = reportService.getReportById(30);
        assertEquals("report content for user 1", retrievedReport.getContent());
    }

    @Test
    public void testDelete() {
        int id = 44;

        when(reportRepository.existsById(id)).thenReturn(true);
        doNothing().when(reportRepository).deleteById(id);

        reportService.deleteReport(id);

        verify(reportRepository, times(1)).deleteById(id);
        when(reportRepository.findById(id)).thenReturn(Optional.empty());
        Report deletedReport = reportService.getReportById(id);
        assertNull(deletedReport);
    }
}
