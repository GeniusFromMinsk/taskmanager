package com.itacademy.courses.services;

import com.itacademy.courses.dao.UserDAO;
import com.itacademy.courses.models.User;

import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(User user) {
        userDAO.insertUser(user);
    }

    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
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
