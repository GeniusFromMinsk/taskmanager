package com.itclopedia.courses.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
public class ReportDTO {

    private int id;

    private String content;

    private Integer userId;

    @JsonCreator
    public ReportDTO(@JsonProperty("id") int id, @JsonProperty("content") String content, @JsonProperty("user_id") Integer userId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
