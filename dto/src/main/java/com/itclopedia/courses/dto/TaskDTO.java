package com.itclopedia.courses.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
public class TaskDTO {

    private int id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private Date dueDate;
    private Timestamp reminderTime;
    private Integer userId;
    @JsonCreator
    public TaskDTO(@JsonProperty("id") int id, @JsonProperty("title") String title,@JsonProperty("description") String description, @JsonProperty("status") String status, @JsonProperty("priority") String priority, @JsonProperty("due_date") Date dueDate, @JsonProperty("reminder_time") Timestamp reminderTime, @JsonProperty("user_id") Integer userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dueDate = dueDate;
        this.reminderTime = reminderTime;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
