package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.UserDAO;
import com.itclopedia.courses.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(User user) {
        log.info("Adding user: {}", user);
        userDAO.insertUser(user);
        log.info("User added successfully: {}", user);
    }

    public void deleteUser(int userId) {
        log.info("Deleting user with ID: {}", userId);
        userDAO.deleteUser(userId);
        log.info("User deleted successfully with ID: {}", userId);
    }

    public void updateUser(User user) {
        log.info("Updating user: {}", user);
        userDAO.updateUser(user);
        log.info("User updated successfully: {}", user);
    }

    public User getUserById(int userId) {
        log.info("Fetching user with ID: {}", userId);
        User user = userDAO.getUserById(userId);
        if (user != null) {
            log.info("User found: {}", user);
        } else {
            log.warn("User not found with ID: {}", userId);
        }
        return user;
    }

    public List<User> getAllUsers() {
        log.info("Fetching all users");
        List<User> users = userDAO.getAllUsers();
        log.info("Retrieved {} users", users.size());
        return users;
    }

    public boolean isUserExists(String email, String username) {
        log.info("Checking if user exists with email: {} and username: {}", email, username);
        boolean exists = userDAO.isUserExists(email, username);
        if (exists) {
            log.info("User exists with email: {} and username: {}", email, username);
        } else {
            log.info("User does not exist with email: {} and username: {}", email, username);
        }
        return exists;
    }

    public void registerUser(User user) {
        log.info("Registering user: {}", user);
        if (userDAO.isUserExists(user.getEmail(), user.getUsername())) {
            log.warn("User not created, already exists with email: {} and username: {}", user.getEmail(), user.getUsername());
        } else {
            userDAO.insertUser(user);
            log.info("User registered successfully: {}", user);
        }
    }

    public User loginUser(String email, String password) {
        log.info("User login attempt with email: {}", email);
        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                log.info("User logged in successfully: {}", user);
                return user;
            }
        }
        log.warn("Login failed for email: {}", email);
        return null;
    }
}
