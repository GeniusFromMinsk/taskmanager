package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.UserRepository;
import com.itclopedia.courses.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public boolean isUserExists(String email, String username) {
        return userRepository.existsByEmailOrUsername(email, username);
    }

    public void registerUser(User user) {
        if (isUserExists(user.getEmail(), user.getUsername())) {
            System.out.println("Пользователь не был создан, такой уже существует");
        } else {
            userRepository.save(user);
        }
    }

    public User loginUser(String email, String password) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
