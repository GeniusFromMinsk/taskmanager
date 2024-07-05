package com.itacademy.courses.services;

import com.itacademy.courses.dao.UserDAO;
import com.itacademy.courses.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void createUser(User user) {
        try {
            userDAO.insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateUser(User user) {
        try {
            return userDAO.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(int userId) {
        try {
            return userDAO.deleteUser(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}