package com.itacademy.courses.models;

import java.sql.Timestamp;
import java.util.Date;

public class Subtask {

    private int id;
    private int task_id;
    private String title;
    private String status;
    private Date due_date;
    private Timestamp created_at;
    private Timestamp updated_at;

    public int getSubtaskId() {
        return id;
    }

    public void setSubtaskId(int subtaskId) {
        this.id = subtaskId;
    }

    public int getTaskId() {
        return task_id;
    }

    public void setTaskId(int taskId) {
        this.task_id = taskId;
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

    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.created_at = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updated_at = updatedAt;
    }
}
