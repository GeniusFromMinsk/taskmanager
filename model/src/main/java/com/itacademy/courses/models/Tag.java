package com.itacademy.courses.models;

import java.sql.Timestamp;

public class Tag {
    private int id;
    private String name;
    private Timestamp created_at;
    private Timestamp updated_at;

    public int getTagId() {
        return id;
    }

    public void setTagId(int tagId) {
        this.id = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
