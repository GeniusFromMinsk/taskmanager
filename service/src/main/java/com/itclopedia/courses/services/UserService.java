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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        if (!userRepository.existsById(Math.toIntExact(user.getId()))) {
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
    public User save(User user) {
        if (isUserExists(user.getEmail(), user.getUsername())) {
            throw new EntityAlreadyExistsStringException("User with email or username", user.getEmail());
        }
        return userRepository.save(user);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

}
