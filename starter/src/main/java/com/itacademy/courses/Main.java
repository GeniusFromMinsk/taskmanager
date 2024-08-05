package com.itacademy.courses;

import com.itacademy.courses.dao.ProjectDAO;
import com.itacademy.courses.dao.ReportDAO;
import com.itacademy.courses.dao.TaskDAO;
import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.models.Project;
import com.itacademy.courses.models.Task;
import com.itacademy.courses.models.Report;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ParseException {
        ReportDAO reportDAO = new ReportDAO();
        int reportId = 18; // Замените на актуальный ID существующего отчета
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

        // Получаем существующий отчет
        try (Session session = sessionFactory.openSession()) {
            Report existingReport = session.get(Report.class, reportId);
            if (existingReport != null) {
                // Изменяем содержание отчета
                existingReport.setContent("Updated content for the existing report");

                // Обновляем отчет через DAO
                reportDAO.updateReport(existingReport);
                System.out.println("Report updated: " + existingReport);
            } else {
                System.out.println("Report not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
