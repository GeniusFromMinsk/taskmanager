package com.itacademy.courses.enums;

public enum TaskFilter {

    BY_STATUS("SELECT * FROM TASKS WHERE STATUS = ?"),
    BY_PRIORITY("SELECT * FROM TASKS WHERE PRIORITY = ?");

    private final String query;

    TaskFilter(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
