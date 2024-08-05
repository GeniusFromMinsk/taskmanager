package com.itacademy.courses.models;

public class Report {

    private int id;

    private int userId;

    private String content;

    public int getReportId() {
        return id;
    }

    public void setReportId(int reportId) {
        this.id = reportId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
