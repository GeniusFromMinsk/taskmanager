package com.itclopedia.courses;

import com.itclopedia.courses.dao.ReportDAO;
import com.itclopedia.courses.dao.UserDAO;
import com.itclopedia.courses.models.Report;
import com.itclopedia.courses.models.User;
import com.itclopedia.courses.services.ReportService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class ReportServiceTest {

    private ReportDAO reportDAO;
    private UserDAO userDAO;
    private ReportService reportService;

    @BeforeEach
    public void setup() {
        reportDAO = Mockito.mock(ReportDAO.class);
        userDAO = Mockito.mock(UserDAO.class);
        reportService = new ReportService(reportDAO);
    }

    @Test
    public void testCreate() {
        Report report = new Report();
        User user = new User();
        user.setId(10);
        when(userDAO.getUserById(10)).thenReturn(user);

        report.setUser(user);
        report.setContent("Content");

        reportService.addReport(report);

        verify(reportDAO, times(1)).insertReport(report);
        assertEquals("Content", report.getContent());
    }

    @Test
    public void testUpdate() {
        Report report = new Report();
        report.setContent("Updated Content");

        reportService.updateReport(report);

        verify(reportDAO, times(1)).updateReport(report);
    }

    @Test
    public void testGet() {
        Report report = new Report();
        report.setContent("report content for user 1");

        when(reportDAO.getReportById(30)).thenReturn(report);

        Report retrievedReport = reportService.getReportById(30);
        assertEquals("report content for user 1", retrievedReport.getContent());
    }

    @Test
    public void testDelete() {
        int id = 44;

        when(reportDAO.getReportById(id)).thenReturn(null);
        reportService.deleteReport(id);

        verify(reportDAO, times(1)).deleteReport(id);
        assertNull(reportService.getReportById(id));
    }
}
