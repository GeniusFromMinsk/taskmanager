package com.itacademy.courses.models;

import java.sql.Timestamp;
import java.util.Date;

public class Subtask {
    private int id;
    private int taskId;
    private String title;
    private String status;
    private Date due_date;
    public int getSubtaskId() {
        return id;
    }
    public void setSubtaskId(int subtaskId) {
        this.id = subtaskId;
    }
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getDueDate() {
        return due_date;
    }
    public void setDueDate(Date dueDate) {
        this.due_date = dueDate;
    }
}
