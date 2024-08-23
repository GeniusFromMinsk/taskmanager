package com.itacademy.courses.dao;

import com.itacademy.courses.models.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CategoryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertCategory(Category category) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(category);
            transaction.commit();
        }
    }

    public boolean updateCategory(Category category) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(category);
            transaction.commit();
            return true;
        }
    }

    public boolean deleteCategory(int categoryId) {
        try (Session session = sessionFactory.openSession())  {
            Transaction transaction = session.beginTransaction();
            Category category = session.get(Category.class, categoryId);
            if (category != null) {
                session.remove(category);
                transaction.commit();
                return true;
            }
            return false;
        }
    }

    public Category getCategoryById(int categoryId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Category.class, categoryId);
        }
    }
}
