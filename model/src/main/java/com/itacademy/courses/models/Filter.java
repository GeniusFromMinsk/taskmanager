package com.itacademy.courses.models;

import java.sql.Timestamp;

public class Filter {
    private int id;
    private String filter_name;
    private String criteria;
    private Timestamp created_at;
    private Timestamp updated_at;

    public int getFilterId() {
        return id;
    }

    public void setFilterId(int filterId) {
        this.id = filterId;
    }


    public String getName() {
        return filter_name;
    }

    public void setName(String name) {
        this.filter_name = name;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
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
