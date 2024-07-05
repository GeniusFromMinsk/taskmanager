package com.itacademy.courses.models;

import java.sql.Timestamp;

public class TaskTag {
    private int task_id;
    private int tag_id;
    private Timestamp created_at;
    private Timestamp updated_at;

    public int getTaskId() {
        return task_id;
    }

    public void setTaskId(int taskId) {
        this.task_id = taskId;
    }

    public int getTagId() {
        return tag_id;
    }

    public void setTagId(int tagId) {
        this.tag_id = tagId;
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
