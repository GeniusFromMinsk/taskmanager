package com.itacademy.courses.models;

import java.sql.Timestamp;

public class ProjectTask {
    private int id;
    private int project_id;
    private int task_id;
    private Timestamp created_at;
    private Timestamp updated_at;

    public int getProjectTaskId() {
        return id;
    }

    public void setProjectTaskId(int projectTaskId) {
        this.id = projectTaskId;
    }

    public int getProjectId() {
        return project_id;
    }

    public void setProjectId(int projectId) {
        this.project_id = projectId;
    }

    public int getTaskId() {
        return task_id;
    }

    public void setTaskId(int taskId) {
        this.task_id = taskId;
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
