package com.itclopedia.courses.dao;

import com.itclopedia.courses.models.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProjectDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertProject(Project project) {
        entityManager.persist(project);
    }

    public void deleteProject(int projectId) {
        Project project = entityManager.find(Project.class, projectId);
        if (project != null) {
            entityManager.remove(project);
        }
    }

    public void updateProject(Project project) {
        entityManager.merge(project);
    }

    public Project getProjectById(int projectId) {
        return entityManager.find(Project.class, projectId);
    }
}