package com.itacademy.courses.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("status")
    private String status;

    @JsonProperty("priority")
    private String priority;

    public TaskDTO(int id, String title, String status, String priority) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.priority = priority;
    }
}
