package com.itclopedia.courses.services;

import com.itclopedia.courses.dao.SubtaskRepository;
import com.itclopedia.courses.dao.TaskRepository;
import com.itclopedia.courses.dto.SubtaskDTO;
import com.itclopedia.courses.exceptions.EntityAlreadyExistsException;
import com.itclopedia.courses.mapper.SubtaskMapper;
import com.itclopedia.courses.models.Subtask;
import com.itclopedia.courses.exceptions.EntityNotFoundException;
import com.itclopedia.courses.models.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubtaskService {

    private final SubtaskRepository subtaskRepository;
    private final TaskRepository taskRepository;
    private final SubtaskMapper subtaskMapper = SubtaskMapper.INSTANCE;


    @Autowired
    public SubtaskService(SubtaskRepository subtaskRepository, TaskRepository taskRepository) {
        this.subtaskRepository = subtaskRepository;
        this.taskRepository = taskRepository;
    }

    public void addSubtask(SubtaskDTO subtaskDTO) {
        Subtask subtask = subtaskMapper.toSubtask(subtaskDTO, taskRepository);
        Task task = taskRepository.findById(subtaskDTO.getTaskId())
                .orElseThrow(() -> new EntityAlreadyExistsException("Subtask", subtask.getId()));

        subtask.setTask(task);
        if (subtaskRepository.existsById(subtask.getId())) {
            throw new EntityAlreadyExistsException("Subtask", subtask.getId());
        }
        subtaskRepository.save(subtask);
    }

    public void updateSubtask(SubtaskDTO subtaskDTO) {
        Subtask subtask = subtaskMapper.toSubtask(subtaskDTO, taskRepository);
        Task task = taskRepository.findById(subtaskDTO.getTaskId())
                .orElseThrow(() -> new EntityNotFoundException("Subtask", subtask.getId()));
        subtask.setTask(task);

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

    public SubtaskDTO getSubtaskById(int subtaskId) {
        Subtask subtask = subtaskRepository.findById(subtaskId)
                .orElseThrow(() -> new EntityNotFoundException("Subtask", subtaskId));
        return subtaskMapper.toSubtaskDTO(subtask);
    }
}
