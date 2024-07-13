package com.itacademy.courses.models;

import java.sql.Timestamp;

public class Tag {
    private int id;
    private String name;
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
}
