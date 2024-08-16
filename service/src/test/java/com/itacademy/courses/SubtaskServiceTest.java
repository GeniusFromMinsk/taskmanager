package com.itacademy.courses;

import com.itacademy.courses.dao.SubtaskDAO;
import com.itacademy.courses.dao.TaskDAO;
import com.itacademy.courses.models.Subtask;
import com.itacademy.courses.models.Task;
import com.itacademy.courses.services.SubtaskService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class SubtaskServiceTest {

    private SubtaskDAO subtaskDAO;
    private SubtaskService subtaskService;
    private TaskDAO taskDAO;

    @BeforeEach
    public void setup() {
        subtaskDAO = Mockito.mock(SubtaskDAO.class);
        taskDAO = Mockito.mock(TaskDAO.class);
        subtaskService = new SubtaskService(subtaskDAO, taskDAO);
    }

    @Test
    public void testCreate() {
        Subtask subtask = new Subtask();
        Task task = new Task();
        task.setTaskId(13);
        when(taskDAO.selectTask(13)).thenReturn(task);
        subtask.setTaskId(task.getTaskId());
        subtask.setStatus("pending");
        subtask.setTitle("Subtask 1 for Task 1");
        subtask.setDueDate(new Date(124, Calendar.AUGUST, 23));

        subtaskService.addSubtask(subtask);

        verify(subtaskDAO, times(1)).insertSubtask(subtask);
        assertEquals("pending", subtask.getStatus());
    }

    @Test
    public void testUpdate() {
        Subtask subtask = new Subtask();
        subtask.setTaskId(13);
        subtask.setStatus("completed");
        subtask.setTitle("Updated Subtask");
        subtask.setDueDate(new Date());

        subtaskService.updateSubtask(subtask);

        verify(subtaskDAO, times(1)).updateSubtask(subtask);
    }

    @Test
    public void testGet() {
        Subtask subtask = new Subtask();
        subtask.setStatus("pending");

        when(subtaskDAO.getSubtaskById(28)).thenReturn(subtask);

        Subtask retrievedSubtask = subtaskService.getSubTaskById(28);
        assertEquals("pending", retrievedSubtask.getStatus());
    }

    @Test
    public void testDelete() {
        int id = 33;

        when(subtaskDAO.getSubtaskById(id)).thenReturn(null);
        subtaskService.deleteSubtask(id);

        verify(subtaskDAO, times(1)).deleteSubtask(id);
        assertNull(subtaskService.getSubTaskById(id));
    }
}
