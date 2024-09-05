package com.itclopedia.courses;

import com.itclopedia.courses.dao.TaskDAO;
import com.itclopedia.courses.dao.UserDAO;
import com.itclopedia.courses.models.Task;
import com.itclopedia.courses.models.User;
import com.itclopedia.courses.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class TaskServiceTest {
    private TaskDAO taskDAO;
    private UserDAO userDAO;
    private TaskService taskService;

    @BeforeEach
    public void setup() {
        taskDAO = mock(TaskDAO.class);
        userDAO = mock(UserDAO.class);
        taskService = new TaskService(taskDAO);
    }

    @Test
    public void testCreate() throws Exception {
        Task task = new Task();
        User user = new User();
        user.setId(18);
        task.setUser(user);
        task.setStatus("in progress");
        task.setDescription("desc");
        task.setPriority("high");
        task.setTitle("title");
        task.setDueDate(new Date(124, Calendar.AUGUST, 23));
        Timestamp timestamp = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2024-08-24 14:00:00").getTime());
        task.setReminderTime(timestamp);

        when(userDAO.getUserById(18)).thenReturn(user);

        taskService.addTask(task);

        verify(taskDAO, times(1)).insertTask(task);
        assertEquals("in progress", task.getStatus());
    }

    @Test
    public void testUpdate() throws Exception {
        Task task = new Task();
        User user = new User();
        user.setId(1);
        task.setUser(user);
        task.setStatus("in progress");
        task.setPriority("high");
        task.setTitle("title");
        task.setDescription("desc");
        task.setDueDate(new Date(124, Calendar.AUGUST, 23));
        Timestamp timestamp = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2024-08-24 14:00:00").getTime());
        task.setReminderTime(timestamp);

        taskService.updateTask(task);

        verify(taskDAO, times(1)).updateTask(task);
        assertEquals("in progress", task.getStatus());
    }

    @Test
    public void testGet() {
        Task task = new Task();
        task.setStatus("in progress");
        when(taskDAO.selectTask(2)).thenReturn(task);

        Task retrievedTask = taskService.getTaskById(2);
        assertEquals("in progress", retrievedTask.getStatus());
    }

    @Test
    public void testDelete() {
        int id = 24;
        when(taskDAO.selectTask(id)).thenReturn(null);

        taskService.deleteTask(id);

        verify(taskDAO, times(1)).deleteTask(id);
        Task deletedTask = taskService.getTaskById(id);
        assertNull(deletedTask);
    }
}
