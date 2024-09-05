package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.SubtaskDAO;
import com.itclopedia.courses.models.Subtask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubtaskService {

    private final SubtaskDAO subtaskDAO;

    @Autowired
    public SubtaskService(SubtaskDAO subtaskDAO) {
        this.subtaskDAO = subtaskDAO;
    }

    public void addSubtask(Subtask subtask) {
        log.info("Adding subtask: {}", subtask);
        subtaskDAO.insertSubtask(subtask);
        log.info("Subtask added successfully: {}", subtask);
    }

    public boolean deleteSubtask(int subtaskId) {
        log.info("Deleting subtask with ID: {}", subtaskId);
        boolean isDeleted = subtaskDAO.deleteSubtask(subtaskId);
        if (isDeleted) {
            log.info("Subtask deleted successfully with ID: {}", subtaskId);
        } else {
            log.warn("Failed to delete subtask with ID: {}", subtaskId);
        }
        return isDeleted;
    }

    public boolean updateSubtask(Subtask subtask) {
        log.info("Updating subtask: {}", subtask);
        boolean isUpdated = subtaskDAO.updateSubtask(subtask);
        if (isUpdated) {
            log.info("Subtask updated successfully: {}", subtask);
        } else {
            log.warn("Failed to update subtask: {}", subtask);
        }
        return isUpdated;
    }

    public Subtask getSubTaskById(int id) {
        log.info("Fetching subtask with ID: {}", id);
        Subtask subtask = subtaskDAO.getSubtaskById(id);
        if (subtask != null) {
            log.info("Subtask found: {}", subtask);
        } else {
            log.warn("Subtask not found with ID: {}", id);
        }
        return subtask;
    }
}
