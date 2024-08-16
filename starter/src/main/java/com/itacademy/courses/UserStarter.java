package com.itacademy.courses;

import com.itacademy.courses.dao.UserDAO;
import com.itacademy.courses.models.User;
import com.itacademy.courses.services.UserService;

import java.util.List;

public class UserStarter {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(userDAO);

        User newUser = new User();
        newUser.setUsername("newuser");
        newUser.setEmail("newuser@example.com");
        newUser.setPassword("password123");
        userService.addUser(newUser);

        newUser.setUsername("updateduser");
        userService.updateUser(newUser);

        User user = userService.getUserById(newUser.getUserId());
        System.out.println(user);

        userService.deleteUser(newUser.getUserId());

        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);

        boolean exists = userService.isUserExists("newuser@example.com", "newuser");
        System.out.println("User exists: " + exists);
    }
}
