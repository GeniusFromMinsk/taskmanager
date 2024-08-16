package com.itacademy.courses;

import com.itacademy.courses.dao.UserDAO;
import com.itacademy.courses.models.User;
import com.itacademy.courses.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserDAO userDAO;
    private UserService userService;

    @BeforeEach
    public void setup() {
        userDAO = mock(UserDAO.class);
        userService = new UserService(userDAO);
    }

    @Test
    public void testCreate() {
        User user = new User();
        user.setPassword("1213");
        user.setUserName("Kirill");
        user.setEmail("john.doe@example.com");

        doNothing().when(userDAO).insertUser(user);

        userService.addUser(user);

        verify(userDAO, times(1)).insertUser(user);
        assertEquals("Kirill", user.getUserName());
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setPassword("1213");
        user.setUserName("Kirill");
        user.setEmail("john.doe@example.com");

        doNothing().when(userDAO).updateUser(user);

        userService.updateUser(user);

        verify(userDAO, times(1)).updateUser(user);
        assertEquals("Kirill", user.getUserName());
    }

    @Test
    public void testGet() {
        User user = new User();
        user.setUserName("john_doe");
        when(userDAO.getUserById(3)).thenReturn(user);

        User retrievedUser = userService.getUserById(3);
        assertEquals("john_doe", retrievedUser.getUserName());
    }

    @Test
    public void testDelete() {
        int id = 3;
        doNothing().when(userDAO).deleteUser(id);
        when(userDAO.getUserById(id)).thenReturn(null);

        userService.deleteUser(id);

        verify(userDAO, times(1)).deleteUser(id);
        User deletedUser = userService.getUserById(id);
        assertNull(deletedUser);
    }
}
