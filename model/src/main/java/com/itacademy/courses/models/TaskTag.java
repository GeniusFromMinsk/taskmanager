package com.itacademy.courses.models;

import java.sql.Timestamp;

public class TaskTag {
    private int taskId;
    private int tagId;
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public int getTagId() {
        return tagId;
    }
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
