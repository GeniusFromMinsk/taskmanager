package com.itacademy.courses;

import com.itacademy.courses.models.*;
import com.itacademy.courses.services.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UpdateApp {
    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;
    private final TagService tagService;
    private final CategoryService categoryService;
    private final ReportService reportService;
    private final SubtaskService subtaskService;

    public UpdateApp() {
        this.userService = new UserService();
        this.projectService = new ProjectService();
        this.taskService = new TaskService();
        this.tagService = new TagService();
        this.categoryService = new CategoryService();
        this.reportService = new ReportService();
        this.subtaskService = new SubtaskService();
    }

    public void start() throws ParseException {
        //User user = new User();
        //updateUser(user);
        //updateProject();
        //updateTask();
        //updateTag();
        //updateCategory();
        //updateReport();
        //updateSubtask();
    }

    private void updateUser(User user){
        user.setUserId(1); // Установите существующий ID пользователя
        user.setUsername("Ronaldo");
        user.setEmail("ronaldo.7@example.com");
        user.setPassword("1111");
        boolean success = userService.updateUser(user);
        if (success) {
            System.out.println("Обновлен пользователь: " + user);
        } else {
            System.err.println("Ошибка при обновлении пользователя.");
        }
    }




    private void updateProject() {
        Project project = new Project();
        project.setProjectId(1); // Установите существующий ID проекта
        project.setUserId(1);
        project.setName("Обновленный проект A");
        project.setDescription("Обновленное описание проекта A");

        boolean success = projectService.updateProject(project);
        if (success) {
            System.out.println("Обновлен проект: " + project);
        } else {
            System.err.println("Ошибка при обновлении проекта.");
        }
    }

    private void updateTask() throws ParseException {
        Task task = new Task();
        task.setTaskId(3); // Установите существующий ID задачи
        task.setUserId(2); // Предположим, что задача связана с пользователем с ID 1
        task.setTitle("Обновленное название задачи");
        task.setDescription("Обновленное описание задачи");
        task.setStatus("completed");
        task.setPriority("Высокий");
        task.setDueDate(new Date(124, Calendar.AUGUST, 25));

        String dateString = "2024-08-27 14:01:22";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = dateFormat.parse(dateString);
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        task.setReminderTime(timestamp);


        boolean success = taskService.updateTask(task);
        if (success) {
            System.out.println("Обновлена задача: " + task);
        } else {
            System.err.println("Ошибка при обновлении задачи.");
        }
    }



    private void updateTag() {
        Tag tag = new Tag();
        tag.setTagId(1); // Установите существующий ID тега
        tag.setName("Обновленное название тега");
        boolean success = tagService.updateTag(tag);
        if (success) {
            System.out.println("Обновлен тег: " + tag);
        } else {
            System.err.println("Ошибка при обновлении тега.");
        }
    }



    private void updateCategory() {
        Category category = new Category();
        category.setCategoryId(1); // Установите существующий ID категории
        category.setName("Обновленное название категории");
        category.setDescription("Обновленное описание категории");

        boolean success = categoryService.updateCategory(category);
        if (success) {
            System.out.println("Обновлена категория: " + category);
        } else {
            System.err.println("Ошибка при обновлении категории.");
        }
    }



    private void updateReport() {
        Report report = new Report();
        report.setReportId(1); // Установите существующий ID отчета
        report.setUserId(1); // Установите существующий ID пользователя
        report.setContent("Обновленное содержание отчета");
        boolean success = reportService.updateReport(report);
        if (success) {
            System.out.println("Обновлен отчет: " + report);
        } else {
            System.err.println("Ошибка при обновлении отчета.");
        }
    }



    private void updateSubtask() {
        Subtask subtask = new Subtask();
        subtask.setSubtaskId(1); // Установите существующий ID подзадачи
        subtask.setTaskId(1); // Установите существующий ID задачи
        subtask.setTitle("Обновленное название подзадачи");
        subtask.setStatus("completed");
        subtask.setDueDate(new Date(124, Calendar.AUGUST, 25));
        boolean success = subtaskService.updateSubtask(subtask);
        if (success) {
            System.out.println("Обновлена подзадача: " + subtask);
        } else {
            System.err.println("Ошибка при обновлении подзадачи.");
        }
    }
}