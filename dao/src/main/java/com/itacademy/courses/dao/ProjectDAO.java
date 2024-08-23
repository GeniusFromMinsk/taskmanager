package com.itacademy.courses.dao;

import com.itacademy.courses.models.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertProject(Project project) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(project);
            transaction.commit();
        }
    }

    public void deleteProject(int projectId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Project project = session.get(Project.class, projectId);
            session.remove(project);
            transaction.commit();
        }
    }

    public void updateProject(Project project) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(project);
            transaction.commit();
        }
    }

    public Project getProjectById(int projectId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Project.class, projectId);
        }
    }
}

