package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.Subtask;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class SubtaskDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertSubtask(Subtask subtask) {
        entityManager.persist(subtask);
    }

    public boolean deleteSubtask(int subtaskId) {
        Subtask subtask = entityManager.find(Subtask.class, subtaskId);
        if (subtask != null) {
            entityManager.remove(subtask);
            return true;
        }
        return false;
    }

    public boolean updateSubtask(Subtask subtask) {
        entityManager.merge(subtask);
        return true;
    }

    public Subtask getSubtaskById(int id) {
        return entityManager.find(Subtask.class, id);
    }
}
