package com.itclopedia.courses;

import com.itclopedia.courses.models.User;
import com.itclopedia.courses.dao.UserRepository;
import com.itclopedia.courses.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class UserServiceTest {
   /* private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void setup() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    public void testCreate() {
        User user = new User();
        user.setPassword("1213");
        user.setUsername("Kirill");
        user.setEmail("john.doe@example.com");

        when(userRepository.save(user)).thenReturn(user);

        userService.addUser(user);

        verify(userRepository, times(1)).save(user);
        assertEquals("Kirill", user.getUsername());
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setPassword("1213");
        user.setUsername("Kirill");
        user.setEmail("john.doe@example.com");

        when(userRepository.save(user)).thenReturn(user);

        userService.updateUser(user);

        verify(userRepository, times(1)).save(user);
        assertEquals("Kirill", user.getUsername());
    }

    @Test
    public void testGet() {
        User user = new User();
        user.setUsername("john_doe");
        when(userRepository.findById(3)).thenReturn(Optional.of(user));

        User retrievedUser = userService.getUserById(3);
        assertEquals("john_doe", retrievedUser.getUsername());
    }

    @Test
    public void testDelete() {
        int id = 24;
        when(userRepository.existsById(id)).thenReturn(true);

        userService.deleteUser(id);

        verify(userRepository, times(1)).deleteById(id);
        when(userRepository.findById(id)).thenReturn(Optional.empty());
        User deletedUser = userService.getUserById(id);
        assertNull(deletedUser);
    }

    */
}
