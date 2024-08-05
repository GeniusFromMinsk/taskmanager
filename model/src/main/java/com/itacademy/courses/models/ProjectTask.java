package com.itacademy.courses.models;

public class ProjectTask {

    private int id;

    private int projectId;

    private int taskId;

    public int getProjectTaskId() {
        return id;
    }

    public void setProjectTaskId(int projectTaskId) {
        this.id = projectTaskId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

}
