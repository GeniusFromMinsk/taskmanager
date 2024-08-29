package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.UserDAO;
import com.itclopedia.courses.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDAO userDAO;
    @Autowired
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

    public void registerUser(User user) {
        if (userDAO.isUserExists(user.getEmail(), user.getUsername())) {
            System.out.println("Пользователь не был создан, такой уже существует");
        }
        userDAO.insertUser(user);
    }

    public User loginUser(String email, String password) {
        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

}