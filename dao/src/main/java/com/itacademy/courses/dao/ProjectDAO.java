package com.itacademy.courses.dao;

import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.models.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ProjectDAO {
    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void insertProject(Project project) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(project);
            transaction.commit();
        }
    }

    public boolean deleteProject(int projectId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Project project = session.get(Project.class, projectId);
            if (project != null) {
                session.remove(project);
                transaction.commit();
                return true;
            }
            return false;
        }
    }

    public boolean updateProject(Project project) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(project);
            transaction.commit();
            return true;
        }
    }

    public Project getProjectById(int projectId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Project.class, projectId);
        }
    }
}
