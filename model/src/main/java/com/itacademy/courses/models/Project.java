package com.itacademy.courses.models;

import java.sql.Timestamp;

public class Project {
    private int id;
    private int user_id;
    private String name;
    private String description;
    private Timestamp created_at;
    private Timestamp updated_at;

    public int getProjectId() {
        return id;
    }

    public void setProjectId(int projectId) {
        this.id = projectId;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
