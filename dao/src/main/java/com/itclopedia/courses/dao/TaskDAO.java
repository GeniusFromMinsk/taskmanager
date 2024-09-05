package com.itclopedia.courses.dao;

import com.itclopedia.courses.enums.TaskFilter;
import com.itclopedia.courses.models.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TaskDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertTask(Task task) {
        entityManager.persist(task);
    }

    public Task selectTask(int taskId) {
        return entityManager.find(Task.class, taskId);
    }

    public List<Task> selectAllTasks() {
        return entityManager.createQuery("from Task", Task.class).getResultList();
    }

    public boolean deleteTask(int taskId) {
        Task task = entityManager.find(Task.class, taskId);
        if (task != null) {
            entityManager.remove(task);
            return true;
        }
        return false;
    }

    public boolean updateTask(Task task) {
        entityManager.merge(task);
        return true;
    }

    public List<Task> selectTasksByFilter(TaskFilter filter, String filterValue) {
        try {
            return entityManager.createQuery(filter.getQuery(), Task.class)
                    .setParameter("value", filterValue)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
