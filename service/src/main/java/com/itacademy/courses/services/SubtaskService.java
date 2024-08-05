package com.itacademy.courses.services;

import com.itacademy.courses.dao.SubtaskDAO;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.Subtask;

import java.sql.SQLException;
import java.util.List;

public class SubtaskService {

    private SubtaskDAO subtaskDAO;

    public SubtaskService() {
        this.subtaskDAO = new SubtaskDAO();
    }

    public void createSubtask(Subtask subtask) {
        try {
            subtaskDAO.insertSubtask(subtask);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }

    public boolean updateSubtask(Subtask subtask) {
        try {
            return subtaskDAO.updateSubtask(subtask);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            return false;
        }
    }

    public boolean deleteSubtask(int subtaskId) {
        try {
            return subtaskDAO.deleteSubtask(subtaskId);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            return false;
        }
    }
}
