package com.itacademy.courses;

import com.itacademy.courses.models.*;
import com.itacademy.courses.services.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InsertApp {
    private final UserService userService;
    private final ProjectService projectService;
    private final TaskService taskService;
    private final TagService tagService;
    private final TaskTagService taskTagService;
    private final CategoryService categoryService;
    private final ReportService reportService;
    private final SubtaskService subtaskService;
    private final TaskCategoryService taskCategoryService;
    private final ProjectTaskService projectTaskService;

    public InsertApp() {
        this.userService = new UserService();
        this.projectService = new ProjectService();
        this.taskService = new TaskService();
        this.tagService = new TagService();
        this.taskTagService = new TaskTagService();
        this.categoryService = new CategoryService();
        this.reportService = new ReportService();
        this.subtaskService = new SubtaskService();
        this.taskCategoryService = new TaskCategoryService();
        this.projectTaskService = new ProjectTaskService();
    }

    public void start() throws ParseException {
        User user = new User();
        // Task task = new Task();
        createUser(user);
        //createTag();
        //createReportsForUser();
       // if (user != null) {
       //   createProjectForUser();
        //  createTaskForUser(user);
       //   System.out.println("Пользователь и проект успешно созданы!");
      //  } else {
      //      System.err.println("Ошибка при создании пользователя.");
     //   }

     //   if(task != null){
      //      createSubTask();
      //      System.out.println("Подзадача создана");
      //  }
      //  else {
      //      System.err.println("ошибка при создании подзадачи");
     //   }
//
      //  createCategories();
     //   createTaskCategory();
      //  createTaskTag();
      //  createProjectTask();
    }

    private void createUser(User user){
        user.setUsername("Kirilll123");
        user.setEmail("kkx.eeex@example.com");
        user.setPassword("1111");
        userService.registerUser(user);
    }

    private void createCategories(){
        Category category = new Category();
        category.setName("Personal");
        category.setDescription("Tasks related to work");
        categoryService.createCategory(category);
        System.out.println("создана категория задачи" + category);
    }
    private void createTag(){
        Tag tag = new Tag();
        tag.setName("home");
        tagService.createTag(tag);
        System.out.println("Создан тэг для работы над задачей: " + tag);
    }

    private void createProjectForUser() {
        Project project = new Project();
        project.setUserId(10);
        project.setName("Проект A");
        project.setDescription("Описание проекта A");

        projectService.createProject(project);
        System.out.println("Создан проект: " + project);
    }

    private void createTaskForUser(User user) throws ParseException {
        Task task = new Task();
        task.setUserId(user.getUserId());
        task.setTitle("Сделать задачу");
        task.setDescription("Задача по Java");
        task.setPriority("Средний");
        task.setStatus("В работе");
        task.setDueDate(new Date(124, Calendar.JULY, 23));

        String dateString = "2024-06-24 14:00:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = dateFormat.parse(dateString);
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        task.setReminderTime(timestamp);

        taskService.createTask(task);

        System.out.println("Создано задание для User: " + task);
    }

    private void createReportsForUser(){
        Report report = new Report();
        report.setUserId(10);
        report.setContent("report content for user 1");
        reportService.createReport(report);
        System.out.println("Создано report для User: " + report);
    }

    private void createSubTask() {
        Subtask subtask = new Subtask();
        subtask.setTaskId(12);
        subtask.setTitle("Subtask 1 for Task 1");
        subtask.setStatus("pending");
        subtask.setDueDate(new Date(124, Calendar.JULY, 23));
        subtaskService.createSubtask(subtask);
    }

   private void createTaskCategory() {
        TaskCategory taskCategory = new TaskCategory();
        taskCategory.setTaskId(28);
        taskCategory.setCategoryId(28);

        taskCategoryService.createTaskCategory(taskCategory);
        System.out.println("Создана связь Task и Category: " + taskCategory);
    }

   private void createTaskTag(){
        TaskTag taskTag = new TaskTag();
        taskTag.setTaskId(12);
        taskTag.setTagId(23);

        taskTagService.createTaskTag(taskTag);
    }

    private void createProjectTask(){
        ProjectTask projectTask = new ProjectTask();
        projectTask.setProjectId(18);
        projectTask.setTaskId(18);
        projectTaskService.createProjectTask(projectTask);
    }

}