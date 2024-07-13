package com.itacademy.courses.models;

import java.sql.Timestamp;

public class Project {
    private int id;
    private int userId;
    private String name;
    private String description;
    public int getProjectId() {
        return id;
    }
    public void setProjectId(int projectId) {
        this.id = projectId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
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
}
