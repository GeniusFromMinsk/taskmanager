package com.itclopedia.courses.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class SubtaskDTO {

    private int id;

    private int taskId;

    private String title;

    private String status;

    private Date dueDate;

    @JsonCreator
    public SubtaskDTO(@JsonProperty("id") int id, @JsonProperty("task_id") int taskId, @JsonProperty("title") String title, @JsonProperty("status") String status,  @JsonProperty("due_date") Date dueDate) {
        this.id = id;
        this.taskId = taskId;
        this.title = title;
        this.status = status;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
