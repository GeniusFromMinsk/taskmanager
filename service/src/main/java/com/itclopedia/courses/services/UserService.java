package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.UserRepository;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsStringException;
import com.itclopedia.courses.models.User;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new EntityNotFoundException("User", user.getId());
        }
        userRepository.save(user);
    }

    public void deleteUser(int userId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("User", userId);
        }
        userRepository.deleteById(userId);
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User", userId));
    }

    public boolean isUserExists(String email, String username) {
        return userRepository.existsByEmail(email) || userRepository.existsByUsername(username);
    }

    public void registerUser(User user) {
        if (isUserExists(user.getEmail(), user.getUsername())) {
            throw new EntityAlreadyExistsStringException("User with email or username", user.getEmail());
        }
        userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        return userRepository.findAll().stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
