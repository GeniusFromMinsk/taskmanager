package com.itclopedia.courses.enums;

public enum TaskFilter {

    BY_STATUS("FROM Task WHERE status = :value"),
    BY_PRIORITY("FROM Task WHERE priority = :value");

    private final String query;

    TaskFilter(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
