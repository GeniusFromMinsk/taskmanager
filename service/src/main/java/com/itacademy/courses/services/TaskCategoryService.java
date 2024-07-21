package com.itacademy.courses.services;

import com.itacademy.courses.dao.TaskCategoryDAO;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.TaskCategory;

import java.sql.SQLException;
import java.util.List;

public class TaskCategoryService {

    private TaskCategoryDAO taskCategoryDAO;

    public TaskCategoryService() {
        this.taskCategoryDAO = new TaskCategoryDAO();
    }

    public void createTaskCategory(TaskCategory taskCategory) {
        try {
            taskCategoryDAO.insertTaskCategory(taskCategory);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }


}
