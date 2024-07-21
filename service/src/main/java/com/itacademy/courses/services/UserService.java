package com.itacademy.courses.services;

import com.itacademy.courses.dao.UserDAO;
import com.itacademy.courses.exceptions.SQLExceptionHandler;
import com.itacademy.courses.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void registerUser(User user) {
        try {
            if (userDAO.isUserExists(user.getEmail(), user.getUsername())) {
                System.out.println("Пользователь не был создан, такой уже существует");
            }
            userDAO.insertUser(user);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
    }

    public User loginUser(String email, String password) {
        try {
            List<User> users = userDAO.getAllUsers();
            for (User user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
        }
        return null;
    }

    public boolean updateUser(User user) {
        try {
            return userDAO.updateUser(user);
        } catch (SQLException e) {
            SQLExceptionHandler.printSQLException(e);
            return false;
        }
    }
}