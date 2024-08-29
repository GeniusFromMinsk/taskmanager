package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.SubtaskDAO;
import com.itclopedia.courses.models.Subtask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubtaskService {
    private final SubtaskDAO subtaskDAO;

    @Autowired
    public SubtaskService(SubtaskDAO subtaskDAO) {
        this.subtaskDAO = subtaskDAO;
    }

    public void addSubtask(Subtask subtask) {
        subtaskDAO.insertSubtask(subtask);
    }
    public boolean deleteSubtask(int subtaskId) {
        return subtaskDAO.deleteSubtask(subtaskId);
    }

    public boolean updateSubtask(Subtask subtask) {
        return subtaskDAO.updateSubtask(subtask);
    }

    public Subtask getSubTaskById(int id) {
        return subtaskDAO.getSubtaskById(id);
    }
}