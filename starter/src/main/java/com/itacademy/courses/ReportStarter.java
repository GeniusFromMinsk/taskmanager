package com.itacademy.courses;

import com.itacademy.courses.dao.ReportDAO;
import com.itacademy.courses.dao.UserDAO;
import com.itacademy.courses.models.Report;
import com.itacademy.courses.models.User;
import com.itacademy.courses.services.ReportService;
import com.itacademy.courses.services.UserService;

public class ReportStarter {
    public static void main(String[] args) {
        ReportDAO reportDAO = new ReportDAO();
        UserDAO userDAO = new UserDAO();
        ReportService reportService = new ReportService(reportDAO);
        UserService userService = new UserService(userDAO);

        User user = userService.getUserById(36);
        if (user == null) {
            System.out.println("Пользователь с ID 36 не найден.");
            return;
        }

        Report newReport = new Report();
        newReport.setUser(user);
        newReport.setContent("Description of the new report");
        reportService.addReport(newReport);


        newReport.setContent("Updated description");
        reportService.updateReport(newReport);

        int reportDeleteById = 20;


        boolean isDeleted = reportService.deleteReport(reportDeleteById);
        if (isDeleted) {
            System.out.println("Категория с ID " + reportDeleteById + " успешно удалена.");
        } else {
            System.out.println("Категория с ID " + reportDeleteById + " не найдена.");
        }
    }
}
