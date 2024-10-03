package com.itclopedia.courses;

import com.itclopedia.courses.enums.TaskFilter;
import com.itclopedia.courses.models.Task;
import com.itclopedia.courses.models.User;
import com.itclopedia.courses.dao.TaskRepository;
import com.itclopedia.courses.dao.UserRepository;
import com.itclopedia.courses.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;
import specification.TaskSpecifications;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class TaskServiceTest {
    /*private TaskRepository taskRepository;
    private UserRepository userRepository;
    private TaskService taskService;

    @BeforeEach
    public void setup() {
        taskRepository = mock(TaskRepository.class);
        userRepository = mock(UserRepository.class);
        taskService = new TaskService(taskRepository);
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

        when(userRepository.findById(18)).thenReturn(Optional.of(user));

        taskService.addTask(task);

        verify(taskRepository, times(1)).save(task);
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

        verify(taskRepository, times(1)).save(task);
        assertEquals("in progress", task.getStatus());
    }

    @Test
    public void testGet() {
        Task task = new Task();
        task.setStatus("in progress");
        when(taskRepository.findById(2)).thenReturn(Optional.of(task));

        Task retrievedTask = taskService.getTaskById(2);
        assertEquals("in progress", retrievedTask.getStatus());
    }

    @Test
    public void testDelete() {
        int id = 24;
        when(taskRepository.existsById(id)).thenReturn(true);

        taskService.deleteTask(id);

        verify(taskRepository, times(1)).deleteById(id);
        when(taskRepository.findById(id)).thenReturn(Optional.empty());
        Task deletedTask = taskService.getTaskById(id);
        assertNull(deletedTask);
    }

    @Test
    void testGetTasksByFilter() {
        Task task1 = new Task();
        task1.setStatus("OPEN");

        Task task2 = new Task();
        task2.setStatus("CLOSED");

        List<Task> tasks = List.of(task1);

        when(taskRepository.findAll(any(Specification.class))).thenReturn(tasks);

        List<Task> result = taskService.getTasksByFilter(TaskFilter.BY_STATUS, "OPEN");

        assertEquals(1, result.size());
        assertEquals("OPEN", result.get(0).getStatus());
    }

     */
}
