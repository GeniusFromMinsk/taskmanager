package com.itacademy.courses.dao;

import com.itacademy.courses.db.HibernateSessionFactoryUtil;
import com.itacademy.courses.enums.TaskFilter;
import com.itacademy.courses.models.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TaskDAO {

    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public void insertTask(Task task) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(task);
            transaction.commit();
        }
    }

    public Task selectTask(int taskId) {
        Task task;
        try (Session session = sessionFactory.openSession()) {
            task = session.get(Task.class, taskId);
        }
        return task;
    }

    public List<Task> selectAllTasks() {
        List<Task> tasks = null;
        try (Session session = sessionFactory.openSession()) {
            tasks = session.createQuery("from Task", Task.class).list();
        }
        return tasks;
    }

    public boolean deleteTask(int taskId) {
        boolean rowDeleted = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Task task = session.get(Task.class, taskId);
            if (task != null) {
                session.remove(task);
                transaction.commit();
                rowDeleted = true;
            }
        }
        return rowDeleted;
    }

    public boolean updateTask(Task task) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(task);
            transaction.commit();
            return true;
        }
    }

    public List<Task> selectTasksByFilter(TaskFilter filter, String filterValue) {
        List<Task> tasks = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Task> query = session.createQuery(filter.getQuery(), Task.class);
            query.setParameter("value", filterValue);
            tasks = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
