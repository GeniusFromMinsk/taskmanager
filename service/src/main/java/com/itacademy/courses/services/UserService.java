package com.itacademy.courses.services;

import com.itacademy.courses.dao.UserDAO;
import com.itacademy.courses.models.User;

import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void addUser(User user) {
        userDAO.insertUser(user);
    }

    public boolean deleteUser(int userId) {
        return userDAO.deleteUser(userId);
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public boolean isUserExists(String email, String username) {
        return userDAO.isUserExists(email, username);
    }
}