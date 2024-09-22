package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.SubtaskRepository;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsException;
import com.itclopedia.courses.models.Subtask;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
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
        if (subtaskRepository.existsById(subtask.getId())) {
            throw new EntityAlreadyExistsException("Subtask", subtask.getId());
        }
        subtaskRepository.save(subtask);
    }

    public void updateSubtask(Subtask subtask) {
        if (!subtaskRepository.existsById(subtask.getId())) {
            throw new EntityNotFoundException("Subtask", subtask.getId());
        }
        subtaskRepository.save(subtask);
    }

    public void deleteSubtask(int subtaskId) {
        if (!subtaskRepository.existsById(subtaskId)) {
            throw new EntityNotFoundException("Subtask", subtaskId);
        }
        subtaskRepository.deleteById(subtaskId);
    }

    public Subtask getSubtaskById(int id) {
        return subtaskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subtask", id));
    }
}
