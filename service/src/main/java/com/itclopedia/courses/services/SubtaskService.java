package com.itclopedia.courses.services;

import com.itclopedia.courses.models.Subtask;
import com.itclopedia.courses.dao.SubtaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubtaskService {

    private final SubtaskRepository subtaskRepository;

    @Autowired
    public SubtaskService(SubtaskRepository subtaskRepository) {
        this.subtaskRepository = subtaskRepository;
    }

    public void addSubtask(Subtask subtask) {
        subtaskRepository.save(subtask);
    }

    public void deleteSubtask(int subtaskId) {
        subtaskRepository.deleteById(subtaskId);
    }

    public void updateSubtask(Subtask subtask) {
        subtaskRepository.save(subtask);
    }

    public Subtask getSubTaskById(int id) {
        return subtaskRepository.findById(id).orElse(null);
    }
}
