package com.itacademy.courses.models;

import java.sql.Timestamp;
import java.util.Date;

public class Task {
    private int id;
    private int user_id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private Date due_date;
    private Timestamp reminder_time;
    private Timestamp created_at;
    private Timestamp updated_at;

    // Getters and setters
    public int getTaskId() {
        return id;
    }

    public void setTaskId(int taskId) {
        this.id = taskId;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return due_date;
    }

    public void setDueDate(Date dueDate) {
        this.due_date = dueDate;
    }

    public Timestamp getReminderTime() {
        return reminder_time;
    }

    public void setReminderTime(Timestamp reminderTime) {
        this.reminder_time = reminderTime;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", due_date=" + due_date +
                ", reminder_time=" + reminder_time +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
