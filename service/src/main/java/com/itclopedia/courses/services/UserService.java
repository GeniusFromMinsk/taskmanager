package com.itclopedia.courses.services;

import com.itclopedia.courses.dto.UserDTO;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsStringException;
import com.itclopedia.courses.mapper.UserMapper;
import com.itclopedia.courses.dao.UserRepository;
import com.itclopedia.courses.models.User;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
import com.itclopedia.courses.exceptions.EntityStringNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
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

    public UserDTO getUserById(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User", userId));
        return userMapper.toUserDTO(user);
    }

    public boolean isUserExists(String email, String username) {
        return userRepository.existsByEmail(email) || userRepository.existsByUsername(username);
    }

    public void registerUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        if (isUserExists(user.getEmail(), user.getUsername())) {
            throw new EntityAlreadyExistsStringException("User with email or username", user.getEmail());
        }
        userRepository.save(user);
    }

    public UserDTO loginUser(String email, String password) {
        return userRepository.findAll().stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst()
                .map(userMapper::toUserDTO)
                .orElse(null);
    }

    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityStringNotFoundException("User", username));
        return userMapper.toUserDTO(user);
    }

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityStringNotFoundException("User", email));
        return userMapper.toUserDTO(user);
    }
}
