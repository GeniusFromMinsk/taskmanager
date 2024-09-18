package com.itclopedia.courses;

import com.itclopedia.courses.models.Subtask;
import com.itclopedia.courses.models.Task;
import com.itclopedia.courses.dao.SubtaskRepository;
import com.itclopedia.courses.services.SubtaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class SubtaskServiceTest {

    private SubtaskRepository subtaskRepository;
    private SubtaskService subtaskService;

    @BeforeEach
    public void setup() {
        subtaskRepository = Mockito.mock(SubtaskRepository.class);
        subtaskService = new SubtaskService(subtaskRepository);
    }

    @Test
    public void testCreate() {
        Subtask subtask = new Subtask();
        Task task = new Task();
        task.setId(3);
        subtask.setTaskId(task.getId());
        subtask.setStatus("pending");
        subtask.setTitle("Subtask 1 for Task 1");
        subtask.setDueDate(new Date(124, Calendar.AUGUST, 23));

        when(subtaskRepository.save(subtask)).thenReturn(subtask);

        subtaskService.addSubtask(subtask);

        verify(subtaskRepository, times(1)).save(subtask);
        assertEquals("pending", subtask.getStatus());
    }

    @Test
    public void testUpdate() {
        Subtask subtask = new Subtask();
        subtask.setTaskId(13);
        subtask.setStatus("completed");
        subtask.setTitle("Updated Subtask");
        subtask.setDueDate(new Date());

        when(subtaskRepository.save(subtask)).thenReturn(subtask);

        subtaskService.updateSubtask(subtask);

        verify(subtaskRepository, times(1)).save(subtask);
    }

    @Test
    public void testGet() {
        Subtask subtask = new Subtask();
        subtask.setStatus("pending");

        when(subtaskRepository.findById(28)).thenReturn(Optional.of(subtask));

        Subtask retrievedSubtask = subtaskService.getSubTaskById(28);
        assertEquals("pending", retrievedSubtask.getStatus());
    }

    @Test
    public void testDelete() {
        int id = 33;

        when(subtaskRepository.existsById(id)).thenReturn(true);
        doNothing().when(subtaskRepository).deleteById(id);

        subtaskService.deleteSubtask(id);

        verify(subtaskRepository, times(1)).deleteById(id);
        when(subtaskRepository.findById(id)).thenReturn(Optional.empty());
        Subtask deletedSubtask = subtaskService.getSubTaskById(id);
        assertNull(deletedSubtask);
    }
}
