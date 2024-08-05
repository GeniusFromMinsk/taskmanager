package com.itacademy.courses.services;

import com.itacademy.courses.dao.TaskTagDAO;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.TaskTag;

import java.sql.SQLException;
import java.util.List;

public class TaskTagService {
    private TaskTagDAO taskTagDAO;

    public TaskTagService() {
        this.taskTagDAO = new TaskTagDAO();
    }

    public void createTaskTag(TaskTag taskTag) {
        try {
            taskTagDAO.insertTaskTag(taskTag);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }





}