package com.itacademy.courses.models;

import java.sql.Timestamp;

public class User {
    private int id;
    private String userName;
    private String email;
    private String password;
    public int getUserId() {
        return id;
    }
    public void setUserId(int userId) {
        this.id = userId;
    }
    public String getUsername() {
        return userName;
    }
    public void setUsername(String username) {
        this.userName = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
