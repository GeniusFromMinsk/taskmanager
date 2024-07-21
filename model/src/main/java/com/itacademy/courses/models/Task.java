package com.itacademy.courses.models;

import java.sql.Timestamp;
import java.util.Date;

public class Task {

    private int id;

    private int userId;

    private String title;

    private String description;

    private String status;

    private String priority;

    private Date dueDate;

    private Timestamp reminderTime;

    public int getTaskId() {
        return id;
    }

    public void setTaskId(int taskId) {
        this.id = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Timestamp getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(Timestamp reminderTime) {
        this.reminderTime = reminderTime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", user_id=" + userId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", due_date=" + dueDate +
                ", reminder_time=" + reminderTime +
                '}';
    }

}
