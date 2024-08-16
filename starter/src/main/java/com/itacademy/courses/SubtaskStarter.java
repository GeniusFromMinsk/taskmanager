package com.itacademy.courses;

import com.itacademy.courses.dao.SubtaskDAO;
import com.itacademy.courses.dao.TaskDAO;
import com.itacademy.courses.models.Subtask;
import com.itacademy.courses.services.SubtaskService;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class SubtaskStarter {
    public static void main(String[] args) {
        SubtaskDAO subtaskDAO = new SubtaskDAO();
        TaskDAO taskDAO = new TaskDAO();
        SubtaskService subtaskService = new SubtaskService(subtaskDAO, taskDAO);

        Subtask newSubtask = new Subtask();
        newSubtask.setTaskId(4);
        newSubtask.setTitle("New Subtask");
        newSubtask.setStatus("Pending");
        newSubtask.setDueDate(new Date(124, Calendar.AUGUST, 23));
        subtaskService.addSubtask(newSubtask);

        newSubtask.setStatus("Completed");
        subtaskService.updateSubtask(newSubtask);

        int subTaskToDeleteById = 20;

        boolean isDeleted = subtaskService.deleteSubtask(subTaskToDeleteById);
        if (isDeleted) {
            System.out.println("Категория с ID " + subTaskToDeleteById + " успешно удалена.");
        } else {
            System.out.println("Категория с ID " + subTaskToDeleteById + " не найдена.");
        }
    }
}
