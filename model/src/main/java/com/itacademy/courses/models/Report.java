package com.itacademy.courses.models;

import java.sql.Timestamp;

public class Report {
    private int id;
    private int user_id;
    private String content;
    private Timestamp created_at;

    public int getReportId() {
        return id;
    }

    public void setReportId(int reportId) {
        this.id = reportId;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.created_at = createdAt;
    }

}
