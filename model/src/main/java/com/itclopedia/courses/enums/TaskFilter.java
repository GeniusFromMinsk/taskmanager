package com.itclopedia.courses.enums;

public enum TaskFilter {
    BY_STATUS("status"),
    BY_PRIORITY("priority");

    private final String fieldName;

    TaskFilter(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
